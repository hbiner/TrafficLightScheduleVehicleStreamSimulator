package TrafficLightScheduleVehicleStreamSimulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficLightScheduleVehicleStreamSimulator {
	
	public String taskId = "1";
	
	public String tupoString = "tl44,tl42,tl43,#,tl19;tl44,tl43,tl19,tl42,#;tl44,tl19,#,tl43,tl42;tl43,tl44,tl41,tl18,#;tl43,tl41,#,tl44,tl18;tl43,tl18,tl44,#,tl41;tl42,tl26,tl41,#,tl44;tl42,tl41,tl44,tl26,#;tl42,tl44,#,tl41,tl26;tl41,tl42,tl25,tl43,tl40;tl41,tl25,tl40,tl42,tl43;tl41,tl40,tl43,tl25,tl42;tl41,tl43,tl42,tl40,tl25;tl40,tl41,tl24,tl17,tl39;tl40,tl24,tl39,tl41,tl17;tl40,tl39,tl17,tl24,tl41;tl40,tl17,tl41,tl39,tl24;tl39,tl40,tl23,tl16,#;tl39,tl23,#,tl40,tl16;tl39,tl16,tl40,#,tl23;tl38,tl12,tl37,#,tl5;tl38,tl37,tl5,tl12,#;tl38,tl5,#,tl37,tl12;tl37,tl38,tl11,tl4,tl36;tl37,tl11,tl36,tl38,tl4;tl37,tl36,tl4,tl11,tl38;tl37,tl4,tl38,tl36,tl11;tl36,tl37,tl10,tl3,#;tl36,tl10,#,tl37,tl3;tl36,tl3,tl37,#,tl10;tl35,tl52,tl58,tl28,tl34;tl35,tl58,tl34,tl52,tl28;tl35,tl34,tl28,tl58,tl52;tl35,tl28,tl52,tl34,tl58;tl34,tl35,tl57,tl27,tl33;tl34,tl57,tl33,tl35,tl27;tl34,tl33,tl27,tl57,tl35;tl34,tl27,tl35,tl33,tl57;tl33,tl34,tl56,tl26,tl32;tl33,tl56,tl32,tl34,tl26;tl33,tl32,tl26,tl56,tl34;tl33,tl26,tl34,tl32,tl56;tl32,tl33,tl55,tl25,tl31;tl32,tl55,tl31,tl33,tl25;tl32,tl31,tl25,tl55,tl33;tl32,tl25,tl33,tl31,tl55;tl31,tl32,#,tl24,tl30;tl31,tl30,tl24,#,tl32;tl31,tl24,tl32,tl30,#;tl30,tl31,tl54,tl23,tl29;tl30,tl54,tl29,tl31,tl23;tl30,tl29,tl23,tl54,tl31;tl30,tl23,tl31,tl29,tl54;tl29,tl30,tl53,tl22,tl51;tl29,tl53,tl51,tl30,tl22;tl29,tl51,tl22,tl53,tl30;tl29,tl22,tl30,tl51,tl53;tl28,tl35,tl27,#,tl21;tl28,tl27,tl21,tl35,#;tl28,tl21,#,tl27,tl35;tl27,tl28,tl34,tl20,tl26;tl27,tl34,tl26,tl28,tl20;tl27,tl26,tl20,tl34,tl28;tl27,tl20,tl28,tl26,tl34;tl26,tl27,tl33,tl42,tl25;tl26,tl33,tl25,tl27,tl42;tl26,tl25,tl42,tl33,tl27;tl26,tl42,tl27,tl25,tl33;tl25,tl26,tl32,tl41,tl24;tl25,tl32,tl24,tl26,tl41;tl25,tl24,tl41,tl32,tl26;tl25,tl41,tl26,tl24,tl32;tl24,tl25,tl31,tl40,tl23;tl24,tl31,tl23,tl25,tl40;tl24,tl23,tl40,tl31,tl25;tl24,tl40,tl25,tl23,tl31;tl23,tl24,tl30,tl39,tl22;tl23,tl30,tl22,tl24,tl39;tl23,tl22,tl39,tl30,tl24;tl23,tl39,tl24,tl22,tl30;tl22,tl23,tl29,tl14,#;tl22,tl29,#,tl23,tl14;tl22,tl14,tl23,#,tl29;tl21,tl28,tl20,#,tl6;tl21,tl20,tl6,tl28,#;tl21,tl6,#,tl20,tl28;tl20,tl21,tl27,#,tl19;tl20,tl27,tl19,tl21,#;tl20,tl19,#,tl27,tl21;tl19,tl20,tl44,tl12,tl18;tl19,tl44,tl18,tl20,tl12;tl19,tl18,tl12,tl44,tl20;tl19,tl12,tl20,tl18,tl44;tl18,tl19,tl43,tl11,tl17;tl18,tl43,tl17,tl19,tl11;tl18,tl17,tl11,tl43,tl19;tl18,tl11,tl19,tl17,tl43;tl17,tl18,tl40,tl10,tl16;tl17,tl40,tl16,tl18,tl10;tl17,tl16,tl10,tl40,tl18;tl17,tl10,tl18,tl16,tl40;tl16,tl17,tl39,tl9,tl15;tl16,tl39,tl15,tl17,tl9;tl16,tl15,tl9,tl39,tl17;tl16,tl9,tl17,tl15,tl39;tl15,tl16,#,tl8,tl14;tl15,tl14,tl8,#,tl16;tl15,tl8,tl16,tl14,#;tl14,tl15,tl22,tl7,#;tl14,tl22,#,tl15,tl7;tl14,tl7,tl15,#,tl22;tl12,tl19,tl11,#,tl38;tl12,tl11,tl38,tl19,#;tl12,tl38,#,tl11,tl19;tl11,tl12,tl18,tl37,tl10;tl11,tl18,tl10,tl12,tl37;tl11,tl10,tl37,tl18,tl12;tl11,tl37,tl12,tl10,tl18;tl10,tl11,tl17,tl36,tl9;tl10,tl17,tl9,tl11,tl36;tl10,tl9,tl36,tl17,tl11;tl10,tl36,tl11,tl9,tl17;tl9,tl10,tl16,tl2,tl8;tl9,tl16,tl8,tl10,tl2;tl9,tl8,tl2,tl16,tl10;tl9,tl2,tl10,tl8,tl16;tl8,tl9,tl15,#,tl7;tl8,tl15,tl7,tl9,#;tl8,tl7,#,tl15,tl9;tl7,tl8,tl14,tl1,tl13;tl7,tl14,tl13,tl8,tl1;tl7,tl13,tl1,tl14,tl8;tl7,tl1,tl8,tl13,tl14;tl1,tl2,tl7,#,tl45;tl1,tl7,tl45,tl2,#;tl1,tl45,#,tl7,tl2;tl2,tl47,tl3,tl1,tl9;tl2,tl3,tl9,tl47,tl1;tl2,tl9,tl1,tl3,tl47;tl2,tl1,tl47,tl9,tl3;tl3,tl4,tl36,#,tl2;tl3,tl36,tl2,tl4,#;tl3,tl2,#,tl36,tl4;tl4,tl48,tl5,tl3,tl37;tl4,tl5,tl37,tl48,tl3;tl4,tl37,tl3,tl5,tl48;tl4,tl3,tl48,tl37,tl5;tl5,tl49,tl6,tl4,tl38;tl5,tl6,tl38,tl49,tl4;tl5,tl38,tl4,tl6,tl49;tl5,tl4,tl49,tl38,tl6;tl6,tl50,tl46,tl5,tl21;tl6,tl46,tl21,tl50,tl5;tl6,tl21,tl5,tl46,tl50;tl6,tl5,tl50,tl21,tl46";
	public Map<String,String[]> trafficLightMap= new HashMap<String,String[]>();
	
	public Map<String, Integer[]> trafficFlowMap = new HashMap<String,Integer[]>();

	//从Traffic_Light_Table.txt读取所有路口红绿灯位置关系信息
	public Map<String, String[]> trafficLightTable = new ConcurrentHashMap<String, String[]>();
	
	//所有路口某个小时的静态流量表和动态流量表(数组长度为120)
	public Map<String, Integer[]> FlowTable = new ConcurrentHashMap<String,Integer[]>();
	public Map<String, Integer[]> dynamicFlowTable = new ConcurrentHashMap<String,Integer[]>();
	
	//传出参数:某个小时某个时段T(i)所有路口的车流量
	public Map<String, Integer> currentFlows = new ConcurrentHashMap<String,Integer>();
	
	//传出参数:某个时段T(i)所有路口车辆的 转向概率:[左转,右转,直行]
	public Map<String, Double[]> turnRate = new ConcurrentHashMap<String,Double[]>();
	
	//传出参数:某个时段T(i)所有路口车辆的 通过率:[左转,右转,直行]
	public Map<String, Integer[]> throughRate = new ConcurrentHashMap<String,Integer[]>();
	
	//传入参数：某个时段T(i)所有路口红 绿灯的状态:[左转,右转,直行] (红灯为0，绿等为1,缺失-1)
	public Map<String, Integer[]> currentStatus = new ConcurrentHashMap<String,Integer[]>();
	
	//某个小时内红绿灯的历史信息
	public Map<String, ArrayList<Integer[]>> statusHistory = new ConcurrentHashMap<String,ArrayList<Integer[]>>();
	//14个小时的penalty
	//所有taskId对应的penalty
	public Map<String, Double[]> penaltyMap =  new ConcurrentHashMap<String, Double[]>();
	public boolean inited = false;
	//初始化对应的penalty数组
	public void initPenalty(String taskId) {
		Double[] penalty = {0.0,0.0,0.0,0.0,
                             0.0,0.0,0.0,0.0,
                             0.0,0.0,0.0,0.0,0.0,0.0};
		penaltyMap.put(taskId, penalty);
	}
	public static void main(String[] args) throws NumberFormatException, IOException{
		TrafficLightScheduleVehicleStreamSimulator g = new TrafficLightScheduleVehicleStreamSimulator();
		g.run();
	}
	
	public void run() throws NumberFormatException, IOException{
		initTrafficLightMap();
		setLightInfo(taskId);
		inittrafficFlowMap(1);
		initPenalty(taskId);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int count = 0; count < 1680; count++){
			if(count % 120 == 0)
				hourInit(taskId,count/120);
			
			updateDynamicFlowTable(taskId, count%120);
			getCurrentFlow(taskId,count%120);
			System.out.println(printCurrentFlow());
			String status_str = br.readLine();
			readcurrentStatus(status_str);
			setCurrentStatus(count % 120);
			updatePenalty(taskId,count%120,count/120);
		}
		getTrafficLightScheduleVehicleStreamSimulator(taskId);
	}
	
	public void readcurrentStatus(String status_str) throws IOException{
		String[] statuses = status_str.trim().split(";");
		for(String status: statuses){
			if(status.length() == 0)
				continue;
			String[] items = status.trim().split(",");
			currentStatus.put(items[0]+"-"+items[1]+"-"+taskId, new Integer[]{Integer.parseInt(items[2]),Integer.parseInt(items[3]),Integer.parseInt(items[4])});
		}
		
	}
	
	public String printCurrentFlow(){
		String res = "";
		for(String key : currentFlows.keySet()){
			String[] items = key.split("-");
			res += items[0]+","+items[1]+","+currentFlows.get(key)+";";
		}
		return res;
	}
	
	
	

	
	//从trafficLightTable读取红绿灯位置信息
	public void setLightInfo(String taskId){
		for (String aKey : trafficLightMap.keySet()) {
			String[] keyStrings = aKey.split("-");
			String taks_key = keyStrings[0] + "-" + keyStrings[1] + "-" + taskId;
			trafficLightTable.put(taks_key,trafficLightMap.get(aKey));
		}

	}
	
	public  void initTrafficLightMap() {
		String[] pathStrings = tupoString.split(";");
		for (String aPathString : pathStrings) {
			String[] aStrings = aPathString.split(",");
			String aKey = aStrings[0] + "-" + aStrings[1];
			String[] aValue = {aStrings[2],aStrings[3],aStrings[4]};
			trafficLightMap.put(aKey, aValue);
		}
	}
	public void inittrafficFlowMap(int n) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("F:\\alibaba\\flow090"+n+".txt")));
		String s;
		while( (s = br.readLine()) != null){
			String[] aStrings = s.trim().split(",");
			String aKey = aStrings[0] + "-" + aStrings[1];
			Integer[] aValue = new Integer[1680];
			for(int i = 0; i < 1680; i++)
				aValue[i] = Integer.parseInt(aStrings[i+2]);
			trafficFlowMap.put(aKey, aValue);
		}
	}
	
	// 第i个小时状态初始化
	public void hourInit(String taskId,int i) throws NumberFormatException, IOException {
		
		for (String aKey : trafficFlowMap.keySet()) {
			String[] keyStrings = aKey.split("-");
			String taks_key = keyStrings[0] + "-" + keyStrings[1] + "-" + taskId;
			
			  Integer[] values = new Integer[120];
			  for (int i1 = 0; i1 < values.length; i1++) {
				 values[i1] = trafficFlowMap.get(aKey)[i*120 + i1];			
			}
			FlowTable.put(taks_key,values);
			dynamicFlowTable.put(taks_key,values.clone());
		}
		
		//初始化turnRate:[0.1,0.1,0.8]、throughRate:[2,2,16]、statusHistory
		for(String key : trafficLightTable.keySet()){

			if(!taskId.equals(key.split("-")[2])){
				continue;
			}
			//十字路口转向概率
			Double[] initTurnRate = {0.1,0.1,0.8};
			
			//丁字路口,无左转方向
			if (trafficLightTable.get(key)[0].equals("#")) {
				initTurnRate[1] += initTurnRate[0];
				initTurnRate[0] -= initTurnRate[0];				
			}else if (trafficLightTable.get(key)[1].equals("#")) {
				//丁字路口,无右转方向
				initTurnRate[0] += initTurnRate[1];
				initTurnRate[1] -= initTurnRate[1];
			}else if (trafficLightTable.get(key)[2].equals("#")) {
				//丁字路口,无直行方向
				initTurnRate[0] += initTurnRate[2]*0.5;
				initTurnRate[1] += initTurnRate[2]*0.5;
				initTurnRate[2] -= initTurnRate[2];
			}
			
			Integer[] initThroughRate = {2,2,16};
			
			ArrayList<Integer[]> initStatusHistory = new ArrayList<Integer[]>();
			for (int j = 0; j < 120; j++) {
				
				Integer[] aStatus = {0,0,0};
			if ("#".equals(trafficLightTable.get(key)[0])) {
				aStatus[0] = -1;
			}else if ("#".equals(trafficLightTable.get(key)[1])) {
				aStatus[1] = -1;
			}else if ("#".equals(trafficLightTable.get(key)[2])) {
				aStatus[2] = -1;
			}
			
				initStatusHistory.add(aStatus);
			}
			
			turnRate.put(key, initTurnRate);
			throughRate.put(key, initThroughRate);
			statusHistory.put(key, initStatusHistory);
		}
	}
	
	//根据最近一段时间红绿历史状态表计算转向概率[ALPHA,BETA,GAMMA],初赛为固定值不更新
	public void updateTurnRate() {
		
		/**for (String key : statusHistory.keySet()) {
			Double[] rate = {0.1,0.1,0.8};
			turnRate.put(key, rate);
		}*/
	}
	
	//根据路口车流量计算车辆通过率[TH1,TH2,TH3],初赛通过率固定值为不更新
	public void updateThroughRate() {
		/**		
		for(String key : currentFlows.keySet()){
			Integer[] rate = {5,5,20};
			throughRate.put(key, rate);
		}*/
	}

	//传入参数：第i时刻currentStatus,更新到statusHistory
	public void setCurrentStatus(int i) {
		
		for(String key :currentStatus.keySet()){
			if (statusHistory.containsKey(key)) {
				for (int j = 0; j < 3; j++) {
					if ("#".equals(trafficLightTable.get(key)[j])) {
						//如果路口不通，强制将灯设置为-1
						statusHistory.get(key).get(i)[j] = -1;
					} else {
						//如果路口是通的，不允许将灯设置为-1
						statusHistory.get(key).get(i)[j] = Math.max(0, currentStatus.get(key)[j]);
					}
				}
				
			}
		}
	}
	
	//根据statusHistory(i)、dynamicFlowTable(i)计算T(i)时刻某路口滞留车辆数
	public int computeStay(String key, int i) {
		
		//左转右转直行实际能够通过的车辆数
		int leftThrough,rightThrough,straightThrough;
		leftThrough=rightThrough=straightThrough = 0;
		//绿灯时通过率才有效
		if (statusHistory.get(key).get(i)[0]==1) {
			leftThrough = throughRate.get(key)[0];
		}
		if (statusHistory.get(key).get(i)[1]==1) {
			rightThrough = throughRate.get(key)[1];
		}
		if (statusHistory.get(key).get(i)[2]==1) {
			straightThrough = throughRate.get(key)[2];
		}
		
		//dynamicFlow(i)
		int iFlow = dynamicFlowTable.get(key)[i];
		//左转右转直行的滞留车辆
		int leftStay,rightStay,straightStay;
		leftStay = rightStay = straightStay = 0;
		
		double leftRate = turnRate.get(key)[0];
		double rihgtRate = turnRate.get(key)[1];
		double straightRate = turnRate.get(key)[2];

		//上取整可能会导致流量增大一点
		leftStay = Math.max(0, (int)Math.ceil(iFlow*leftRate) - leftThrough);
		rightStay = Math.max(0, (int)Math.ceil(iFlow*rihgtRate) - rightThrough);
		straightStay = Math.max(0,(int)Math.ceil(iFlow*straightRate)-straightThrough);

		//LOGGER.error("key="+key+",i="+i+",leftStay="+leftStay+",rightStay="+rightStay+",straightStay="+straightStay);
		//返回T(i)时刻滞留车辆数
		//System.out.println("allStay===" +(leftStay + rightStay + straightStay));
		return (leftStay + rightStay + straightStay);
		
	}
	
	/*根据红绿灯位置信息表、T(i-1)时段的：车流量、所有红绿灯状态、车辆转向概率、车辆通过率 
     *计算T(i)时刻车流量
     *dynamicFlowTable(i)=LAMADA*FlowTable(i) + G(trafficLightTable,statusHistory(i-1),dynamicFlowTable(i-1),turnRate(i-1),throughRate(i-1))
     */
	public void updateDynamicFlowTable(String taskId, int i) {
		
		for(String key :dynamicFlowTable.keySet()){
    		
			String tId = key.split("-")[2];
    		
			if (tId.equals(taskId)) {
				if (i==0) {
		    		dynamicFlowTable.get(key)[i] =  FlowTable.get(key)[i];					
				} else {
					
					//观察值系数LAMADA
					double LAMADA = 0.5;
					//更新flow,加上系数LAMADA*Flow(i)
					dynamicFlowTable.get(key)[i] = (int)(Math.floor(LAMADA*FlowTable.get(key)[i]));
					
					//结合statusHistory(i-1)加上 dynamicFlow(i-1)的 左转滞留+右转滞留+直行滞留						
					int allStay = 0;
					//优化代码用函数实现
					allStay = computeStay(key, i-1);											
					//更新，加上滞留车辆
					dynamicFlowTable.get(key)[i] += allStay;
										
					//加上FromID从其他路口流入的车辆
					int flowIn1,flowIn2,flowIn3;
					flowIn1 = flowIn2 = flowIn3 = 0;
					
					//反向路径ID
					String[] keyStrings = key.split("-");
					String antiKey = keyStrings[1] + "-" + keyStrings[0] + "-" + taskId;
					//反向路径存在于trafficLightTable中才有意义
					if (trafficLightTable.containsKey(antiKey)) {
						//流入车辆的来源ID
						String antiLeftID = trafficLightTable.get(antiKey)[0];
						String antiRightID = trafficLightTable.get(antiKey)[1];
						String antiStraightID = trafficLightTable.get(antiKey)[2];
							
						String antiLeftKey = keyStrings[1]  + "-" + antiLeftID + "-" + keyStrings[2];
						String antiRightKey = keyStrings[1] + "-" + antiRightID + "-" + keyStrings[2];
						String antiStraightKey = keyStrings[1] + "-" + antiStraightID + "-" + keyStrings[2];
							

							
						//从 antiLeftID 右转流入
						if (!(trafficLightTable.get(antiLeftKey)==null)&&(statusHistory.get(antiLeftKey).get(i-1)[1]==1)) {
							flowIn1 = Math.min(throughRate.get(antiLeftKey)[1], (int)Math.ceil(dynamicFlowTable.get(antiLeftKey)[i-1]*turnRate.get(antiLeftKey)[1]));
						}
						//从 antiRightID 左转流入
						if (!(trafficLightTable.get(antiRightKey)==null)&&(statusHistory.get(antiRightKey).get(i-1)[0]==1)) {
							flowIn2 = Math.min(throughRate.get(antiRightKey)[0], (int)Math.ceil(dynamicFlowTable.get(antiRightKey)[i-1]*turnRate.get(antiRightKey)[0]));
						}
						//从 antiStraightKey 直行流入
						if(!(trafficLightTable.get(antiStraightKey)==null)&&(statusHistory.get(antiStraightKey).get(i-1)[2]==1)){
							flowIn3 = Math.min(throughRate.get(antiStraightKey)[2], (int)Math.ceil(dynamicFlowTable.get(antiStraightKey)[i-1]*turnRate.get(antiStraightKey)[2]));
						}
					}					

					//更新，加上流入车辆
					dynamicFlowTable.get(key)[i] += flowIn1 + flowIn2 + flowIn3;
					//System.out.println("  " + key +"-" + i + " flow:" +dynamicFlowTable.get(key)[i] );
						
				}
			}
		}
			
	}

	//用 dynamicFlowTable 设置 currentFlow 传出
	public Map<String, Integer> getCurrentFlow(String taskId, int i){

			for(String key : dynamicFlowTable.keySet()){
				if (taskId.equals(key.split("-")[2])) {
					currentFlows.put(key, dynamicFlowTable.get(key)[i]);
				}
			}
			return currentFlows;
	}	

	//根据currentStatus(i)更新第k个小时penalty
	public void updatePenalty(String taskId,int i,int k){
		
		double old_penalty0 = penaltyMap.get(taskId)[k];
		
		//每个路口T(i)时刻penalty: 左转滞留+右转滞留+直行滞留;违反交通规则扣分;违反公平性原则扣分
		for(String key : dynamicFlowTable.keySet()){
			
			double old_penalty = penaltyMap.get(taskId)[k];
			
			String[] lights = key.split("-");
			if (taskId.equals(lights[2])) {
				//更新，车辆滞留部分
				penaltyMap.get(taskId)[k] += computeStay(key, i);
				//更新，加上红绿灯违反交通规则的惩罚 a:直行垂直直行惩罚 b:直行垂直左转惩罚
				double a,b;
				a=b=0.0;			
				//交通违规的惩罚倍数
				double zeta =0.5;
				
				String leftKey = lights[0] + "-" + trafficLightTable.get(key)[0] + "-" + lights[2];
				String rightKey = lights[0] + "-" + trafficLightTable.get(key)[1] + "-" + lights[2];
				
				//垂直方向不能同时直行																				
				if (statusHistory.get(key).get(i)[2]==1 &&
					((statusHistory.containsKey(leftKey) && statusHistory.get(leftKey).get(i)[2]==1) 
					|| (statusHistory.containsKey(rightKey) && statusHistory.get(rightKey).get(i)[2]==1))) {
						
					a += zeta*dynamicFlowTable.get(key)[i];
						
					if (dynamicFlowTable.containsKey(leftKey)) {
							a += zeta*dynamicFlowTable.get(leftKey)[i];
					}
						
					if (dynamicFlowTable.containsKey(rightKey)) {
							a += zeta*dynamicFlowTable.get(rightKey)[i];
					}
						
				}
				
				//直行时垂直方向右侧不能左转
				if (statusHistory.get(key).get(i)[2]==1 && statusHistory.containsKey(rightKey) && statusHistory.get(rightKey).get(i)[0]==1) {

						b += zeta*(dynamicFlowTable.get(rightKey)[i] + dynamicFlowTable.get(key)[i]);
				}
				if( false && lights[0].equals("tl11")){
					System.out.println(key+"\t"+computeStay(key, i)+"\t"+a+"\t"+b+"\t"+(0.5*a+b));
				}
				
				//违规扣分
				penaltyMap.get(taskId)[k] += 0.5*a + b;

				//更新，加上违反公平原则扣分 v*sqrt(r-4)
				if (i>3) {
					for (int j = 0; j < 3; j++) {
						if (statusHistory.get(key).get(i)[j]==0) {
							int waitTime = 1;
							int waitStart = i;
							//修改bug
							while ((waitStart>0) && statusHistory.get(key).get(waitStart-1)[j]==0) {
								waitTime += 1;
								waitStart -=1;
							}
							penaltyMap.get(taskId)[k] += (int)Math.ceil(dynamicFlowTable.get(key)[i]*Math.sqrt(Math.max(waitTime-4, 0)));
						}
					}
				}
			}		
			//System.out.print(lights[0]+"\t"+lights[1]+"\t");
			//System.out.println(penaltyMap.get(taskId)[k]-old_penalty);
		}
		
		//System.out.println((k*120+i)+"\t"+(penaltyMap.get(taskId)[k]-old_penalty0));
		
		//System.out.println(k + "th hour" + i + "th Penalty======" + penaltyMap.get(taskId)[k]);
		
	}
	
	//输出最终得分
	public int getTrafficLightScheduleVehicleStreamSimulator(String taskId) {
		
		if (penaltyMap.containsKey(taskId)) {
			int score = 0;
			for (int i = 0; i < penaltyMap.get(taskId).length; i++) {
				score += penaltyMap.get(taskId)[i];	
		}			

            //清缓存数据
            //System.out.println("returnSumScore=\t" + score);
			return score;
		} else {
			//出异常的得分为-1
			return -1;
		}			
	}
	


}