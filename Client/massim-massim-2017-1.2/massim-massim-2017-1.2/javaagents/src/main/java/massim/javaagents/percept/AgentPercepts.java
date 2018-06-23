package massim.javaagents.percept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import eis.iilang.Identifier;
import eis.iilang.Parameter;
import eis.iilang.ParameterList;
import eis.iilang.Percept;

/**
 *
 * @author Sarah
 */
public class AgentPercepts
{

	private List<Percept>							percepts			= new Vector<>();
	role											selfRole;
	private List<massim.javaagents.percept.item>	itemsInEnv			= new Vector<>();
	public Map<String, item>						ItemsInEnv			= new HashMap<>();
	private List<Pair<item, Integer>>				carriedItems		= new Vector<>();
	private self									selfInfo			= new self();
	private List<entity>							entities			= new Vector<>();
	public Map<String, entity>						Entities			= new HashMap<>();
	private List<shop>								shops				= new Vector<>();
	public Map<String, shop>						Shops				= new HashMap<>();
	public Map<String, List<shop>>					shopsByItem			= new HashMap<>();
	private List<workshop>							workshops			= new Vector<>();
	public Map<String, workshop>					Workshops			= new HashMap<>();
	private List<dump>								dumps				= new Vector<>();
	public Map<String, dump>						Dumps				= new HashMap<>();
	private List<chargingStation>					chargingStations	= new Vector<>();
	public Map<String, chargingStation>				ChargingStations	= new HashMap<>();
	private List<storage>							storages			= new Vector<>();
	public Map<String, storage>						Storages			= new HashMap<>();
	private List<resourceNode>						resourceNodes		= new Vector<>();
	public Map<String, resourceNode>				ResourceNodes		= new HashMap<>();
	private int										step;
	private List<routeDetail>						routes				= new Vector<>();
	private int										routeLength;
	private String									map;
	private int										simSteps;
	private int										seedCapital;
	private List<job>								jobs				= new Vector<>();
	public Map<String, job>							Jobs				= new HashMap<>();
	private List<auction>							auctions			= new Vector<>();
	public Map<String, auction>						Auctions			= new HashMap<>();
	private List<auction>							missions			= new Vector<>();
	public Map<String, auction>						Missions			= new HashMap<>();

	public AgentPercepts()
	{
	}

	public AgentPercepts(role selfRole, int step, int routeLength, String map, int simSteps, int seedCapital)
	{
		this.selfRole = selfRole;
		this.step = step;
		this.routeLength = routeLength;
		this.map = map;
		this.simSteps = simSteps;
		this.seedCapital = seedCapital;
	}

	// setter and getter

	public List<Percept> getPercepts()
	{
		return percepts;
	}

	public void setPercepts(List<Percept> percepts)
	{
		this.percepts = percepts;
	}

	public role getSelfRole()
	{
		return selfRole;
	}

	public void setSelfRole(role selfRole)
	{
		this.selfRole = selfRole;
	}

	public List<item> getItemsInEnv()
	{
		return itemsInEnv;
	}

	public void setItemsInEnv(List<item> itemsInEnv)
	{
		this.itemsInEnv = itemsInEnv;
	}

	public self getSelfInfo()
	{
		return selfInfo;
	}

	public void setSelfInfo(self selfInfo)
	{
		this.selfInfo = selfInfo;
	}

	public List<entity> getEntities()
	{
		return entities;
	}

	public void setEntities(List<entity> entities)
	{
		this.entities = entities;
	}

	public List<shop> getShops()
	{
		return shops;
	}

	public void setShops(List<shop> shops)
	{
		this.shops = shops;
	}

	public List<workshop> getWorkshops()
	{
		return workshops;
	}

	public void setWorkshops(List<workshop> workshops)
	{
		this.workshops = workshops;
	}

	public List<dump> getDumps()
	{
		return dumps;
	}

	public void setDumps(List<dump> dumps)
	{
		this.dumps = dumps;
	}

	public List<chargingStation> getChargingStations()
	{
		return chargingStations;
	}

	public void setChargingStations(List<chargingStation> chargingStations)
	{
		this.chargingStations = chargingStations;
	}

	public List<storage> getStorages()
	{
		return storages;
	}

	public void setStorages(List<storage> storages)
	{
		this.storages = storages;
	}

	public List<resourceNode> getResourceNodes()
	{
		return resourceNodes;
	}

	public void setResourceNodes(List<resourceNode> resourceNodes)
	{
		this.resourceNodes = resourceNodes;
	}

	public int getStep()
	{
		return step;
	}

	public void setStep(int step)
	{
		this.step = step;
	}

	public List<routeDetail> getRoutes()
	{
		return routes;
	}

	public void setRoutes(List<routeDetail> routes)
	{
		this.routes = routes;
	}

	public int getRouteLength()
	{
		return routeLength;
	}

	public void setRouteLength(int routeLength)
	{
		this.routeLength = routeLength;
	}

	public String getMap()
	{
		return map;
	}

	public void setMap(String map)
	{
		this.map = map;
	}

	public int getSimSteps()
	{
		return simSteps;
	}

	public void setSimSteps(int simSteps)
	{
		this.simSteps = simSteps;
	}

	public int getSeedCapital()
	{
		return seedCapital;
	}

	public void setSeedCapital(int seedCapital)
	{
		this.seedCapital = seedCapital;
	}

	public List<job> getJobs()
	{
		return jobs;
	}

	public void setJobs(List<job> jobs)
	{
		this.jobs = jobs;
	}

	public List<auction> getAuctions()
	{
		return auctions;
	}

	public void setAuctions(List<auction> auctions)
	{
		this.auctions = auctions;
	}

	public List<auction> getMissions()
	{
		return missions;
	}

	public void setMissions(List<auction> missions)
	{
		this.missions = missions;
	}

	public void initialize()
	{
		for (Percept p : percepts)
		{
			switch (p.getName())
			{
				case "role":

					eis.iilang.Identifier agName = (eis.iilang.Identifier) p.getParameters().toArray()[0];
					String name = agName.getValue();
					eis.iilang.Numeral agSpeed = (eis.iilang.Numeral) p.getParameters().toArray()[1];
					int speed = agSpeed.getValue().intValue();
					eis.iilang.Numeral agLoad = (eis.iilang.Numeral) p.getParameters().toArray()[2];
					int load = agLoad.getValue().intValue();
					eis.iilang.Numeral agBattery = (eis.iilang.Numeral) p.getParameters().toArray()[3];
					int battery = agBattery.getValue().intValue();
					List<String> tools = new Vector<>();
					ParameterList agTools = listParam(p, 4);
					for (Parameter tool : agTools)
					{
						if (tool instanceof Identifier)
						{
							String toolName = ((Identifier) tool).getValue();
							tools.add(toolName);
						}
					}
					selfRole = new role(battery, load, name, speed, tools);
					break;

				case "item":

					eis.iilang.Identifier itName = (eis.iilang.Identifier) p.getParameters().toArray()[0];
					String itemName = itName.getValue();
					eis.iilang.Numeral itVolume = (eis.iilang.Numeral) p.getParameters().toArray()[1];
					int itemVolume = itVolume.getValue().intValue();
					List<String> itemTools = new Vector<>();
					eis.iilang.Function toolFunction = (eis.iilang.Function) p.getParameters().toArray()[2];
					ParameterList toolsRequired = (ParameterList) toolFunction.getParameters().get(0);
					String toolName;
					for (int j = 0; j < toolsRequired.size(); j++)
					{
						eis.iilang.Identifier itTool = (eis.iilang.Identifier) toolsRequired.get(j);
						toolName = itTool.getValue();
						itemTools.add(toolName);
					}

					List<subItem> itemParts = new Vector<>();
					eis.iilang.Function partFunction = (eis.iilang.Function) p.getParameters().toArray()[3];
					ParameterList partsRequired = (ParameterList) partFunction.getParameters().get(0);

					for (int i = 0; i < partsRequired.size(); i++)
					{
						eis.iilang.ParameterList subItem = (eis.iilang.ParameterList) partsRequired.get(i);
						eis.iilang.Identifier sn = (eis.iilang.Identifier) subItem.get(0);
						eis.iilang.Numeral sa = (eis.iilang.Numeral) subItem.get(1);
						String subItemName = sn.getValue();
						int subItemAmount = sa.getValue().intValue();
						subItem newSubItem = new subItem(subItemName, subItemAmount);
						itemParts.add(newSubItem);
					}
					massim.javaagents.percept.item newItem = new item(itemName, itemVolume, itemTools, itemParts);
					itemsInEnv.add(newItem);
					ItemsInEnv.putIfAbsent(itemName, newItem);

					break;
			}
		}
	}

	public void stepPercept()
	{
		carriedItems.clear();
		Entities.clear();
		shops.clear();
		workshops.clear();
		chargingStations.clear();
		dumps.clear();
		resourceNodes.clear();
		storages.clear();
		routes.clear();
		jobs.clear();
		auctions.clear();
		missions.clear();
		shopsByItem.clear();

		for (Percept p : percepts)
		{
			switch (p.getName())
			{
				case "hasItem":
					eis.iilang.Identifier itName = (eis.iilang.Identifier) p.getParameters().toArray()[0];
					String itemsName = itName.getValue();
					eis.iilang.Numeral itAmount = (eis.iilang.Numeral) p.getParameters().toArray()[1];
					int itemsAmount = itAmount.getValue().intValue();
					carriedItems.add(new Pair<>(ItemsInEnv.get(itemsName), itemsAmount));

					selfInfo.setCarriedItems(carriedItems);
					break;
				case "charge":
					eis.iilang.Numeral batteryInfo = (eis.iilang.Numeral) p.getParameters().toArray()[0];
					int battery = batteryInfo.getValue().intValue();
					selfInfo.setCharge(battery);
					break;

				case "lat":
					eis.iilang.Numeral latInfo = (eis.iilang.Numeral) p.getParameters().toArray()[0];
					double lat = latInfo.getValue().doubleValue();
					selfInfo.setLat(lat);
					break;

				case "load":
					eis.iilang.Numeral loadInfo = (eis.iilang.Numeral) p.getParameters().toArray()[0];
					int load = loadInfo.getValue().intValue();
					selfInfo.setLoad(load);
					break;

				case "lon":
					eis.iilang.Numeral lonInfo = (eis.iilang.Numeral) p.getParameters().toArray()[0];
					double lon = lonInfo.getValue().doubleValue();
					selfInfo.setLon(lon);
					break;

				case "name":
					String name = "";
					name = p.toProlog();
					selfInfo.setName(name);
					break;

				case "team":
					String team = stringParam(p.getParameters(), 0);
					selfInfo.setTeam(team);
					break;

				case "money":
					eis.iilang.Numeral moneyInfo = (eis.iilang.Numeral) p.getParameters().toArray()[0];
					int money = moneyInfo.getValue().intValue();
					selfInfo.setTeamMoney(money);
					break;

				case "lastAction":
					String lastAction = stringParam(p.getParameters(), 0);
					selfInfo.setLastAction(lastAction);
					break;

				case "lastActionResult":
					String lastActionResult = stringParam(p.getParameters(), 0);
					selfInfo.setLastActionResult(lastActionResult);
					break;

				case "lastActionParams":
					break;

				case "entity":
					eis.iilang.Identifier Name = (eis.iilang.Identifier) p.getParameters().toArray()[0];
					String entityname = Name.getValue();

					eis.iilang.Identifier Team = (eis.iilang.Identifier) p.getParameters().toArray()[1];
					String entityteam = Team.getValue();

					eis.iilang.Numeral Lat = (eis.iilang.Numeral) p.getParameters().toArray()[2];
					double entitylat = Lat.getValue().doubleValue();

					eis.iilang.Numeral Lon = (eis.iilang.Numeral) p.getParameters().toArray()[3];
					double entitylon = Lon.getValue().doubleValue();

					eis.iilang.Identifier eRole = (eis.iilang.Identifier) p.getParameters().toArray()[4];
					String entityrole = eRole.getValue();

					entity newEntity = new entity(entityname, entityteam, entitylat, entitylon, entityrole);
					entities.add(newEntity);
					Entities.putIfAbsent(entityname, newEntity);
					break;

				case "shop":

					eis.iilang.Identifier shopNameInfo = (eis.iilang.Identifier) p.getParameters().toArray()[0];
					String shopName = shopNameInfo.getValue();

					eis.iilang.Numeral shopLatInfo = (eis.iilang.Numeral) p.getParameters().toArray()[1];
					double shopLat = shopLatInfo.getValue().doubleValue();

					eis.iilang.Numeral shopLonInfo = (eis.iilang.Numeral) p.getParameters().toArray()[2];
					double shopLon = shopLonInfo.getValue().doubleValue();

					eis.iilang.Numeral shopRestockInfo = (eis.iilang.Numeral) p.getParameters().toArray()[3];
					int shopRestock = shopRestockInfo.getValue().intValue();

					List<shopItem> shopItems = new Vector<>();
					ParameterList shopItemInfo = (ParameterList) p.getParameters().toArray()[4];
					for (int i = 0; i < shopItemInfo.size(); i++)
					{
						eis.iilang.Function shItem = (eis.iilang.Function) shopItemInfo.get(i);
						eis.iilang.Identifier shItemName = (eis.iilang.Identifier) shItem.getParameters().get(0);
						String shopItemName = shItemName.getValue();
						eis.iilang.Numeral shItemPrice = (eis.iilang.Numeral) shItem.getParameters().get(1);
						int price = shItemPrice.getValue().intValue();
						eis.iilang.Numeral shItemAmount = (eis.iilang.Numeral) shItem.getParameters().get(2);
						int amount = shItemAmount.getValue().intValue();

						shopItem newShopItem = new shopItem(amount, shopItemName, price);
						shopItems.add(newShopItem);

						shopsByItem.putIfAbsent(shopItemName, new ArrayList<shop>());
						shopsByItem.get(shopItemName).add(new shop(shopLat, shopLon, shopName, shopRestock, shopItems));
					}
					shop newShop = new shop(shopLat, shopLon, shopName, shopRestock, shopItems);
					shops.add(newShop);
					Shops.putIfAbsent(shopName, newShop);

					break;

				case "workshop":

					eis.iilang.Identifier workshopName = (eis.iilang.Identifier) p.getParameters().toArray()[0];
					String wName = workshopName.getValue();

					eis.iilang.Numeral workShopLat = (eis.iilang.Numeral) p.getParameters().get(1);
					double wLat = workShopLat.getValue().doubleValue();

					eis.iilang.Numeral workShopLon = (eis.iilang.Numeral) p.getParameters().get(2);
					double wLon = workShopLon.getValue().doubleValue();

					workshop newWorkshop = new workshop(wName, wLat, wLon);
					workshops.add(newWorkshop);
					Workshops.putIfAbsent(wName, newWorkshop);
					break;

				case "chargingStation":

					eis.iilang.Identifier chargingStationName = (eis.iilang.Identifier) p.getParameters().toArray()[0];
					String csName = chargingStationName.getValue();

					eis.iilang.Numeral chargingStationLat = (eis.iilang.Numeral) p.getParameters().get(1);
					double csLat = chargingStationLat.getValue().doubleValue();

					eis.iilang.Numeral chargingStationLon = (eis.iilang.Numeral) p.getParameters().get(2);
					double csLon = chargingStationLon.getValue().doubleValue();

					eis.iilang.Numeral chargingStationRate = (eis.iilang.Numeral) p.getParameters().get(3);
					int csRate = chargingStationRate.getValue().intValue();

					chargingStation newchargingStation = new chargingStation(csName, csLat, csLon, csRate);
					chargingStations.add(newchargingStation);
					ChargingStations.putIfAbsent(csName, newchargingStation);
					break;

				case "dump":

					eis.iilang.Identifier dumpName = (eis.iilang.Identifier) p.getParameters().toArray()[0];
					String dName = dumpName.getValue();

					eis.iilang.Numeral dumpLat = (eis.iilang.Numeral) p.getParameters().get(1);
					double dLat = dumpLat.getValue().doubleValue();

					eis.iilang.Numeral dumpLon = (eis.iilang.Numeral) p.getParameters().get(2);
					double dLon = dumpLon.getValue().doubleValue();

					dump newdump = new dump(dName, dLat, dLon);
					dumps.add(newdump);
					Dumps.putIfAbsent(dName, newdump);
					break;
				case "storage":

					eis.iilang.Identifier stName = (eis.iilang.Identifier) p.getParameters().toArray()[0];
					String storageName = stName.getValue();

					eis.iilang.Numeral stLat = (eis.iilang.Numeral) p.getParameters().get(1);
					double storageLat = stLat.getValue().doubleValue();

					eis.iilang.Numeral stLon = (eis.iilang.Numeral) p.getParameters().get(2);
					double storageLon = stLon.getValue().doubleValue();

					eis.iilang.Numeral stTotalCapacity = (eis.iilang.Numeral) p.getParameters().get(3);
					int storageTotalCapacity = stTotalCapacity.getValue().intValue();

					eis.iilang.Numeral stUsedCapacity = (eis.iilang.Numeral) p.getParameters().get(4);
					int storageUsedCapacity = stUsedCapacity.getValue().intValue();

					List<storageItem> storageItems = new Vector<>();
					ParameterList storageItemInfo = (ParameterList) p.getParameters().toArray()[5];
					for (int i = 0; i < storageItemInfo.size(); i++)
					{
						eis.iilang.Function stItem = (eis.iilang.Function) storageItemInfo.get(i);
						eis.iilang.Identifier stItemName = (eis.iilang.Identifier) stItem.getParameters().get(0);
						String storageItemName = stItemName.getValue();
						eis.iilang.Numeral stItemDelivered = (eis.iilang.Numeral) stItem.getParameters().get(1);
						int storageItemDelivered = stItemDelivered.getValue().intValue();
						eis.iilang.Numeral stItemStored = (eis.iilang.Numeral) stItem.getParameters().get(2);
						int storageItemStored = stItemStored.getValue().intValue();

						storageItem newStorageItem = new storageItem(storageItemName, storageItemDelivered, storageItemStored);
						storageItems.add(newStorageItem);
					}
					storage newStorage = new storage(storageName, storageLat, storageLon, storageTotalCapacity, storageUsedCapacity, storageItems);
					storages.add(newStorage);
					Storages.putIfAbsent(storageName, newStorage);
					break;
				case "resourceNode":

					eis.iilang.Identifier rnName = (eis.iilang.Identifier) p.getParameters().toArray()[0];
					String resourceNodeName = rnName.getValue();

					eis.iilang.Numeral rnLat = (eis.iilang.Numeral) p.getParameters().get(1);
					double resourceNodeLat = rnLat.getValue().doubleValue();

					eis.iilang.Numeral rnLon = (eis.iilang.Numeral) p.getParameters().get(2);
					double resourceNodeLon = rnLon.getValue().doubleValue();

					eis.iilang.Identifier rnResource = (eis.iilang.Identifier) p.getParameters().toArray()[3];
					String resourceNodeResource = rnResource.getValue();

					resourceNode newResourceNode = new resourceNode(resourceNodeName, resourceNodeLat, resourceNodeLon, resourceNodeResource);
					resourceNodes.add(newResourceNode);
					ResourceNodes.putIfAbsent(resourceNodeName, newResourceNode);
					break;

				case "step":

					eis.iilang.Numeral stepNumber = (eis.iilang.Numeral) p.getParameters().get(0);
					step = stepNumber.getValue().intValue();

					break;

				case "route":

					ParameterList routesInfo = (ParameterList) p.getParameters().toArray()[0];
					for (int i = 0; i < routesInfo.size(); i++)
					{
						eis.iilang.Function routeFunction = (eis.iilang.Function) routesInfo.get(i);
						eis.iilang.Numeral rNumber = (eis.iilang.Numeral) routeFunction.getParameters().get(0);
						int routeNumber = rNumber.getValue().intValue();
						eis.iilang.Numeral rLat = (eis.iilang.Numeral) routeFunction.getParameters().get(1);
						double routeLat = rLat.getValue().doubleValue();
						eis.iilang.Numeral rLon = (eis.iilang.Numeral) routeFunction.getParameters().get(2);
						double routeLon = rLon.getValue().doubleValue();
						routeDetail newRouteDetail = new routeDetail(routeNumber, routeLat, routeLon);
						routes.add(newRouteDetail);
					}

					break;

				case "seedCapital":

					eis.iilang.Numeral sCapital = (eis.iilang.Numeral) p.getParameters().get(0);
					seedCapital = sCapital.getValue().intValue();

					break;

				case "steps":

					eis.iilang.Numeral s = (eis.iilang.Numeral) p.getParameters().get(0);
					simSteps = s.getValue().intValue();

					break;

				case "map":

					eis.iilang.Identifier mapName = (eis.iilang.Identifier) p.getParameters().get(0);
					map = mapName.getValue();

					break;

				case "routeLength":

					eis.iilang.Numeral rLength = (eis.iilang.Numeral) p.getParameters().get(0);
					routeLength = rLength.getValue().intValue();

					break;

				case "actionID":

					break;
				case "job":

					eis.iilang.Identifier jID = (eis.iilang.Identifier) p.getParameters().get(0);
					String jobID = jID.getValue();

					eis.iilang.Identifier jStorage = (eis.iilang.Identifier) p.getParameters().get(1);
					String jobStorage = jStorage.getValue();

					eis.iilang.Numeral jReward = (eis.iilang.Numeral) p.getParameters().get(2);
					int jobReward = jReward.getValue().intValue();

					eis.iilang.Numeral jStart = (eis.iilang.Numeral) p.getParameters().get(3);
					int jobStart = jStart.getValue().intValue();

					eis.iilang.Numeral jEnd = (eis.iilang.Numeral) p.getParameters().get(4);
					int jobEnd = jEnd.getValue().intValue();

					List<Pair<String, Integer>> jobRequireds = new Vector<>();
					ParameterList requiredsInfo = (ParameterList) p.getParameters().get(5);
					for (int i = 0; i < requiredsInfo.size(); i++)
					{
						eis.iilang.Function reqInfo = (eis.iilang.Function) requiredsInfo.get(i);
						eis.iilang.Identifier reqItemName = (eis.iilang.Identifier) reqInfo.getParameters().get(0);
						String requiredItemName = reqItemName.getValue();
						eis.iilang.Numeral reqItemAmount = (eis.iilang.Numeral) reqInfo.getParameters().get(1);
						int requiredItemAmount = reqItemAmount.getValue().intValue();
						Pair<String, Integer> requiredItem = new Pair<>(requiredItemName, requiredItemAmount);
						jobRequireds.add(requiredItem);
					}
					boolean isSimple = true;
					if (requiredsInfo.size() > 1)
						isSimple = false;
					job newJob = new job(jobID, jobStorage, jobReward, jobStart, jobEnd, jobRequireds, isSimple);
					jobs.add(newJob);
					Jobs.putIfAbsent(jobID, newJob);
					break;
				case "auction":

					eis.iilang.Identifier aucID = (eis.iilang.Identifier) p.getParameters().get(0);
					String auctionID = aucID.getValue();

					eis.iilang.Identifier aucStorage = (eis.iilang.Identifier) p.getParameters().get(1);
					String auctionStorage = aucStorage.getValue();

					eis.iilang.Numeral aucReward = (eis.iilang.Numeral) p.getParameters().get(2);
					int auctionReward = aucReward.getValue().intValue();

					eis.iilang.Numeral aucStart = (eis.iilang.Numeral) p.getParameters().get(3);
					int auctionStart = aucStart.getValue().intValue();

					eis.iilang.Numeral aucEnd = (eis.iilang.Numeral) p.getParameters().get(4);
					int auctionEnd = aucEnd.getValue().intValue();

					eis.iilang.Numeral aucFine = (eis.iilang.Numeral) p.getParameters().get(5);
					int auctionFine = aucFine.getValue().intValue();

					eis.iilang.Numeral aucLowestBid = (eis.iilang.Numeral) p.getParameters().get(6);
					int auctionLowestBid = aucLowestBid.getValue().intValue();

					eis.iilang.Numeral aucTime = (eis.iilang.Numeral) p.getParameters().get(7);
					int auctionTime = aucTime.getValue().intValue();

					List<Pair<String, Integer>> auctionRequireds = new Vector<>();
					ParameterList aucRequiredsInfo = (ParameterList) p.getParameters().get(8);
					for (int i = 0; i < aucRequiredsInfo.size(); i++)
					{
						eis.iilang.Function reqInfo = (eis.iilang.Function) aucRequiredsInfo.get(i);
						eis.iilang.Identifier reqItemName = (eis.iilang.Identifier) reqInfo.getParameters().get(0);
						String requiredItemName = reqItemName.getValue();
						eis.iilang.Numeral reqItemAmount = (eis.iilang.Numeral) reqInfo.getParameters().get(1);
						int requiredItemAmount = reqItemAmount.getValue().intValue();
						Pair<String, Integer> requiredItem = new Pair<>(requiredItemName, requiredItemAmount);
						auctionRequireds.add(requiredItem);
					}
					auction newAuction = new auction(auctionID, auctionStorage, auctionReward, auctionStart, auctionEnd, auctionFine, auctionLowestBid, auctionTime, auctionRequireds);
					auctions.add(newAuction);
					Auctions.putIfAbsent(auctionID, newAuction);
					break;
				case "mission":

					eis.iilang.Identifier misID = (eis.iilang.Identifier) p.getParameters().get(0);
					String missionID = misID.getValue();

					eis.iilang.Identifier misStorage = (eis.iilang.Identifier) p.getParameters().get(1);
					String missionStorage = misStorage.getValue();

					eis.iilang.Numeral misReward = (eis.iilang.Numeral) p.getParameters().get(2);
					int missionReward = misReward.getValue().intValue();

					eis.iilang.Numeral misStart = (eis.iilang.Numeral) p.getParameters().get(3);
					int missionStart = misStart.getValue().intValue();

					eis.iilang.Numeral misEnd = (eis.iilang.Numeral) p.getParameters().get(4);
					int missionEnd = misEnd.getValue().intValue();

					eis.iilang.Numeral misFine = (eis.iilang.Numeral) p.getParameters().get(5);
					int missionFine = misFine.getValue().intValue();

					eis.iilang.Numeral misLowestBid = (eis.iilang.Numeral) p.getParameters().get(6);
					int missionLowestBid = misLowestBid.getValue().intValue();

					eis.iilang.Numeral misTime = (eis.iilang.Numeral) p.getParameters().get(7);
					int missionTime = misTime.getValue().intValue();

					List<Pair<String, Integer>> missionRequireds = new Vector<>();
					ParameterList misRequiredsInfo = (ParameterList) p.getParameters().get(9);
					for (int i = 0; i < misRequiredsInfo.size(); i++)
					{
						eis.iilang.Function reqInfo = (eis.iilang.Function) misRequiredsInfo.get(i);
						eis.iilang.Identifier reqItemName = (eis.iilang.Identifier) reqInfo.getParameters().get(0);
						String requiredItemName = reqItemName.getValue();
						eis.iilang.Numeral reqItemAmount = (eis.iilang.Numeral) reqInfo.getParameters().get(1);
						int requiredItemAmount = reqItemAmount.getValue().intValue();
						Pair<String, Integer> requiredItem = new Pair<>(requiredItemName, requiredItemAmount);
						missionRequireds.add(requiredItem);
					}
					auction newMission = new auction(missionID, missionStorage, missionReward, missionStart, missionEnd, missionFine, missionLowestBid, missionTime, missionRequireds);
					missions.add(newMission);
					Missions.putIfAbsent(missionID, newMission);
					break;
			}
		}
	}

	/**
	 * Tries to extract a parameter from a list of parameters.
	 *
	 * @param params
	 *            the parameter list
	 * @param index
	 *            the index of the parameter
	 * @return the string value of that parameter or an empty string if there is no parameter or it is not an identifier
	 */
	public static String stringParam(List<Parameter> params, int index)
	{
		if (params.size() < index + 1)
			return "";
		Parameter param = params.get(index);
		if (param instanceof Identifier)
			return ((Identifier) param).getValue();
		return "";
	}

	/**
	 * Tries to extract a parameter from a percept.
	 *
	 * @param p
	 *            the percept
	 * @param index
	 *            the index of the parameter
	 * @return the string value of that parameter or an empty string if there is no parameter or it is not an identifier
	 */
	private static ParameterList listParam(Percept p, int index)
	{
		List<Parameter> params = p.getParameters();
		if (params.size() < index + 1)
			return new ParameterList();
		Parameter param = params.get(index);
		if (param instanceof ParameterList)
			return (ParameterList) param;
		return new ParameterList();
	}
}