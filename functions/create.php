<?php

include_once '../includes/create.class.php';
include_once '../includes/view.class.php';
include('../config.php');

$conn_create_user = new Create_class();


//web create function --start 
if(isset($_REQUEST['reg-btn'])){
 
  
$name=mysqli_real_escape_string($conn_create_user->connection,$_REQUEST['fullname']);
$username=mysqli_real_escape_string($conn_create_user->connection,$_REQUEST['username']);
$password=mysqli_real_escape_string($conn_create_user->connection,$_REQUEST['password']);
$Encrypt_password=password_hash($password,PASSWORD_DEFAULT);

//check if already exist username


$conn_check_user_web = new View_class();
$check_web = $conn_check_user_web->check_user($username);

if($check_web->num_rows >=1){

    
   
       echo"<script>alert('Username is already taken!');</script>";
        echo"<script>window.location.href='../index.php';</script>";
    
  
    }
    
    elseif($check_web->num_rows<1){
    
        $add_user_web=$conn_create_user->create_new_user($name,$username,$Encrypt_password);
        if($add_user_web){
        
            echo"<script>alert('successfully added new record!');</script>";
        echo"<script>window.location.href='../index.php';</script>";
        }
   
    }
   

     
 
    if(empty($_GET['access_token'])) {
        echo"<script>alert('error!!');</script>";
        echo"<script>window.location.href='../index.php';</script>";
        exit;}
  
}




 
//web create function --end

//android  create function start




    if($_SERVER["REQUEST_METHOD"]="POST"){
        
             
            if(isset($_SESSION['access_token']) || isset($_POST['access_token'])){

                header("Access-Control-Allow-Origin: http://localhost/android_crud_mysql/");
                header("Content-Type: application/json; charset=UTF-8");
                header("Access-Control-Allow-Methods: POST");
                header("Access-Control-Max-Age: 3600");
                header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
            
                $name=mysqli_real_escape_string($conn_create_user->connection,$_REQUEST['fullname']);
                $username=mysqli_real_escape_string($conn_create_user->connection,$_REQUEST['username']);
                $password=mysqli_real_escape_string($conn_create_user->connection,$_REQUEST['password']);
                $Encrypt_password=password_hash($password,PASSWORD_DEFAULT);
                
                $conn_check_user_android = new View_class();
                $check = $conn_check_user_android->check_user($username);
                
                if($check->num_rows >=1){
                
                    $response = array();
                //for android message error
                   $response['error'] = true;
                   $response ['message']="Username is Already Taken!";
                   
                   header('Content-type:application/json');
                   echo json_encode($response);
                //end
                }
                
                else{
                    $response = array();
                    $add_user=$conn_create_user->create_new_user($name,$username,$Encrypt_password);
                    if($add_user){
                    
                        
                        $response['error']=false;
                        $response ['message']= "Successfully added new record!";
                        header('Content-type:application/json');
                         echo json_encode($response);
                    }

                    else{
                    
                        echo "Error Insert!";
                    }
                }
                
         }
                //android create function end
            
            //}
                else {
                    
                    
                    $response = array();
                    //for android message error
                    $response['error'] = true;
                    $response ['message']="Not Authorize!";
                    header('Content-type:application/json');
                 
                    echo json_encode($response);
                }
             
     }
     else if(empty($_GET['access_token'])) {
         
        $response = array();
        //for android message error
        $response['error'] = true;
        $response ['message']="Not Authorize!";
        header('Content-type:application/json');
     
        echo json_encode($response);
        exit;
    }
        
   // }




?>