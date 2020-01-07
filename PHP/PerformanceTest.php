<?php
    $start = microtime(true);
    for ($x=0; $x<1000000; $x++) {
      $str = 'aaaaaaaaaa';
      $hash = hash('sha256', $str);
      //echo($hash);
      //echo("<br/>");
    }
    $end = microtime(true);
    echo("<br/>");
    echo("<br/>");
    echo("<br/>");
    echo(($end - $start)*1000000);
?>
