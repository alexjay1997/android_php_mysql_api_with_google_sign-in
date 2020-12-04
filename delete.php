<?php
include 'includes/delete.class.php';
$conn_delete_user = new Delete_class();

if($_SERVER["REQUEST_METHOD"]="POST"){

$user_id = $_POST['id'];
$delete_user =$conn_delete_user->delete_user($user_id);

//if($delete_user){
   // header('location:index.php');
//}

//else{

   // echo "failed to Delete!";
//}
}
?>