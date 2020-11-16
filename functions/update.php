<?php
include_once '../includes/create.class.php';
include_once '../includes/view.class.php';
$conn_update = new Create_class();

if(isset($_POST['update-btn'])){
  
$user_id=$_GET['id'];   
$name=mysqli_real_escape_string($conn_update->connection,$_POST['fullname']);
$username=mysqli_real_escape_string($conn_update->connection,$_POST['username']);
$password=mysqli_real_escape_string($conn_update->connection,$_POST['password']);
$Encrypt_password=password_hash($password,PASSWORD_DEFAULT);

$conn_check_user_web = new View_class();
$check_web = $conn_check_user_web->check_user($username);

if($check_web->num_rows >=1){

    
   
       echo"<script>alert('Please Enter different UserName!');</script>";
        echo"<script>window.location.href='../index.php';</script>";
    
  
    }
    else{
        $update_user=$conn_update->update_user($user_id,$name,$username,$Encrypt_password);
        if($update_user){
        
            echo"<script>alert('User Name Has been Updated');</script>";
        echo"<script>window.location.href='../index.php';</script>";
        }
        else{

            echo "Error update!";
        }

    }



}

?>