global main

extern printf 
extern scanf
extern putchar
extern exit

segment .data

msg: db "Veuillez rentrer un mot!",0ah,0h
formatint: db "%s", 0h
formatout: db "%d",0h
segment .bss
buffer resb 50

segment .text
	main:
	
	push msg
	call printf
	add esp, 4

		
	push buffer
	push formatint
	call scanf
	add esp,8

	mov esi, buffer
	push dword esi
	call nbchar


push 0
call exit

nbchar:

	push ebp
	mov ebp, esp
	xor ebx,ebx
	mov esi, dword [ebp + 8]
	

l1:
	inc esi
	inc ebx
	cmp dword [esi], 0
	jne l1

	
	push ebx 
	push formatout
	call printf
	add esp, 8

	push dword 0ah
	call putchar
	add esp, 4

	pop ebp
	ret 4

