/* JFlex Lambda Calculus */


/**
 * This class is a simple lambda calculus lexer
 */
package parser;

import java.io.*;
import java_cup.runtime.*;
%%

%class LambdaLexer
%unicode
%public
%cup



%{
  boolean shouldPrint = false;
  void print(String x){
	if(shouldPrint)
		System.out.print(x);
  }
  
  public Symbol token( int tokenType ) {
		
		return new Symbol( tokenType, yychar,
		yychar + yytext().length(), yytext() );
	}
%}


LAMBDA = "&"

CONSTANT = [0-9]+

VARIABLE = [a-z]

WHITESPACE = [" "]


%%

{LAMBDA} {print("LAMBDA "); return token(sym.LAMBDA);}
{CONSTANT} {print("CONSTANT "/*+Double.parseDouble(yytext())*/); return token(sym.CONSTANT);}
{VARIABLE} {print("VARIABLE "); return token(sym.VARIABLE);}
/* operators */
"+" {print("+"); return token( sym.PLUS ); }
"." {print("."); return token( sym.DOT ); }
"-" {print("-"); return token( sym.MINUS ); }
"*" {print("*"); return token( sym.MULTIPLY ); }
"/" {print("/"); return token( sym.DIVIDE ); }
"(" {print("("); return token( sym.LEFT ); }
")" {print(")"); return token( sym.RIGHT ); }
{WHITESPACE} {}
<<EOF>> { return token( sym.EOF ); }