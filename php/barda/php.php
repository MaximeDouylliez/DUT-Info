
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" >

<head>
<title>Formulaires</title>
<meta http-equiv="Content-Type" content="text/html;charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="cv.css"/>
</head>
<body>


semestre pr�cedent: <?php echo $_POST['sem']/>
<?php if(!$_POST['sem'])
echo "Vous n'avez pas eu votre trismetre pr�cedent, moyenne =";
echo $_POST['moysem']<br/>/>

<br/>

semestre: <?php echo $_POST['moysemcour']/>

<?php if(($_POST['sem']+$_POST['moysemcour']/2)>10 && $_POST['sem']>8 && $_POST['moysemcour']>8)
echo you got u'r grade !<br/>
echo else triste t'as pas reussi<br/>/>



</body>