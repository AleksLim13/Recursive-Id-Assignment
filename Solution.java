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

		//Create:
		int origLength = n.length();
		List<Integer> splList = new ArrayList<>();
		List<String> zList = new ArrayList<>();
		List<String> zDupesList = new ArrayList<>();
		String outN = n;

		boolean flag = true;
		//Iterate: per a condition that will evaluate to false eventually.
		while(flag){

			//Reset:
			splList.clear();

			int iN = Integer.valueOf(outN);
			//Iterate:
			while(iN > 0){
				//Strip: last digit.
				splList.add(iN % 10);
				//Remove: what just stripped.
				iN = iN / 10;
			}//End W:*

			//Declare: and initialize String holders for x, y, z.
			String sX = "";
			String sY = "";
			String sZ = "";

			//Order: rules say y is ascending.
			Collections.sort(splList);

			//Repeat: pass, convert, add and assign single letters to one word.
			for(int i = 0; i < splList.size(); i++){
				sY += String.valueOf(splList.get(i));
			}//End F:*

			//Order: rules say x is descending.
			Collections.reverse(splList);

			//Repeat: pass, convert, add and assign single letters to one word.
			for(int i = 0; i < splList.size(); i++){
				sX += String.valueOf(splList.get(i));
			}//End F:*

			//A: parse x and y per base.
			int xTemp = Integer.parseInt(sX, b);
			int yTemp = Integer.parseInt(sY, b);

			//B: calculate and parse result to string.
			String sResult = Integer.toString(xTemp-yTemp, b);

			//Convert: then assign.
			sZ = String.valueOf(sResult);

			//Store: converted version of z.
			int oCheck = Integer.valueOf(sZ);

			//Check: rules say zero means return length 1.
			if(oCheck == 0){
				return 1;
			}//End I:

			//Check: the length of z. Adjust per rules.
			if(origLength != sZ.length()){

				//Determine:
				int diff = origLength - sZ.length();
				//Assign:
				int sZTemp = Integer.valueOf(sZ);
				//Create:
				List<Integer> l0List = new ArrayList<>();

				//Repeat:
				while(sZTemp > 0){
					//Add:
					l0List.add(sZTemp % 10);
					//Remove:
					sZTemp = sZTemp / 10;
				}//End W:*

				//Repeat:
				for(int i = 0; i < diff; i++){
					//Add:
					l0List.add(0);
				}//End F:*

				//Create:
				String l0Temp = "";
				//Repeat:
				for(int i = 0; i < l0List.size(); i++){
					//Add:
					l0Temp += String.valueOf(l0List.get(i));
				}//End F:*

				//Assign:
				sZ = l0Temp;
			}//End I:*

			//Add:
			zList.add(sZ);

			//Assign: updated this variable outside scope of loop.

			//Assign:
			outN = sZ;

			//A: Create: checking for duplicates in z storage.
			int lCount = 0;
			int lTempZ = Integer.valueOf(sZ);
			//B: Repeat:
			for(int i = 0; i < zList.size(); i++){
				//C: Check:
				int zListTempZ = Integer.valueOf(zList.get(i));
				if(lTempZ == zListTempZ){
					//D: Increase:
					lCount++;
				}//End I:*
			}//End F:*

			//A: Check: all this just to get index of first repeat.
			if(lCount > 1){
				//B: Create:
				int start = 0;
				int last = Integer.valueOf(zList.get(zList.size()-1));
				//C: Repeat:
				for(int i = 0; i < zList.size(); i++){
					//D: Check:
					int tempZ = Integer.valueOf(zList.get(i));
					if(tempZ == last){
						//Assign:
						start = i;
						//Leave:
						break;
					}//End I:*
				}//End F:*

				//A: Repeat: add elements from start and end position found.
				for(int i = start; i < zList.size()-1; i++){
					//B: Add:
					zDupesList.add(zList.get(i));
				}//End F:*
				//C: Copy:
				return zDupesList.size();
			}//End I:*

		}//End W:*

		//Copy:
		return zDupesList.size();

	}//End M:*

}//End CL:*
