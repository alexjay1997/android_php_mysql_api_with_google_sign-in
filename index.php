<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
        <style>
        body{
           
            background-size:cover;
            background-repeat:no-repeat;

        }
        </style>
    </head>
    <body>
<?php

include('config.php');

$login_button='';

if(isset($_GET["code"])){

    $token = $google_client->fetchAccessTokenWithAuthCode($_GET["code"]);

    if(!isset($token['error'])){

        $google_client->setAccessToken($token['access_token']);

        $_SESSION['access_token'] =$token['access_token'];
        
        $google_service = new Google_Service_Oauth2($google_client);

        $data = $google_service->userinfo->get();// will return google profile ,username,email

        if(!empty($data['given_name'])){

            $_SESSION['user_first_name']=$data['given_name'];
        }
        if(!empty($data['family_name'])){

            $_SESSION['user_last_name']=$data['family_name'];
        }
        if(!empty($data['email'])){

            $_SESSION['user_email_address']=$data['email'];
        }

        if(!empty($data['gender'])){

            $_SESSION['user_gender']=$data['gender'];
        }
        if(!empty($data['picture'])){

            $_SESSION['user_image']=$data['picture'];
        }
    
    }
}


if(!isset($_SESSION['access_token'])){



    $login_button='
    
    <div class="login-wrapper" style="font-family:calibri,sans-serif;color:#ec645d;width:200px;height:auto;margin:50px auto;padding:50px;box-shadow:1px 1px 4px 1px #ccc;border-radius:20px;background-image:url(./img/login-bg.png);background-position:bottom;">
    <div class="avatar-wrapper" style="margin:0 auto:width:100px;height:auto;">
            <img src="img/login-avatar.png"/ style="width:130px; #ddd;border-radius:300px;padding:0;box-shadow:2px 1px 4px 1px #713555 ;">
        </div><br>
        <h2>User Login</h2>
       
    <a href="'.$google_client->createAuthUrl().'"><img src="img/sign-in-with-google.png" style="width:180px;
    box-shadow: 10px 10px 30px #eee, -2px -8px 126px #f2f2f2;border-radius:30px;margin:40px auto;"/></a></div>
    </div>
    
    ';
       
    
    }




if($login_button==''){

    echo '<div class="panel-heading">Welcome User</div>
    
    <div class="panel-body">';

    echo'<img src="'.$_SESSION['user_image'].'" class="img-responsive img-circle img-thumbnail" />';

    echo '<h3><b>Name : </b> '.$_SESSION['user_first_name'].' '.$_SESSION['user_last_name'].'</h3>';

    echo '<h3><a href="logout.php">Logout</a></h3>
    
    
    </div>';
   // echo $_SESSION['access_token'];


    include 'register.php';//include the register page 





    
}
else{

    echo '<div align="center">'.$login_button.'</div>';
}
   ?>



<body></html>