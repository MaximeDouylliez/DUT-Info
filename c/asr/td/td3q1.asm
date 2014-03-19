global main
	extern scanf
	extern printf	
	extern exit
	extern putchar

segment .data
lol: db "nombre entre 1 et 3",0ah,0h
demande: db "(ifs:!) entrez une phrase de 49 caractères maximum" ,0ah,0h 
format:	 db "%s",0
formatc: db"%c",0
formatd: db"%d",0
temp:	 db "le nombre est :",0h
ligne:	 db " " ,0ah,0h

segment .bss
buff resb 50
go resb 1



segment .txt

main:

push dword lol
call printf
push go
push dword formatd
call scanf

mov ebx,[go]
cmp ebx,1
je part1

cmp ebx,2
je part2

cmp ebx,3
je part3

part1:
call si1
jmp end

part2:
call si2
jmp end

part3:
call si3
jmp end

end:
push 0
call exit

si3:
	push ebp
	mov ebp,esp	
	push dword demande
	call printf
	push buff
	push format
	call scanf
	add esp,12


	xor ebx,ebx
	mov esi,buff
	
comptersi3:
;;on compte le nombre d'element grace a ebx
	cmp dword [esi],0
	je suite
	
	inc esi
	inc ebx
	jmp comptersi3

suite:	
	dec esi
	
affichersi3:
	push dword [esi]
	call putchar
	add esp,4
	dec ebx
	dec esi
	
	cmp ebx,0
	jne affichersi3	

pop ebp
ret

si1:

push ebp
mov ebp,esp

mov ebx,10
	
	
affichersi1:
	;; la boucle affiche la valeur pui la décremente
	push dword temp
	call printf
	
	push ebx
	push formatd
	call printf

	
	push dword ligne
	call printf
	dec ebx
	add esp,16


	;; reboucle si la valeur supérieure a -1
	cmp ebx,-1
	jg affichersi1

pop ebp 
ret

si2:

push ebp
mov ebp,esp

mov ebx,0
	
	
affichersi2:
	;; la boucle affiche la valeur pui la décremente
	push dword temp
	call printf
	
	push ebx
	push formatd
	call printf

	
	push dword ligne
	call printf
	inc ebx
	add esp,16


	;; reboucle si la valeur supérieure a -1
	cmp ebx,11
	jl affichersi2

pop ebp 
ret
