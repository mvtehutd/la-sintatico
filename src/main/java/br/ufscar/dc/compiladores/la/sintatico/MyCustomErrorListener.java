package br.ufscar.dc.compiladores.la.sintatico;

import java.io.PrintWriter;
import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class MyCustomErrorListener implements ANTLRErrorListener{
    PrintWriter pw;
    public MyCustomErrorListener(PrintWriter pw){
        this.pw = pw;
    }

    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        // Aqui vamos colocar o tratamento de erro customizado

        Token t = (Token) offendingSymbol;
        if(LaLexer.VOCABULARY.getDisplayName(t.getType()).equals("ERRO")){
            pw.println("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado");
        } else if (t.getText().startsWith("\"") && !t.getText().endsWith("\"")){
            System.out.print("Linha "+line+": cadeia literal nao fechada\n");
            pw.print("Linha "+line+": cadeia literal nao fechada\n");
            
        } else if(t.getText().startsWith("{") && !t.getText().endsWith("}")){
            System.out.print("Linha "+line+": comentario nao fechado\n");
            pw.print("Linha "+line+": comentario nao fechado\n");
        } else if(t.getText().equals("<EOF>")){
            System.out.print("Linha "+line+": erro sintatico proximo a "+t.getText().substring(1, t.getText().length() - 1)+"\n");
            pw.print("Linha "+line+": erro sintatico proximo a "+t.getText().substring(1, t.getText().length() - 1)+"\n");
        }else{
            System.out.print("Linha "+line+": erro sintatico proximo a "+t.getText()+"\n");
            pw.print("Linha "+line+": erro sintatico proximo a "+t.getText()+"\n");
        }
        System.out.print("Fim da compilacao\n");
        pw.print("Fim da compilacao\n");
        throw new RuntimeException();
    }
    
}
