;;douylliezmaxime
global main
	extern printf
	extern exit

	segment .data

informatique:	db "informatique" ,0ah,0h
format:	 db "%c",0h
passageL: db " ",0ah,0h

segment .bss
segment .text
main:	


	mov esi,informatique
	add esi,11
	mov ebx,11

afficher:
	dec esi
	push dword [esi]
	push format
	call printf

	dec ebx
	cmp ebx,0

	jne afficher

		push passageL
	call printf
	
	push 0
	call exit
