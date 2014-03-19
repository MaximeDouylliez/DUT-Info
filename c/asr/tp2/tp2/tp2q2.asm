global main
extern printf
extern scanf
extern exit
extern putchar
	
segment .data
	demande db " entrez deux phrase vite faite",0ah,0h
	format db "%s",0h
cc db "lol",0ah,0h
ccc db "sousprogtermine",0ah,0h
for db "%d",0h
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
push dword cc
call printf	
	add esp,20


call fonction


pusherlemotfinal:
push dword cc
call printf
add esp,4
cmp dword [esi],0
je fin
push dword [esi]
dec esi
jmp pusherlemotfinal

push dword ccc
call printf


lol:
cmp edx,0
je end
call putchar
add esp,4
jmp lol

	end:
push 0
call exit

fonction :
	push ebp
	mov ebp,esp
	xor ebx,ebx
	
	mov esi,buffer1
	mov edi,buffer2
push dword cc
call printf
add esp,4
boucle:
cmp dword [esi],0
jne motun
cmp dword [edi],0
jne motdeux
jmp preparation



motun:
push dword [esi]
inc esi
inc ebx
cmp dword [edi],0
je boucle
jmp motdeux

motdeux:
push dword [edi]
inc edi
inc ebx
jmp boucle

preparation:
push dword cc
call printf
add esp,4
push 0
inc ebx
xor edx,edx
add edx,ebx
push edx
push for
call printf
push ebx
push for
call printf 
add esp,16
mov esi,buffer3

inverserlapile:
push dword cc
call printf
add esp,4
cmp dword ebx,0
je suu

pop dword [esi]
dec ebx
inc esi
jmp inverserlapile

suu:
push dword ccc
call printf
add esp,4
	xor ebx,ebx
	add ebx,edx
push edx
push for
call printf
push ebx
push for
call printf 
add esp,16
	mov esi,buffer3


eee:
push dword [ebx]
push dword for
call printf
add esp,8
push dword ccc
call printf
add esp,4
cmp dword [ebx],0
jg fin
dec ebx
add esp,4
jmp eee

fin:
push dword ccc
call printf
add esp,4
pop ebp
ret
