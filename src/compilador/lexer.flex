package compilador;

import compilador.Tokens.*;

%%

%class Lexer
%type Tokens
alf_min=[a-z]
alf_may=[A-Z]
exp_dig=[0-9]
alf_tot=[A-Za-z0-9]
exp_alf=[A-Za-z_áéíóú]
exp_alf_num={exp_alf}|{exp_dig}
ide={alf_min}({alf_tot}){0,15}
ide_invalido = {exp_dig}({alf_tot}){0,15}
tiemp=(([0-5][0-9]):([0-5][0-9]))
tiempo_invalido=(([6-9][0-9]):([6-9][0-9]))|(([0-9]):([0-9]))|(([0-5]):([0-5][0-9]))|(([0-5][0-9]):([0-5]))
espacio=[ ,\t, \r, \n]+
caracter_especial=[_*,:;%/#¿?¡!]
alert=[\"]({exp_alf})*[\"]
colore=[#]([0-9]{6})
veloc=[0-9]{1,2}
veloc_invalida = ({exp_dig}){3,1000}
%{
    public String lexeme;
%}
%%


/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "--"(.)* ) {/*Ignore*/}

/* Salto de linea */
( "\n" ) {return linea;}

//Palabras reservadas de estructura y control
(inicioSecuencia) {lexeme=yytext(); return inicioSecuencia;}
(inicializacion)     {lexeme=yytext(); return inicializacion;}
(importar)       {lexeme=yytext(); return importar;}
(funcion)       {lexeme=yytext(); return funcion;}
(retorno)       {lexeme=yytext(); return retorno;}
(si)       {lexeme=yytext(); return si;}
(sino)       {lexeme=yytext(); return sino;}
(verdad)       {lexeme=yytext(); return verdad;}
(falso)       {lexeme=yytext(); return falso;}
(mientras)       {lexeme=yytext(); return mientras;}
(obtener)       {lexeme=yytext(); return obtener;}

//Palabras reservadas de declaracion
(decision)   {lexeme=yytext(); return decision;}   
(velocidad)   {lexeme=yytext(); return velocidad;}
(tiempo)   {lexeme=yytext(); return tiempo;}
(alerta)   {lexeme=yytext(); return alerta;}
(color)   {lexeme=yytext(); return color;}
(energia)   {lexeme=yytext(); return energia;}

//Palabras reservadas de movimiento
(avanzar)     {lexeme=yytext(); return avanzar;}
(detener)     {lexeme=yytext(); return detener;}
(esperar)     {lexeme=yytext(); return esperar;}
(iniciar)     {lexeme=yytext(); return iniciar;}
(reversa)     {lexeme=yytext(); return reversa;}

//Palabras reservadas de ubicacion
(ubicar)          {lexeme=yytext(); return ubicar;}
(regresarBase)    {lexeme=yytext(); return regresarBase;}
(detectarParada)  {lexeme=yytext(); return detectarParada;}
(detectarLinea)   {lexeme=yytext(); return detectarLinea;}


//Palabras reservadas de seguridad
(obstaculo)          {lexeme=yytext(); return obstaculo;}
(estadoCamara )       {lexeme=yytext(); return estadoCamara;}
(duracionRecorrido)   {lexeme=yytext(); return duracionRecorrido;}
(detectarAnomalia)    {lexeme=yytext(); return detectarAnomalia;}
(estadoEnergia)      {lexeme=yytext(); return estadoEnergia;}
(detectarColor)       {lexeme=yytext(); return detectarColor;}

//Estructuras del lenguaje
{ide}               {lexeme=yytext(); return identificador;}
{tiemp}            {lexeme=yytext(); return time;}
{alert}            {lexeme=yytext(); return cadena;}
{veloc}             {lexeme=yytext(); return veloc;}
{colore}            {lexeme=yytext(); return colores;}
{caracter_especial} {lexeme=yytext(); return caracter_especial;}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=") {lexeme = yytext(); return op_relacional;}
("=" )   {lexeme=yytext(); return igual;}
("+")     {lexeme=yytext(); return suma;}
("-")    {lexeme=yytext(); return resta;}
("(")    {lexeme=yytext(); return parentesis_a;}
(")")     {lexeme=yytext(); return parentesis_c;}
("{")     {lexeme=yytext(); return llave_a;}
("}")     {lexeme=yytext(); return llave_c;}
("·")     {lexeme=yytext(); return punto_medio;}  


/*Errores*/
{ide_invalido}      {lexeme=yytext(); return error;}
{tiempo_invalido}   {lexeme=yytext(); return error;}
{veloc_invalida}     {lexeme=yytext(); return error;}

. {return error;}