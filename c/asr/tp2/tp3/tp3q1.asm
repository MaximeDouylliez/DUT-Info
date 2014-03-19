global main
	extern scanf
	extern printf
	extern exit
	
segment .data
	
phrase:	db "entrez un nombre entre 1 et 10",0ah,0h
d:	db "%d",0
resu:	db "le resultat est ",0
error:	db "Aprennez a compter !",0
ligne:	db "",0ah,0
	
segment .bss
buffer:	 resb 1


segment .text
main:
	xor eax,eax
	xor ebx,ebx
	
	push dword phrase	;on affiche on recupere la valeur
	call printf
	push buffer
	push d
	call scanf
	add esp,12
	
	mov ebx,[buffer]  
	cmp ebx,10		;erreur si valeur>10
	jg erreur

	cmp ebx,0		;erreur si valeur<0
	jl erreur
	
	
	mov eax,1		;valeur par defaut
	cmp ebx,2		;valeur obligé au dessu de -1
	jl off			;aff si inferieur a 2 car entre 0<=x<=1

	
	call facto

	
off:

	push dword ligne	
	push dword resu
	call printf		;aff phrase
	
	mov eax,[buffer]	;recuperation du resultat
	push eax
	push dword d
	call printf
	
	add esp,12		;pour arriver a push ligne
	
	call printf
	add esp,4
	jmp end

erreur:
	push dword ligne
	push dword error
	call printf
	add esp,4
	call printf
	add esp,4
	jmp end
	
end:
	push 0
	call exit
facto:
	push ebp
	mov ebp,esp		;prologue
	
	mul ebx
	cmp ebx,2
	je aff
	
	dec ebx
	call facto
	
aff:
	mov dword [buffer],eax	;printf va pourir la valeur on la sauvegarde
	pop ebp			;épilogue
	ret

		
	;; bon. pour faire du recursif, il faut faire n prologue
	;; unique prologue