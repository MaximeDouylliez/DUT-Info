	;; douylliez maxime
global main

	extern scanf
	extern printf
	extern exit
	extern putchar
	

segment .data
demande: db "(ifs:!) entrez une phrase de 49 caractères maximum" ,0ah,0h 
format:	 db "%s",0
formatc: db"%c",0
	
segment .bss
	buff resb 50



	
segment .text
main:
	;; on demande et recupere la phrase: 10 premiers element seront récupérés
	push dword demande
	call printf
	push buff
	push format
	call scanf
	add esp,12


	xor ebx,ebx
	mov esi,buff
	
compter:
;;on compte le nombre d'element grace a ebx
	cmp dword [esi],0
	je suite
	
	inc esi
	inc ebx
	jmp compter

suite:	
	dec esi
	
afficher:
	push dword [esi]
	call putchar
	add esp,4
	dec ebx
	dec esi
	
	cmp ebx,0
	jne afficher	
	
	push 0
	call exit