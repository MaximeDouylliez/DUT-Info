global main
extern printf
extern scanf
extern exit
	
segment .data
	demande db " entrez deux phrase vite faite",0ah,0h
	format "%s",0
segment .bss
	buffer1 resb 20
	buffer2 resb 20
buffer3 resb 100	
segment .text
main:
	push dword demande
	call printf
	
	push buffer1
	push dword format
	call scanf
	
	push buffer2
	push dword format
	call scanf
	
	add esp,20

call fonction

add esp,4*ebx

affichage:
cmp ebx,0
je suite
push format2
call printf
	
push 0
call exit

fonction :
	push ebp
	mov ebp,esp
	xor ebx,ebx
push 0
inc ebx
	
	mov esi,buffer1
	mov edi,buffer2

boucle:
cmp [esi],0
jne motun
cmp [edi],0
jne motdeux
jmp fin



motun:
push dword [esi]
inc esi
inc ebx
cmp [edi],0
je boucle
jmp motdeux

motdeux:
push dword[edi]
inc edi
inc ebx
jmp boucle

fin:
pop ebp
ret
