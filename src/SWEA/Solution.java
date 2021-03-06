package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int p; // 마스터 라인수
	static int q; // 사용자 라인수
	
	static char[][] prr; // 마스터 내용
	static char[][] qrr; // 사용자 내용
	static int[] res;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for(int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			prr = new char[p][];
			qrr = new char[q][];
	
			res = new int[q];
			
//			사용된 흔적은 판단하는 수로 초기화
			for(int i = 0 ; i < q; i++) {
				res[i] = -2; 
			}
			
			for(int i = 0 ; i < p ; i++) {
				prr[i] = br.readLine().toCharArray();
			}
			for(int i = 0 ; i < q; i++) {
				qrr[i] = br.readLine().toCharArray();
			}
//			솔루션 구현 -> 전체 탐색하는 방법
			for(int r = 1; r <= 20 ; r++) {
				for(int c = 1 ; c <= 20; c++) {
					for(int s = 1 ; s <= 20; s++) {
						if(isFind(r,c,s)) {
							solve(r,c,s);
						}
					}
				}
			}
			
			
			
			System.out.print("#" + t + " " ); //추가 출력
			for(int i = 0; i < q; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}

	}
	private static boolean isFind(int r, int c, int s) {
		int rCnt = 0, cCnt = 0, sCnt = 0;
		boolean flag = true;
		int cnt =0;
		int intent = 0;
		for(int i = 0 ; i < p; i++) {
			cnt = 0;
			
			//'.' 띄어쓰기 개수 카운트
			for(char ch : prr[i]) {
				if(ch == '.') {
					cnt++;
				}else {
					// .이 아니면 바로 아웃
					break;
				}
			}
			
//			공백 판단
			intent = rCnt * r + cCnt * c + sCnt * s;
			
			
			if(intent != cnt) {
				flag = false;
				break;
			}
			
			for(char ch : prr[i]) {
				switch(ch) {
				case '(':
					rCnt++;
					break;
				case ')':
					rCnt--;
					break;
				case '{':
					cCnt++;
					break;
				case '}':
					cCnt--;
					break;
				case '[':
					sCnt++;
					break;
				case ']':
					sCnt--;
					break;
				}
			}
		}
		return flag;
	}
	private static void solve(int r, int c, int s) {

		int rCnt = 0, cCnt = 0, sCnt = 0;
		int intent;
		for(int i = 0 ; i < q; i++) {
			intent = rCnt * r + cCnt * c + sCnt * s;
			
//			조금더 판단 필요
			if(res[i] == -2) {
				res[i] = intent; //처음들어가는 값인지 아닌지 판단
			}else if(res[i] != intent){
				res[i] = -1;  // 5  5  5
			}
			
			
			
			for(char ch : qrr[i]) {
				switch(ch) {
				case '(':
					rCnt++;
					break;
				case ')':
					rCnt--;
					break;
				case '{':
					cCnt++;
					break;
				case '}':
					cCnt--;
					break;
				case '[':
					sCnt++;
					break;
				case ']':
					sCnt--;
					break;
				}
			}
		}
		
	}

	static String src = "9\r\n" + 
			"5 4\r\n" + 
			"(Follow.my.style\r\n" + 
			".........starting.from.round.brackets)\r\n" + 
			"{then.curly.brackets\r\n" + 
			".....[.and.finally\r\n" + 
			".......square.brackets.]}\r\n" + 
			"(Thank.you\r\n" + 
			"{for.showing.me\r\n" + 
			"[all\r\n" + 
			"the.secrets]})\r\n" + 
			"4 2\r\n" + 
			"(This.time.I.will.show.you\r\n" + 
			".........(how.to.use.round.brackets)\r\n" + 
			".........[but.not.about.square.brackets]\r\n" + 
			".........{nor.curly.brackets})\r\n" + 
			"(I.learned\r\n" + 
			"how.to.use.round.brackets)\r\n" + 
			"4 2\r\n" + 
			"(This.time.I.will.show.you\r\n" + 
			".........(how.to.use.round.brackets)\r\n" + 
			".........[but.not.about.square.brackets]\r\n" + 
			".........{nor.curly.brackets})\r\n" + 
			"[I.have.not.learned\r\n" + 
			"how.to.use.square.brackets]\r\n" + 
			"2 2\r\n" + 
			"(Be.smart.and.let.fear.of\r\n" + 
			"..(closed.brackets).go)\r\n" + 
			"(A.pair.of.round.brackets.enclosing\r\n" + 
			"[A.line.enclosed.in.square.brackets])\r\n" + 
			"1 2\r\n" + 
			"Telling.you.nothing.but.you.can.make.it\r\n" + 
			"[One.liner.(is).(never.indented)]\r\n" + 
			"[One.liner.(is).(never.indented)]\r\n" + 
			"2 4\r\n" + 
			"([{Learn.from.my.KungFu\r\n" + 
			"...}])\r\n" + 
			"((\r\n" + 
			"{{\r\n" + 
			"[[\r\n" + 
			"]]}}))\r\n" + 
			"1 2\r\n" + 
			"Do.not.waste.your.time.trying.to.read.from.emptiness\r\n" + 
			"(\r\n" + 
			")\r\n" + 
			"2 3\r\n" + 
			"({Quite.interesting.art.of.ambiguity\r\n" + 
			"....})\r\n" + 
			"{\r\n" + 
			"(\r\n" + 
			")}\r\n" + 
			"2 4\r\n" + 
			"({[\r\n" + 
			"............................................................]})\r\n" + 
			"(\r\n" + 
			"{\r\n" + 
			"[\r\n" + 
			"]})";

}




























