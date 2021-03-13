public class InfixEvaluation implements Stack {
	int Top_operator=-1;
	int Top_value=-1;
	int MAX=10;
	char[] operator=new char[MAX];
	int[] value=new int[MAX];
	char[] precedence={'^','/','*','+','-'};
	@Override
	public boolean isEmpty(int Top) {
		// TODO Auto-generated method stub
		if(Top==-1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean isFull(int Top) {
		// TODO Auto-generated method stub
		if(Top==MAX-1){
			return true;
		}return false;
	}
	
	@Override
	public char pop_char() {
		// TODO Auto-generated method stub
		if(this.isEmpty(Top_operator)){
			return 0;
		}else{
			 char chr=operator[Top_operator];
			 Top_operator--;
			 return chr;
		}
	}

	@Override
	public void push(char value) {
		// TODO Auto-generated method stub
		if(this.isFull(Top_operator)){
			System.out.println("Stack is full");
		}else{
			Top_operator++;
			operator[Top_operator]=value;
		}
		
	}


	@Override
	public int pop_int() {
		if(this.isEmpty(Top_value)){
			return 0;
		}else{
			 int val=value[Top_value];
			 Top_value--;
			 return val;
		}
	}

	@Override
	public void push(int number) {
		// TODO Auto-generated method stub
		if(this.isFull(Top_value)){
			System.out.println("Stack is full");
		}else{
			Top_value++;
			value[Top_value]=number;
		}
	}
	private int precedenceValue(char chr){
		for(int i=0;i<precedence.length;i++){
			if(chr==precedence[i]){
				return i;
			}
		}
		return 0;
	}
	private int arithmeticOperations(){
		int num1=pop_int();
		int num2=pop_int();
		char operation=pop_char();
		 switch (operation) {
         case '+':
             return num1 + num2;
         case '-':
             return num2 - num1;
         case '*':
             return num1 * num2;
         case '/':
             if (num1 == 0)
                 throw new
                         UnsupportedOperationException("Cannot divide by zero");
             return num2 / num1;
     }
     return 0;
	}
	public int infixEvalute(String expression){
		if("".equals(expression)){
			return 0;
		}else{
			char[] char_express=expression.toCharArray();
			for(int i=0;i<char_express.length;i++){
				char chr= char_express[i];
				if(chr=='(' ){
					this.push(chr);
				}else if(chr==')'){
					while(this.operator[Top_operator]!='('){
						int output= arithmeticOperations();
						this.push(output);
					}
					pop_char();
				}else if(Character.isDigit(chr)){
					int num = 0;
	                while (Character.isDigit(chr)) {
	                    num = num*10 + (chr-'0');
	                    i++;
	                    if(i < char_express.length)
	                        chr = char_express[i];
	                    else
	                        break;
	                }
	                i--;
					this.push(num);
				}else if(chr=='+'||chr=='-'||chr=='*'||chr=='/'||chr=='^'){
					if(this.isEmpty(Top_operator)){
						this.push(chr);
					}else{
						if(precedenceValue(chr)<precedenceValue(operator[Top_operator])){
							this.push(chr);
						}else{
							while(!isEmpty(Top_operator)&& precedenceValue(chr)>=precedenceValue(operator[Top_operator])){
								int output=arithmeticOperations();
								push(output);
							}
						}
					}
				}
			}
			while(!isEmpty(Top_operator)){
				int output = arithmeticOperations();
				push(output);
			}
		return pop_int();
		}
	}
}
