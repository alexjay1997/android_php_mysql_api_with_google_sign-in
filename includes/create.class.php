<?php
include 'dbh.inc.php';

class Create_class extends Database{

    public function __construct(){
        $this->db_connection();
    }
    public function create_new_user($name,$username,$Encrypt_password){

        $query="Insert Into tbl_android_users(fullname,username,password) values ('$name','$username','$Encrypt_password')";
        $result=mysqli_query($this->connection,$query);
        return $result;
        

    }

   public function update_user($user_id,$name,$username,$Encrypt_password){

        $query="Update tbl_android_users set fullname='$name', username='$username', password='$Encrypt_password' WHERE id ='$user_id'";
       $result=mysqli_query($this->connection,$query);
       return $result;
        

    }
}
?>