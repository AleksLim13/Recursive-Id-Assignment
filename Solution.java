import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}//End C:*


	public static void main(String[] args){
		System.out.println(Solution.solution("210022", 3));
	}//End M:*


	public static int solution(String n, int b){

		int origLength = n.length();
		List<Integer> splList = new ArrayList<>();
		List<String> zList = new ArrayList<>();
		List<String> zDupesList = new ArrayList<>();
		int count = 0;
		String outN = n;

		boolean flag = true;
		while(flag){
			splList.clear();

			int iN = Integer.valueOf(outN);
			while(iN > 0){
				splList.add(iN % 10);
				iN = iN / 10;
			}//End W:*

			String sX = "";
			String sY = "";
			String sZ = "";

			Collections.sort(splList);

			for(int i = 0; i < splList.size(); i++){
				sY += String.valueOf(splList.get(i));
			}//End F:*

			Collections.reverse(splList);

			for(int i = 0; i < splList.size(); i++){
				sX += String.valueOf(splList.get(i));
			}//End F:*

			//A: parse x and y per base.
			int xTemp = Integer.parseInt(sX, b);
			int yTemp = Integer.parseInt(sY, b);

			//B: calculate and parse result to string.
			String sResult = Integer.toString(xTemp-yTemp, b);

			sZ = String.valueOf(sResult);

			if(origLength != sZ.length()){

				int diff = origLength - sZ.length();
				int sZTemp = Integer.valueOf(sZ);
				List<Integer> l0List = new ArrayList<>();

				while(sZTemp > 0){
					l0List.add(sZTemp % 10);
					sZTemp = sZTemp / 10;
				}//End W:*

				for(int i = 0; i < diff; i++){
					l0List.add(0);
				}//End F:*

				String l0Temp = "";
				for(int i = 0; i < l0List.size(); i++){
					l0Temp += String.valueOf(l0List.get(i));
				}//End F:*

				sZ = l0Temp;
			}//End I:*

			zList.add(sZ);

			//Assign: updated this variable outside scope of loop.

			outN = sZ;

			int lCount = 0;
			int lTempZ = Integer.valueOf(sZ);

			for(int i = 0; i < zList.size(); i++){

				int zListTempZ = Integer.valueOf(zList.get(i));

				if(lTempZ == zListTempZ){
					lCount++;

				}//End I:*

			}//End F:*

			if(lCount > 1){
				int start = 0;
				int last = Integer.valueOf(zList.get(zList.size()-1));

				for(int i = 0; i < zList.size(); i++){
					int tempZ = Integer.valueOf(zList.get(i));
					if(tempZ == last){
						start = i;
						break;
					}//End I:*

				}//End F:*
				for(int i = start; i < zList.size()-1; i++){
					zDupesList.add(zList.get(i));
				}//End F:*
				return zDupesList.size();
			}//End I:*


		}//End W:*

		return 0;

	}//End M:*

}//End CL:*
