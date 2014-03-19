	;; douylliez maxime
global main

	extern scanf
	extern printf
	extern exit

segment .data
annonce:	db "veuillez entrer un nombre au clavier entre 0 et 255",0ah,0h
temp:	 db "le nombre est :",0h
format:	 db "%d",0
ligne:	 db " " ,0ah ,0h



	
segment .bss
buff resb 1 



	
segment .text
main:
	
	;;on demande et on stock le nombre 
	push dword annonce
	call printf
	push buff
	push format
	call scanf
	add esp,12

	;; la valeur a afficher servira elle meme de compteur de boucle
	mov ebx,[buff]
	
	
afficher:
	;; la boucle affiche la valeur pui la décremente
	push dword temp
	call printf
	
	push ebx
	push format
	call printf

	
	push dword ligne
	call printf
	dec ebx
	add esp,16


	;; reboucle si la valeur supérieure a -1
	cmp ebx,-1
	jg afficher

	push 0
	call exit
	

	