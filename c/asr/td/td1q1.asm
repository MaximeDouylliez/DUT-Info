global main
extern scanf
extern printf
extern exit

segment .data
annonce: db "entrez un nombre entre 1 et 10",0 
resu: db " votre nombre est",0
format: db  "%d",0

segment .bss
buff: resd 1

segment .text
main:	

push annonce
call printf
add esp,4
push dword buff
push format
call scanf
add esp,8
mov ebx,[buff]
cmp ebx,5
jg greater
	
push 0 
call exit
	
greater:
push resu
call printf
add esp,4
push dword buff
push format
call printf
add esp,8
push 0
call exit