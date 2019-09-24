#include <stdio.h>
#include <stdlib.h>

typedef struct no{
  int valor;
  struct no * proximo;
} list;
typedef list * lista;

lista createNode(){
    lista temp;
    temp = (lista)malloc(sizeof(struct no));
    temp->proximo = NULL;
    return temp;
}

lista addNode(lista head, int value){
    lista temp,p;
    temp = createNode();
    temp->valor = value;
    if(head == NULL){
        head = temp;
    }
    else{
        p = head; 
        while(p->proximo != NULL){
            p = p->proximo;
        }
        p->proximo = temp;
    }
    return head;
}
void printList(lista head){
  while(head != NULL){
    printf("%i -> ", head->valor);
    if(head->proximo == NULL) printf("NULL\n");
    head = head->proximo; 
  }
}
lista removeLastNode(lista head){
  if(head->proximo == NULL){
    free(head);
    return head;
  }
  lista temp = head;
  while(temp->proximo->proximo != NULL){
    temp = temp->proximo;
  }
  free(temp->proximo);
  temp->proximo = NULL;->proximo
  return head;
}
lista removeFirstNode(lista head){
  if(head->proximo == NULL){
    free(head);
    head = NULL;
    return head;
  }
  lista proximo = head->proximo;
  free(head);
  head = proximo;
  return head;
}
int main(void) {
  lista p = NULL;
  p = addNode(p, 10);
  addNode(p, 20);
  addNode(p, 30);
  p = removeFirstNode(p);
  printList(p);
  
  return 0;
}
