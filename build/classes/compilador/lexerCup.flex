package compilador;

import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

alf_min=[a-z]
exp_dig=[0-9]
alf_tot=[A-Za-z0-9]
exp_alf=[A-Za-z_áéíóú]
exp_alf_num={exp_alf}|{exp_dig}
ide={alf_min}({alf_tot}){0,15}
ide_invalido = {exp_dig}({alf_tot}){0,15}
tiemp=([0-5][0-9])(:[0-5][0-9])
tiempo_invalido=(([6-9][0-9]):([6-9][0-9]))|(([0-9]):([0-9]))|(([0-5]):([0-5][0-9]))|(([0-5][0-9]):([0-5]))
espacio=[ \t, \r, \n]+
caracter_especial=[_*:;%/#¿?¡!]
alert=[\"]({alf_tot})*[\"]
colore=[#]([0-9]{6})
veloc=[0-9]{1,2}
energy=[0-9]{1,2}

%{
    public Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    public Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "--"(.)* ) {/*Ignore*/}

/*Palabras reservadas de estructura y control*/
(inicioSecuencia)     {return new Symbol(sym.inicioSecuencia, yyline,yychar, yytext());}
(inicializacion)      {return new Symbol(sym.inicializacion, yyline,yychar, yytext());}
(importar)            {return new Symbol(sym.importar, yychar, yyline,yytext());}
(funcion)            {return new Symbol(sym.funcion, yychar, yyline,yytext());}
(retorno)            {return new Symbol(sym.retorno, yychar, yyline,yytext());}
(si)            {return new Symbol(sym.si, yychar, yyline,yytext());}
(sino)            {return new Symbol(sym.sino, yychar, yyline,yytext());}
(verdad)            {return new Symbol(sym.verdad, yychar, yyline,yytext());}
(falso)            {return new Symbol(sym.falso, yychar, yyline,yytext());}
(mientras)            {return new Symbol(sym.mientras, yychar, yyline,yytext());}

/*Palabras reservadas de declaracion*/
(decision)   {return new Symbol(sym.decision, yychar, yyline,yytext());}  
(velocidad)   {return new Symbol(sym.velocidad, yychar,yyline, yytext());}
(tiempo)   {return new Symbol(sym.tiempo, yychar, yyline,yytext());}
(alerta)   {return new Symbol(sym.alerta, yychar, yyline,yytext());}
(color)   {return new Symbol(sym.color, yychar, yyline,yytext());}
(energia)   {return new Symbol(sym.energia, yychar, yyline,yytext());}

/*Palabras reservadas de movimiento*/
(avanzar)     {return new Symbol(sym.avanzar, yychar, yyline,yytext());}
(detener)     {return new Symbol(sym.detener, yychar, yyline,yytext());}
(esperar)     {return new Symbol(sym.esperar, yychar, yyline,yytext());}
(iniciar)     {return new Symbol(sym.iniciar, yychar, yyline,yytext());}
(reversa)     {return new Symbol(sym.reversa, yychar, yyline,yytext());}

/*Palabras reservadas de ubicacion*/
(regresarBase)    {return new Symbol(sym.regresarBase, yychar, yyline,yytext());}
(detectarParada)  {return new Symbol(sym.detectarParada, yychar, yyline,yytext());}
(detectarLinea)  {return new Symbol(sym.detectarLinea, yychar, yyline,yytext());}


/*Palabras reservadas de seguridad*/
(obstaculo)     {return new Symbol(sym.obstaculo, yychar, yyline,yytext());}
(estadoCamara)   {return new Symbol(sym.estadoCamara, yychar, yyline,yytext());}
(duracionRecorrido)   {return new Symbol(sym.duracionRecorrido, yychar, yyline,yytext());}
(detectarAnomalia)   {return new Symbol(sym.detectarAnomalia, yychar, yyline,yytext());}
(estadoEnergia)   {return new Symbol(sym.estadoEnergia, yychar, yyline,yytext());}
(detectarColor)       {return new Symbol(sym.detectarColor, yychar, yyline,yytext());}

/*Estructuras del lenguaje*/
{ide}               {return new Symbol(sym.identificador, yyline,yychar, yytext());}
{tiemp}            {return new Symbol(sym.time, yychar, yyline,yytext());}
{alert}            {return new Symbol(sym.cadena, yychar, yyline,yytext());}
{veloc}             {return new Symbol(sym.veloc, yychar, yyline,yytext());}
{energy}             {return new Symbol(sym.energy, yychar, yyline,yytext());}
{colore}            {return new Symbol(sym.colores, yychar, yyline,yytext());}
{caracter_especial} {return new Symbol(sym.caracter_especial, yychar, yyline,yytext());}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=") {return new Symbol(sym.op_relacional, yychar, yyline, yytext());}
("=")     {return new Symbol(sym.igual, yychar, yyline,yytext());}
("+")     {return new Symbol(sym.suma, yychar, yyline,yytext());}
("-")     {return new Symbol(sym.resta, yychar, yyline,yytext());}
("(")     {return new Symbol(sym.parentesis_a, yychar, yyline,yytext());}
(")")     {return new Symbol(sym.parentesis_c, yychar, yyline,yytext());}
("{")     {return new Symbol(sym.llave_a, yychar, yyline,yytext());}
("}")     {return new Symbol(sym.llave_c, yychar, yyline,yytext());}
("·")     {return new Symbol(sym.punto_medio, yychar, yyline,yytext());}
(",")     {return new Symbol(sym.separador, yychar, yyline,yytext());}

/*Errores*/
{ide_invalido}      {return new Symbol(sym.error, yyline,yychar, yytext());}
{tiempo_invalido}   {return new Symbol(sym.error, yyline,yychar, yytext());}
. {return new Symbol(sym.error, yychar, yyline, yytext());}