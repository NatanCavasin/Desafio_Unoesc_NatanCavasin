# Desafio_Unoesc_NatanCavasin

O desafio foi desenvolvido seguindo todas as tecnologias exigidas.

**Configurações iniciais**

para que seja possivel acessar a aplicação, é necessário incluir o administrador na base de dados:

INSERT INTO `desafiounoesc`.`usuario` (`cpf`, `login`, `nome`, `senha`) VALUES ('123456789101', 'admin', 'Administrador', '$2a$10$q2Bqfo8qRApUhUtK9o.Gn.7w09Ya/WsCRWivMyVjYBzpByRyQ3skm');

*Obs: a senha já esta codificada com o encoder, uma vez que é necessario para utilizar no spring security

Além disto, é necessário a definição dos perfis de acesso, atraves dos seguites comandos SQL

INSERT INTO `desafiounoesc`.`role` (`nome`) VALUES ('ROLE_ADMIN');
INSERT INTO `desafiounoesc`.`role` (`nome`) VALUES ('ROLE_PROFESSOR');
INSERT INTO `desafiounoesc`.`role` (`nome`) VALUES ('ROLE_ALUNO');

E por fim, inserir a relação na tabela de associação:

INSERT INTO `desafiounoesc`.`user_roles` VALUES (1,1);

**Considerações**

Eu não consegui concluir todo o objetivo do desafio, peço desculpas por isso, mas tive que resolver alguns outros problemas pessoais 
e profissionais que me tomaram tempo durante a semana, de modo que eu consegui começar a desenvolver apenas na sexta-feira.

O que funciona:

  Da visão do administrador:

    1. O crud de usuarios e cursos
    2. Somente a listagem de disciplinas
   
 Da visão do aluno:
    1. A listagem de cursos
    
Não consegui implementar a visão do professor

Entretanto, toda a parte de segurança, controle de niveis de acesso e a definição dos models, bem como as classes de serviço do JPA estão implementadas
