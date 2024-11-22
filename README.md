# TP 03 - Java

1.  Calculadora.  
Construir o Form abaixo e possibilitar o cálculo das operações de 
divisão, multiplicação, subtração e adição. 
OBS:  
- O botão C = Clear e limpa a memória da calculadora e também zera o text field 
de resultado. 
- Colocar tratamento de erros (try, catch, finally)

2. Crie a estrutura de classes indicada abaixo 
Pessoa From default

| Atributo/Operação        | Tipo        |
|--------------------------|-------------|
| **kp**                    | `int`       |
| **nome**                  | `String`    |
| **sexo**                  | `char`      |
| **idade**                 | `int`       |

| **Método**                | Tipo de Retorno |
|--------------------------|-----------------|
| `Pessoa()`               | `void`          |
| `Pessoa(String, char, int)` | `void`          |
| `setKp()`                | `void`          |
| `setNome(String)`        | `void`          |
| `setSexo(char)`          | `void`          |
| `setIdade(int)`          | `void`          |
| `getKp()`                | `int`           |
| `getNome()`              | `String`        |
| `getSexo()`              | `char`          |
| `getIdade()`             | `int`           |

### Classe Pessoa

| Atributo/Operação        | Tipo        |
|--------------------------|-------------|
| **kp**                    | `int`       |
| **nome**                  | `String`    |
| **sexo**                  | `char`      |
| **idade**                 | `int`       |

| **Método**                | Tipo de Retorno |
|--------------------------|-----------------|
| `Pessoa()`               | `void`          |
| `Pessoa(String, char, int)` | `void`          |
| `setKp()`                | `void`          |
| `setNome(String)`        | `void`          |
| `setSexo(char)`          | `void`          |
| `setIdade(int)`          | `void`          |
| `getKp()`                | `int`           |
| `getNome()`              | `String`        |
| `getSexo()`              | `char`          |
| `getIdade()`             | `int`           |

---

### Versão 01: Usando JTextField para o Sexo

- **Sexo**: Campo `TextField` para inserir "M" ou "F".
- **Campos obrigatórios**: Nome, Sexo e Idade.

---

### Versão 02: Usando JComboBox para o Sexo

- **Sexo**: Componente `JComboBox` para escolher entre "M" e "F".
- **Campos obrigatórios**: Nome, Sexo e Idade.

---

### Versão 03: Usando JRadioButton para o Sexo

- **Sexo**: Componente `JRadioButton` para selecionar entre "M" e "F".
- **Campos obrigatórios**: Nome, Sexo e Idade.


