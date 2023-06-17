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
            // Grava na saída o erro personalizado para símbolos não identificados, igual ao do léxico
            pw.println("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado");
        } else if (t.getText().startsWith("\"") && !t.getText().endsWith("\"")){
            // Grava na saída o erro personalizado para cadeias não fechadas, igual ao do léxico
            pw.println("Linha "+line+": cadeia literal nao fechada");
        } else if(t.getText().startsWith("{") && !t.getText().endsWith("}")){
            // Grava na saída o erro personalizado para comentários não fechados, igual ao do léxico
            pw.println("Linha "+line+": comentario nao fechado");
        } else if(t.getText().equals("<EOF>")){
            // Agora registra os erros sintáticos. Esse é o caso específico do EOF, pois exige <> ao redor do lexema
            pw.println("Linha "+line+": erro sintatico proximo a "+t.getText().substring(1, t.getText().length() - 1));
        }else{
            // Registro geral de erro sintático, indicando a linha e o lexema próximo a onde encontrou o erro
            pw.println("Linha "+line+": erro sintatico proximo a "+t.getText());
        }
        pw.print("Fim da compilacao\n");
        throw new RuntimeException();
    }
    
}
