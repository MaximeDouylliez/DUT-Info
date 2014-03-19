	;; douylliez maxime
global main

	extern scanf
	extern printf
	extern exit

segment .data
annonce:	db "veuillez entrer un nombre au clavier",0ah,0h
annonce2:	 db "veuillez entrez un autre nombre svp" ,0ah,0h
format:	 db "%d",0
ligne:	 db " " ,0ah ,0h
annonce3:	 db "le resultat de la somme de vos deux nombres est :",0



	
segment .bss
buff resd 1
buff2 resd 1



	
segment .text
main:

	;; on demande et on stock le nombre
	push dword annonce
	call printf
	push buff          
	push format
	call scanf
	add esp,12

	;;on demande et on stock le second nombre
	push dword annonce2 
	call printf
	push buff2
	push format
	call scanf
	add esp,12
	
	push annonce3
	call printf
	;;on fait la somme
	mov ebx,[buff]
	add ebx,[buff2]

	;; on affiche le resultat
	

	push ebx
	push format
	call printf

	push ligne
	call printf
	add esp,16
	
	push 0
	call exit