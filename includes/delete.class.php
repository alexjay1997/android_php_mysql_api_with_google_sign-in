<?php
include 'dbh.inc.php';

class Delete_class extends Database{

    public function __construct(){
        $this->db_connection();
    }
    public function delete_user($user_id){
        $query="delete from tbl_android_users where id ='$user_id'";
        $result=mysqli_query($this->connection,$query);
        return $result;
    }
}
?>