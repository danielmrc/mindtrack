#Criar profissional

 Post: url> /professional

    exemplo de body: 
        ```
            {
                "crp": "12398472633",
                "name": "testando insert prof",
                "phoneNumber": "2198477650",
                "dateOfBirth": "15/09/1993",
                "emailAddress": "testandoCadastroProf@gmail.com",
                "city": "Higienopolis",
                "state": "Sao Paulo",
                "country": "teste update address",
                "street": "rua 12",
                "postalCode": "30219011"
            }
        ```

    retorna 200 com novo objeto alterado em caso de sucesso e 422 em caso de exceção

#Alterar profissional

 Put: url> /professional/{crp}

    crp do professional que vai ser alterado

    exemplo de body:

        ```
            {
                "crp": "12398472633",
                "name": "testando insert prof",
                "phoneNumber": "2198477650",
                "dateOfBirth": "15/09/1993",
                "emailAddress": "testandoCadastroProf@gmail.com",
                "city": "Higienopolis",
                "state": "Sao Paulo",
                "country": "teste update address",
                "street": "rua 12",
                "postalCode": "30219011"
            }
        ```

     retorna 200 com novo objeto alterado em caso de sucesso e 422 em caso de exceção

#Deletar professional

 Delete: url> /professional/{crp}

 retorna 200 em caso de sucesso e 422 em caso de exceção


#Selectional professional

 Get> url /professiona/{crp}

    var retornar os dados do professional portador do crp passado

    exemplo de resposta:

    ```
        {
            "description": "Sucess Professional selecting",
            "object": {
                "name": "testando insert prof",
                "phoneNumber": "2198477650",
                "dateOfBirth": "15/09/1993",
                "emailAddress": "testandoCadastroProf@gmail.com",
                "street": "rua 12",
                "city": "Higienopolis",
                "state": "Sao Paulo",
                "postalCode": "30219011",
                "country": "teste update address",
                "crp": "12398472633"
            }
        }
    ```

     retorna 200 em caso de sucesso, 422 em caso de exceção e 204 caso não encontre dados para o crp passado

#Selecionar pacientes de um professional

 Get: url> /professional/patients/{crp}

    vai retornar uma lista de patients do professional portador do crp passado
    
    exemplo de resposta: 

    ```
        {
            "description": "Sucess patients selecting",
            "object": [
                {
                    "name": "testando para segundo profissional",
                    "phoneNumber": "3198477995",
                    "dateOfBirth": "15/09/1995",
                    "emailAddress": "testandoCadastroPacientes5@gmail.com",
                    "street": "rua 5",
                    "city": "Betim",
                    "state": "Minas Gerais",
                    "postalCode": "20520825",
                    "country": "teste4",
                    "cpf": "12987654777",
                    "responsible": "Tia 5"
                }
            ]
        }
    ```

    retorna 200 em caso de sucesso, 422 em caso de exceção e 204 caso não encontre dados para o crp passado



#Criar paciente

 Post: url> /patient/{crp}

    crp do profissional que está cadastrando o paciente

    exemplo de body: 
        ```
            {
                "cpf": "12987654777",
                "name": "testando para segundo profissional",
                "phoneNumber": "3198477995",
                "dateOfBirth": "15/09/1995",
                "emailAddress": "testandoCadastroPacientes5@gmail.com",
                "city": "Betim",
                "state": "Minas Gerais",
                "country": "teste4",
                "street": "rua 5",
                "postalCode": "20520825",
                "responsible": "Tia 5"
            }
        ```

        retorna 200 com novo objeto alterado em caso de sucesso e 422 em caso de exceção

#Alterar paciente

 Put: url> /patient/{cpf}

    cpf do paciente que vai ser alterado

    exemplo de body:

        ```
            {
                "cpf": "12987654777",
                "name": "testando alteração",
                "phoneNumber": "3198477995",
                "dateOfBirth": "15/09/1995",
                "emailAddress": "testandoCadastroPacientes5@gmail.com",
                "city": "Betim",
                "state": "Minas Gerais",
                "country": "teste4",
                "street": "rua 5",
                "postalCode": "20520825",
                "responsible": "Tia 6"
            }
        ```

        retorna 200 com novo objeto alterado em caso de sucesso e 422 em caso de exceção

#Deletar paciente

 Delete: url> /patient/{crp}/{cpf}

    OBS: O paciente vai ser excluído para aquele profissional do crp passado, não para toda a base.

    retorna 200 em caso de sucesso e 422 em caso de exceção

#Selecionar paciente

 Get: url> /patient/{cpf}
    
    exemplo de resposta: 

    ```
        {
            "description": "Sucess patient creating",
            "object": {
                "name": "testando para segundo profissional",
                "phoneNumber": "3198477995",
                "dateOfBirth": "15/09/1995",
                "emailAddress": "testandoCadastroPacientes5@gmail.com",
                "street": "rua 5",
                "city": "Betim",
                "state": "Minas Gerais",
                "postalCode": "20520825",
                "country": "teste4",
                "cpf": "12987654777",
                "responsible": "Tia 5"
            }
        }   
    ```

    retorna 200 em caso de sucesso, 422 em caso de exceção e 204 caso não encontre dados para o cpf passado