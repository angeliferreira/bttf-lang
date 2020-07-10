package br.com.lemao.bttflang.parser;

import org.parboiled.BaseParser;
import org.parboiled.Parboiled;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;

@BuildParseTree
public class BttfParser extends BaseParser<Object> {
	
	Rule MainMethod() {
        return Sequence(
            "YEAH, WELL, HISTORY IS GONNA CHANGE",
            WhiteSpace(),
            PrintStatement(),
            WhiteSpace(),
            "GUESS YOU GUYS AREN’T READY FOR THAT YET"
        );
    }
	
	Rule PrintStatement() {
		return Sequence(
            "DOC, YOU GOTTA LISTEN TO ME",
            WhiteSpace(),
            String()
        );
	}
	
	Rule String() {
		return Sequence("\"", ZeroOrMore(Sequence(ZeroOrMore(" "), AnyOf("\""), ZeroOrMore(" "), ANY, ZeroOrMore(" "))), "\"");
	}
	
	Rule WhiteSpace() {
		return OneOrMore(" ");
	}
	
	public void parse(String source) {
		BttfParser parser = Parboiled.createParser(BttfParser.class);
		ParsingResult<?> result = new ReportingParseRunner<BttfParser>(parser.MainMethod()).run(source);
		String parseTreePrintOut = ParseTreeUtils.printNodeTree(result);
		System.out.println(parseTreePrintOut);
	}
	
	public static void main(String[] args) {
		BttfParser parser = Parboiled.createParser(BttfParser.class);
		ParsingResult<?> result = new ReportingParseRunner<BttfParser>(parser.String()).run("\"   sasdsa\" asdasd asdasd   \"");
		String parseTreePrintOut = ParseTreeUtils.printNodeTree(result);
		System.out.println(parseTreePrintOut);
	}

}
