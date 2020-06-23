#Task Alarm

**Resumo do Projeto**

Muitas pessoas tem problema de atenção ou de memória fraca, ou tem tantos compromissos e tarefas, as vezes até ao mesmo tempo, que não podem se lembrar ou prestar atenção em todas.

Isto faz com que elas percam, por exemplo, reuniões importantes, consultas médicas, aniversários, etc. E apesar de já existirem alarmes, a falta de uma lista de tarefas também pode comprometer os detalhes do compromisso em si, como por exemplo, se esquecer quais documentos deve se levar a reunião ou a consulta, ou qual presente deve comprar ao aniversariante, etc.

Uma solução para esse problema seria uma união do alarme a lista de tarefas, permitindo que o usuário seja lembrado de compromissos, mas também tenha uma lista de tarefas para cada um, assim não se esquecendo dos detalhes necessários para executar ou levar ao compromisso.

O resultado é que a pessoa estará mais tranquila, já que sabe que não irá perder e que já não perdeu nenhuma tarefa e então não precisará ficar constantemente preocupada com isso.

**Definição do Problema**

Apesar de pessoas com déficit de memória ou atenção terem mais problemas relacionados ao esquecimento de tarefas e suas datas e horas, não é incomum que outras pessoas, principalmente os idosos e pessoas muito ocupadas, tenham o mesmo problema.

Isto foi descoberto na etapa de Discovery, onde como visto nos gráficos abaixo, a maioria dos respondentes nem se quer eram trabalhadores ou estudantes, ou seja, até pessoas desempregadas ou aposentadas também possuem compromissos.

Outra descoberta feita é que a maioria das pessoas com problemas de déficit de atenção ou memória nem as possuem por desabilidade, e sim por idade, com a idade média dos respondentes sendo 61,3.

Sobre as funcionalidades em si, foi descoberto que há uma grande preferência que o alarme toque mesmo que o celular esteja em silencioso, que as informações mostradas no alarme sejam sucintas e que haja uma opção de repetir por dia da semana. Também tem uma preferência mais moderada que tenha uma lista de tarefas, o qual será colocada ainda assim por ser seu diferencial e por ser também focado ao público com déficit de atenção ou memória, que haja um mapa mostrando a rota aonde deves ir acaso seja um compromisso em um certo local e que haja uma funcionalidade semelhante a agenda, aonde podes colocar um alarme para um certo dia do mês ou ano.

![](RackMultipart20200623-4-13wr1zv_html_e0ce32bc9a59700d.png)

Em relação a produtos já existentes, há alarmes embutidos no smartphone ou disponíveis nos mercados de aplicativos, o mesmo acontece com as listas de tarefas. Até a agenda embutida no celular pode servir como um tipo de alarme.

Porém o que eles não tem são as duas funcionalidades juntas, então, por exemplo, se eu tiver um compromisso como a reunião mencionada acima e eu tiver que levar certos documentos, terei que usar dois aplicativos para isto, o que faz com que o usuário perca tempo e, se for realmente esquecido, pode causar problemas como utilizar um aplicativo, mas não o outro como lembrar-se do alarme, mas esquecer de utilizar as tarefas.

| Funcionalidades | Google Tarefas | To-do list | Relógio | Despertador – Alarm Clock | Google Agenda | TaskAlarm (Meu aplicativo) |
| --- | --- | --- | --- | --- | --- | --- |
| Alarme | Não | Não | Sim | Sim | Sim | Sim |
| Lista de Tarefas | Sim | Sim | Não | Não | Não | Sim |
| Agenda | Não | Não | Não | Não | Sim | Talvez |

**Objetivos**

**Objetivo Geral**

Criar um aplicativo que avise ao usuário sobre compromissos e tarefas relacionadas, permitindo que ele tenha mais tranquilidade, sem se preocupar se esqueceu de algo.

**Objetivos Específicos**

Desenvolver um aplicativo mobile nativo do Android que permita o gerenciamento de alarmes, sendo mostrados numa lista e que cada alarme opcionalmente possua uma lista de tarefas que também podem ser gerenciados pelo usuário.

Ele avisará ao usuário na data e hora colocada no alarme sobre o compromisso posto na forma de texto, mostrando as tarefas relacionadas, impedindo que esqueça o compromisso em si e qualquer detalhe relacionado.

Isto deixará o usuário seguro que não se esquecerá de nada e permitindo que ele possa se concentrar em outras coisas comuns no dia a dia, como no trabalho, estudo, lazer e outros.

**Stack Tecnológico**

**SQL**

Criado em 1974, o SQL ou &quot;Structured Query Language&quot; é a linguagem de banco de dados relacional mais utilizada e praticamente a linguagem padrão da maioria dos gerenciadores de banco de dados, este é o maior motivo do seu uso neste projeto, por possuir uma quantidade de documentação e suporte muito superior a outras linguagens neste ramo.

**Kotlin**

Criado em 2016 pela JetBrains, o Kotlin é uma linguagem baseada em Java com uma sintaxe mais simples e limpo, com uma aparência mais próxima ao Javascript ou o Python, mas com o funcionamento interno igual ao Java, sua principal vantagem é que sua tipagem é automática. Ele será utilizado por seu foco no mercado mobile e por ser fácil, porém seguro, unindo o melhor de dois mundos. As linguagens tipadas e não tipadas.

**XML**

Criado em 1996 pela W3C, o XML ou o &quot;Extensible Markup Language&quot; é uma linguagem de marcação utilizada em casos específicos. Neste caso, será utilizado para formar a interface do projeto, como as tabelas, listas, textos e outros. Foi escolhido pelo mesmo motivo que o SQL.

**SQLite**

Criado em 2000 por [D. Richard Hipp](https://www.google.com/search?client=firefox-b-d&amp;sxsrf=ALeKk00LJG4269anfr3GCq8DHQSQtSxd2g:1592074580787&amp;q=D.+Richard+Hipp&amp;stick=H4sIAAAAAAAAAONgVuLUz9U3SDOoyCpexMrvoqcQlJmckViUouCRWVAAAMLeB4MfAAAA&amp;sa=X&amp;ved=2ahUKEwjmzN_-u__pAhXsdN8KHbopCHoQmxMoATAgegQIBhAD), o SQLite é um servidor de banco de dados de simples uso, porém performance limitada, tendo principalmente problemas com um volume alto de informações. Foi escolhido por ser um dos bancos de dados mais simples de se utilizar, com seu limite sendo supérfluo nesta situação, já que será utilizado por somente um usuário.

**Android Studio**

Lançado em 2013 pela Google, o Android Studio é uma IDE focada no desenvolvimento de aplicativos mobile, com preferência das linguagens Java e Kotlin. Foi escolhida por permitir o desenvolvimento nativo e ter umas das mais desenvolvidas e específicas ferramentas para desenvolvimento Android.

**Descrição da Solução**

Primeiramente, será mostrado ao usuário a lista de alarmes, que poderão ser gerenciados, ou seja, adicionados, editados e removidos.

Para adicionar um alarme, se deverá clicar no botão de adição, que mostrará uma outra tela sem dados, o qual permitirá o usuário escolher o nome do alarme, sua descrição, em quais dias da semana deve-se repetir, uma lista de tarefas as quais podem ser gerenciadas também e, se possível o desenvolvimento, os dias do mês ou ano que deve tocar e a localização do compromisso.

Para editar, se deve clicar num alarme já existente e aparecerá a mesma tela descrita acima, porém com os dados relacionados ao alarme clicado, também poderá se remover o alarme clicado em si através de um botão de remoção.

**Arquitetura**

**Canvas MVP**

![](RackMultipart20200623-4-13wr1zv_html_b839f7a2a3599bf1.png)

**Features**

![](RackMultipart20200623-4-13wr1zv_html_3fc0585a6b7da286.png)

**Persona:**

Apelido:

- Jovem e adulto com déficit de atenção

Perfil:

- Desorganizado
- Déficit de atenção
- Pouca memória
- varias coisas a fazer

Comportamento:

- Ansioso
- Não se lembra das coisas
- Problemas em prestar atenção
- Perdido com coisas simples

Objetivos e necessidades:

- Ser pontual
- Saber sobre várias informações, como usuários e senhas
- Não atrasar em compromissos
- Saber o passo a passo sobre o funcionamento de certos aplicativos, principalmente no início de uso
- Não se esquecer de horários

**Produto**

Produto é:

- Lista de alarmes com lista de tarefas por alarme
- Focado a grupos com deficit de atenção ou memória
- Nativo do Android e em português
- Offline

Produto nãe é:

- Online
- Agenda
- Somente para grupos com deficit de atenção ou memória, pode ser utilizados por outros também
- Disponível em outros dispositivos além do android ou em outras linguagens além do português

Produto faz:

- gerencia alarmes com tarefas
- Tem opção de tocar no silencioso
- Permite repetir por dias da semana

Produto não faz:

- Grava informações online
- Permite repetir por dia no calendário (Pode ser adicionado no futuro)
- não registra a duração da atividade
- não faz relatório de atividades concluídas

**Produto Mínimo Viável**

- O que tem que se fazer: lista de tarefas
- Quando tem que se fazer: alarme
- Quando que o usuário vai pegar o aplicativo e o que ele vai fazer:
  - Quando perceber que é muito difícil se lembrar de tudo e que está perdendo alguns compromissos ou esquecendo alguns detalhes e tendo que perguntas constantemente.
  - Criará alarmes e listas a noite para se prepara para amanhã.

**Validação**

**Estratégia**

**Consolidação dos Dados**

**Conclusões**

**Referências Bibliográficas**

[https://www.tecmundo.com.br/software/146482-sql-que-ele-serve.htm](https://www.tecmundo.com.br/software/146482-sql-que-ele-serve.htm)

[https://kotlinlang.org/](https://kotlinlang.org/)

[https://canaltech.com.br/software/xml-o-que-e/](https://canaltech.com.br/software/xml-o-que-e/)

[https://www.sqlite.org/index.html](https://www.sqlite.org/index.html)

https://developer.android.com/studio
