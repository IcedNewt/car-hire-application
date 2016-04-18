package uk.ac.ncl.project.car_hire_application;
$puts(normalcolor,150-100-100)
$puts(hovercolor,220-150-150)
$puts(linecolor,200-100-100)
$puts(activecolor,200-100-100)
$puts(brushcolor,78-78-78)
$font(Montecarlo,8)

$showpanel_c(%view_mode%,1)
$drawrect(4,20,$sub(%_width%,8),1,$get(linecolor),$get(linecolor),)




// Playlist

$if($strcmp($get_ps_global(view_mode),ELPlaylist),$puts(color,$get(activecolor)),$puts(color,$get(normalcolor)))
$textbutton(185,0,48,20,Playlist,Playlist,
   PANELSHOW:ELPlaylist:1;
   PANELSHOW:Biography:0;
   PANELSHOW:Library:0;
   SETGLOBAL:view_mode:ELPlaylist;
   REFRESH,
   fontcolor:$get(color),brushcolor:$get(brushcolor) fontcolor:$get(hovercolor))



// Biography

$if($strcmp($get_ps_global(view_mode),Biography),$puts(color,$get(activecolor)),$puts(color,$get(normalcolor)))
$textbutton(240,0,60,20, Biography, Biography,
   PANELSHOW:ELPlaylist:0;
   PANELSHOW:Biography:1;
   PANELSHOW:Library:0;
   SETGLOBAL:view_mode:Biography;
   REFRESH,
   fontcolor:$get(color),brushcolor:$get(brushcolor) fontcolor:$get(hovercolor))



// Library

$if($strcmp($get_ps_global(view_mode),Library Tree),$puts(color,$get(activecolor)),$puts(color,$get(normalcolor)))
$textbutton(312,0,43,20,Library,Library,
   PANELSHOW:ELPlaylist:0;
   PANELSHOW:Biography:0;
   PANELSHOW:Library:1;
   SETGLOBAL:view_mode:Library Tree;
   REFRESH,
  fontcolor:$get(color), brushcolor:$get(brushcolor) fontcolor:$get(hovercolor))


//  Refresh Playlist

$textbutton(354,0,$sub(%_width%,455),19, , ,
   COMMAND:View/ELPlaylist/Refresh,
,)


//  Collapse-Expand Playlist

$font(Segoe UI Symbol,9)
$textbutton($sub(%_width%,45),-1,13,20,∧,∧,
   COMMAND:View/ELPlaylist/Collapse all groups;
   COMMAND:View/ELPlaylist/Show $ifequal($get_ps_global(pl_show),0,focused item,now playing),
   fontcolor:$get(normalcolor),brushcolor:$get(brushcolor) fontcolor:$get(hovercolor))
$textbutton($sub(%_width%,33),-1,13,20,∨,∨,
   COMMAND:View/ELPlaylist/Expand all groups;
   COMMAND:View/ELPlaylist/Show $ifequal($get_ps_global(pl_show),0,focused item,now playing),
   fontcolor:$get(normalcolor),brushcolor:$get(brushcolor) fontcolor:$get(hovercolor))


// Edit

$font(Segoe UI Symbol,11)
$textbutton($sub(%_width%,19),-3,19,22,✓,✓,
   PANELSHOW:ELPlaylist:1;
   PANELSHOW:Lyrics:0;
   PANELSHOW:Biography:0;
   SETGLOBAL:view_mode:ELPlaylist;
   PANELSHOW:EditButtons:-1;
   PANELSHOW:LeftPanel:-1;
   PANELSHOW:Properties:-1,
   fontcolor:$get(normalcolor),brushcolor:$get(brushcolor) fontcolor:$get(hovercolor))



