typedef fl file;



file createFifo();//creation de file
file add_fifo(file f,client c);//ajout d'un client dans la file
file sub_fifo(file f,client c);//retrait d'un client dans la file
bool file_is_empty(file f);//vide ou pas ?
bool file_is_full(file f);//pleine ou pas ?
