<?php
include 'view.api.android.php';
$conn_select_all_users = new View_api_android_class();

$read_all_user = $conn_select_all_users->select_all_users();

if($read_all_user->num_rows >0){

        while($rows = $read_all_user->fetch_assoc()){

            $data_users[] = $rows;
        }
        // required headers
header("Access-Control-Allow-Origin: http://192.168.50.146/android_crud_mysql/");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        echo json_encode(array("users"=>$data_users));
}



?>