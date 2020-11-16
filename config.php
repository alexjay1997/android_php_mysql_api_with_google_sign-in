<?php

//config.php

require_once 'vendor/autoload.php';

$google_client = new Google_Client();

$google_client->setClientId('972081733126-anen5n0qolmvapqdkdniinieuvubf6cl.apps.googleusercontent.com');

$google_client->setClientSecret('PEhvzXBpRHpxsKkjK_wvf6iW');

$google_client->setRedirectUri('http://localhost/android_crud_mysql/index.php');

$google_client->addScope('email');

$google_client->addScope('profile');

session_start();
?>