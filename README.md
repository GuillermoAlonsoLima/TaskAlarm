# **Task Alarm**

Este presente relatório é referente ao TCC da Pós Graduação de Desenvolvimento de Aplicativos Mobile.

**Resumo do Projeto**

Várias pessoas tem dificuldade em manter a atenção ou tem problema de memória. Talvez elas tenham tantos compromissos e tarefas, as vezes ao mesmo tempo, que se torna complicado lembrar ou prestar atenção em todas. Isso aumenta a chance de que percam compromissos muito importantes para sua vida profissional e pessoal, como reuniões, consultas médicas, etc.

Uma solução para esse problema seria a união do alarme a lista de tarefas, permitindo que o usuário seja lembrado de compromissos, mas também tenha uma lista de tarefas para cada um deles, evitando assim que o usuário esqueça detalhes importantes como levar documentos para uma reunião.

Espera-se assim que o usuário possa ficar mais tranquilo, contando com uma ferramenta que o ajudará a cumprir seus compromissos sem estresse.

**Definição do Problema**

O problema do esquecimento de realizar tarefas, não somente atinge pessoas com déficit de atenção ou problema de memória, mas também idosos e pessoas muito ocupadas. No artigo &quot;Como diferenciar déficit de atenção de problemas de memória?&quot; encontrado no site &quot;NeuroSaber&quot; fica claro que apesar de ter razões e comportamentos diferentes entre os problemas, a dificuldade de se lembrar é a mesma.

A informação citada acima foi descoberta na etapa de Discovery, que é a etapa onde foi perguntado a várias pessoas sobre quais funcionalidades elas considerariam relevantes no app e também perguntas que viabilizaram traçar um perfil do nosso público alvo. A consulta foi feita entre pessoas comuns em grupos de What&#39;s App e pessoalmente. Os respondentes não eram somente trabalhadores ou estudantes, mas também pessoas desempregadas ou aposentadas que também possuem compromissos e poderiam se beneficiar deste aplicativo.

O diferencial do aplicativo Task Alarm é a praticidade, pois neste possui as duas funcionalidades, tanto a lista, quanto o alarme, por exemplo, tenho um compromisso de reunião onde terei que levar certos documentos, ao utilizar meu aplicativo, só um único alarme me avisará do compromisso e me mostrará a lista de tarefas, onde posso colocar os documentos que tenho que levar, esta praticidade não acontece com os outros aplicativos já existentes, conforme pode ser verificado na tabela comparativa dos aplicativos correlatos.

![](RackMultipart20200802-4-1u7ofvz_html_403624b5c13a66e8.png)

_Figura 1: Tabelas dos aplicativos correlatos_

**Objetivos**

**Objetivo Geral**

Criar um aplicativo que avise ao usuário sobre compromissos e as tarefas relacionada aos mesmos, permitindo que ele tenha mais tranquilidade, sem se preocupar se esqueceu de algo.

**Objetivos Específicos**

Desenvolver um aplicativo mobile nativo para Android que permita o gerenciamento de alarmes, onde cada alarme terá uma lista de tarefas e outros detalhes que também podem ser gerenciados pelo usuário.

Permitir ao usuário criar, editar e deletar alarmes com listas de atividades vinculadas ao alarme. Estas atividades também podem ser criadas ou deletadas.

Ele avisará ao usuário na data e hora colocada no alarme sobre o compromisso registrado na forma de texto, mostrando as tarefas relacionadas, minimizando as chances de esquecer e qualquer detalhe relacionado.

Isto deixará o usuário seguro que não se esquecerá de nada e permitindo que ele possa se concentrar em outras coisas comuns no dia a dia, como no trabalho, estudo, lazer e outros.

**Stack Tecnológico**

**SQLite**

Criado em 2000 por D. Richard Hipp, o SQLite é um servidor de banco de dados de simples uso. Foi escolhido por ser um dos bancos de dados mais simples de se utilizar e por ser nativo no sistema Android.

**SQL**

Criado em 1974, o SQL ou &quot;Structured Query Language&quot; é a linguagem de banco de dados relacional. Foi utilizada pois é a linguagem compatível com o SQlite, permitindo que seja salvo informações dos alarmes e tarefas, mesmo ao fechar o aplicativo.

**Kotlin**

Criado em 2016 pela JetBrains, o Kotlin é uma linguagem baseada em Java com uma sintaxe mais simples e limpa, com uma aparência mais próxima ao Javascript ou o Python, mas com o funcionamento interno igual ao Java. Sua principal vantagem é ser fracamente tipado. Ele será utilizado por seu foco no Android e por ser fácil de utilizar, porém seguro em relação as tipagens, unindo o melhor de dois mundos. As linguagens tipadas e não tipadas.

**XML**

Criado em 1996 pela W3C, o XML ou o &quot;Extensible Markup Language&quot; é uma linguagem de marcação utilizada em casos específicos. Neste caso, será utilizado para definir a interface gráfica do projeto, como as tabelas, listas, textos e outros. Foi escolhido por ser o padrão na criação de interfaces gráficas no Android.

**Android Studio**

Lançado em 2013 pela Google, o Android Studio é uma IDE focada no desenvolvimento de aplicativos exclusivamente para Android, suportando as linguagens Java e Kotlin. Foi escolhida por permitir o desenvolvimento nativo e por ser é o padrão e a ferramenta indicada pela Google para desenvolvimento de app nativo para Android.

**Descrição da Solução**

Sobre as funcionalidades do aplicativo, foi descoberto, por meio da condução de uma pesquisa via questionário, onde dez pessoas responderam que há uma grande preferência que o alarme toque mesmo que o celular esteja em silencioso, que as informações mostradas no alarme sejam sucintas e que haja uma opção de repetir por dia da semana.

Também há uma preferência de 50% de que tenha uma lista de tarefas, a qual será colocada ainda assim por ser seu diferencial e por ser também focado ao público com déficit de atenção ou problema de memória, que haja um mapa mostrando a rota aonde deves ir acaso seja um compromisso em um certo local e que haja uma funcionalidade semelhante a agenda, aonde o usuário pode colocar um alarme para um certo dia do mês ou ano. As questões elaboradas podem ser consultadas junto aos gráficos de resultados da pesquisa que estão disponíveis logo abaixo.

![](RackMultipart20200802-4-1u7ofvz_html_d8043989d19eae80.png)

_Figura 2: Gráficos dos resultados do discovery_

Utilizando o App, será mostrado ao usuário a lista de alarmes, que poderão ser gerenciados, ou seja, adicionados, editados e removidos (Tela de lista de alarme).

Para adicionar um alarme, deve-se clicar no botão de adição, que mostrará uma outra tela contendo um formulário para o usuário incluir os detalhes do alarme, o qual permitirá o usuário escolher o nome do alarme, sua descrição, em quais dias da semana deve-se repetir e uma lista de tarefas as quais podem também ser gerenciadas (Tela Adição de alarme).

Para editar, se deve clicar num alarme já existente e aparecerá a mesma tela descrita acima, porém com os dados relacionados ao alarme clicado, também poderá se remover o alarme em si através de um botão de remoção.

A imagem Tela Notificação ilustra como será visualizado a notificação do alarme do aplicativo.

![](RackMultipart20200802-4-1u7ofvz_html_c672732f1a0254f8.png)

_Figura 3: Fluxograma do uso da aplicação_

![](RackMultipart20200802-4-1u7ofvz_html_7d2da71842ff4946.png)

_Figura 4: Tela da lista, edição e notificação de Alarmes, respectivamente_

**Arquitetura**

**Canvas MVP**

A partir da Persona, foi feito o Canvas MVP para projetar o aplicativo a partir do público alvo e definir o seu desenvolvimento.

![](RackMultipart20200802-4-1u7ofvz_html_e61266f2bb475416.png)

_Figura 5: Tabela do Canvas MVP_

**Features**

Define o custo e benefício de cada funcionalidade, definindo assim a prioridade de desenvolvimento das mesmas.

![](RackMultipart20200802-4-1u7ofvz_html_3c6639302946c093.png)

_Figura 6: Tabela de Feature_

**Persona:**

Utilizado para definir o consumidor comum no nosso público alvo e suas necessidades.

Apelido:

- Jovem e adulto com déficit de atenção

Perfil:

- Desorganizado
- Déficit de atenção
- Pouca memória
- Varias coisas a fazer

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

Define o que o produto irá ser capaz de fazer e o que está fora de seu escopo.

Produto é:

- Lista de alarmes com lista de tarefas por alarme
- Focado a grupos com déficit de atenção ou memória
- Nativo do Android e em português
- Offline

Produto não é:

- Online
- Agenda
- Somente para grupos com déficit de atenção ou memória, pode ser utilizados por outros também
- Disponível em outros dispositivos além do Android ou em outras linguagens além do português

Produto faz:

- Gerencia alarmes com tarefas
- Tem opção de tocar no silencioso
- Permite repetir por dias da semana

Produto não faz:

- Grava informações online
- Permite repetir por dia no calendário (Pode ser adicionado no futuro)
- Não registra a duração da atividade
- Não faz relatório de atividades concluídas

**Produto Mínimo Viável**

Define o mínimo que o produto precisa fazer para estar num nível funcional.

- O que tem que se fazer: lista de tarefas
- Quando tem que se fazer: alarme
- Quando que o usuário vai pegar o aplicativo e o que ele vai fazer:
- Quando perceber que é muito difícil se lembrar de tudo e que está perdendo alguns compromissos ou esquecendo alguns detalhes e tendo que perguntar constantemente.
- Criará alarmes e listas a noite para se prepara para amanhã.

**Validação**

A validação foi feita pelos usuários que responderam um questionário após utilizar o app.

**Estratégia**

Foi mostrado o funcionamento do aplicativo as pessoas envolvidas no questionário de Discovery, após será feito um questionário de quais funcionalidades gostaram mais ou menos, assim podendo verificar quais funcionalidades manterem e quais devem ser melhoradas ou retiradas.

**Consolidação dos Dados**

Como visto nos gráficos abaixo, houve uma grande aceitação da organização da interface, como o local dos botões e outras formas, porém o visual da interface ainda pode melhorar, provavelmente com um melhor uso das cores.

![](RackMultipart20200802-4-1u7ofvz_html_4b1edc1789cda82.png)

_Figura 7: Resultados do Questionário de Validação_

**Conclusões**

Neste projeto, foi testado os conhecimentos aprendidos no curso, principalmente em relação a interfaces e banco de dados. Também foi aprendido assuntos novos, como a utilização da classe &quot;Timer&quot; para os alarmes. Esta funcionalidade em específico foi a mais difícil de implementar, com ela no momento só funcionando se for executada artificialmente, ou seja, seja forçada a ativar. Por isso, ainda não há a funcionalidade de repetir alarmes, já que o teste do mesmo levaria muito tempo.

Então, como mencionado, o projeto não está na fase de venda, então será ainda feita mais modificações, principalmente em relação a chamada do alarme, para que possa ser lançado na Google Play Store.

**Referências Bibliográficas**

[https://www.tecmundo.com.br/software/146482-sql-que-ele-serve.htm](https://www.tecmundo.com.br/software/146482-sql-que-ele-serve.htm)

[https://kotlinlang.org/](https://kotlinlang.org/)

[https://canaltech.com.br/software/xml-o-que-e/](https://canaltech.com.br/software/xml-o-que-e/)

[https://www.sqlite.org/index.html](https://www.sqlite.org/index.html)

[https://developer.android.com/studio](https://developer.android.com/studio)

[https://neurosaber.com.br/como-diferenciar-deficit-de-atencao-de-problemas-de-memoria/](https://neurosaber.com.br/como-diferenciar-deficit-de-atencao-de-problemas-de-memoria/)
