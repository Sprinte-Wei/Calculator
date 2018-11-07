package sample.parser;

import sample.lexer.Token;
import sample.lexer.TokenType;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Parser {
    private State[][] sTable = new State[8][6];//状态表
    private int[] rs = new int[]{1,3,3,1};//产生式右部符号个数,用于出栈
    private int[] ls = new int[]{-1,4,4,4};//产生式左部非终结符号对应列号

    public Parser()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                sTable[i][j] = new State();
            }
        }

        sTable[0][0].setState(3);
        sTable[0][2].setState(2);
        sTable[0][4].setState(1);
        sTable[1][1].setState(4);
        sTable[1][5].setState(0);
        sTable[2][0].setState(3);
        sTable[2][2].setState(2);
        sTable[2][4].setState(5);
        sTable[4][0].setState(3);
        sTable[4][2].setState(2);
        sTable[4][4].setState(6);
        sTable[5][1].setState(4);
        sTable[5][3].setState(7);
        for(int i = 0; i < 6; i++)
        {
            sTable[3][i].setState(4);
            sTable[3][i].setR(true);
            sTable[6][i].setState(2);
            sTable[6][i].setR(true);
            sTable[7][i].setState(3);
            sTable[7][i].setR(true);
        }
    }

    public void readString (List<Token> tokens)throws SyntaxException
    {
        //建立token状态栈
        Stack<String> stringStack = new Stack<>();
        stringStack.push("0");

        //建立token队列
        Queue<Token> tokenQueue = new LinkedList<>();
        for(int i = 0; i < tokens.size(); i++)
        {
            Token t = tokens.get(i);
            if(t.getType().equals(TokenType.MINUS))
            {
                if(i == 0 || tokens.get(i-1).getType().equals(TokenType.LEFT_PARENTHESIS))
                {
                    tokenQueue.offer(new Token(TokenType.NUMBER,"0", t.getLocation()));//负号前面补零
                }
            }
            tokenQueue.offer(t);
        }
        tokenQueue.offer(new Token(TokenType.END,"", (tokens.get(tokens.size()-1)).getLocation() + (tokens.get(tokens.size()-1).getValue()).length()));//补上句子结尾

        //开始读取
        int Vn = -1;//记录非终结符号，用于递归
        while (tokenQueue.peek() != null)
        {
            //获得状态，即表的行数
            int state = Integer.parseInt(stringStack.peek());

            //获得符号，即表的列数
            int symbol;
            if(Vn > 0) symbol = Vn;
            else {
                Token temp = tokenQueue.peek();
                TokenType type = temp.getType();
                if (type.equals(TokenType.NUMBER)) symbol = 0;
                else if (type.equals((TokenType.LEFT_PARENTHESIS))) symbol = 2;
                else if (type.equals(TokenType.RIGHT_PARENTHESIS)) symbol = 3;
                else if (type.equals(TokenType.END)) symbol = 5;
                else symbol = 1;
            }

            //通过表内容来进行处理
            State nextState = sTable[state][symbol];
            if(nextState.getState() == -1) throw new SyntaxException(tokenQueue.peek().getLocation());//输入形式错误
            else if(nextState.isR())//规约状态
            {
                for(int i = 0; i < rs[nextState.getState() - 1] * 2; i++)
                {
                    stringStack.pop();//归约弹出应该的符号和状态
                }
                Vn = ls[nextState.getState() - 1];
            }
            else//移入状态
            {
                if(Vn > 0) stringStack.push(Integer.toString(Vn));
                else stringStack.push(tokenQueue.poll().getValue());
                stringStack.push(Integer.toString(nextState.getState()));
                Vn = -1;
            }
        }
        //若可读取结束，证明句子正确
    }
}
