package bean;

import org.apache.htrace.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Game {

    private String key;
    private String region;
    private int game_id;
    private int game_state;
    private int game_mode;
    private int game_type;
    private int queue_type;
    private int map_id;
    private int mmr;
    private int season;
    private int patch;
    private double length;
    private String end_time;
    private String encryption_key;
    private int winner;
    private DataBean data;
    private List<PlayersBean> players;
    private List<?> banned_champions;
    private List<String> summoner_names;
    private List<Integer> champion_ids;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getGame_state() {
        return game_state;
    }

    public void setGame_state(int game_state) {
        this.game_state = game_state;
    }

    public int getGame_mode() {
        return game_mode;
    }

    public void setGame_mode(int game_mode) {
        this.game_mode = game_mode;
    }

    public int getGame_type() {
        return game_type;
    }

    public void setGame_type(int game_type) {
        this.game_type = game_type;
    }

    public int getQueue_type() {
        return queue_type;
    }

    public void setQueue_type(int queue_type) {
        this.queue_type = queue_type;
    }

    public int getMap_id() {
        return map_id;
    }

    public void setMap_id(int map_id) {
        this.map_id = map_id;
    }

    public int getMmr() {
        return mmr;
    }

    public void setMmr(int mmr) {
        this.mmr = mmr;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getPatch() {
        return patch;
    }

    public void setPatch(int patch) {
        this.patch = patch;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getEncryption_key() {
        return encryption_key;
    }

    public void setEncryption_key(String encryption_key) {
        this.encryption_key = encryption_key;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public List<PlayersBean> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayersBean> players) {
        this.players = players;
    }

    public List<?> getBanned_champions() {
        return banned_champions;
    }

    public void setBanned_champions(List<?> banned_champions) {
        this.banned_champions = banned_champions;
    }

    public List<String> getSummoner_names() {
        return summoner_names;
    }

    public void setSummoner_names(List<String> summoner_names) {
        this.summoner_names = summoner_names;
    }

    public List<Integer> getChampion_ids() {
        return champion_ids;
    }

    public void setChampion_ids(List<Integer> champion_ids) {
        this.champion_ids = champion_ids;
    }

    public static class DataBean {
    	
        private List<BuffGainedEventsBean> buffGainedEvents;
        private List<BuffLostEventsBean> buffLostEvents;
        private List<DamageEventsBean> damageEvents;
        private List<ExperienceEarnedEventsBean> experienceEarnedEvents;
        private List<GoldEarnedEventsBean> goldEarnedEvents;
        private List<GoldTickEventsBean> goldTickEvents;
        private List<ItemPurchaseEventsBean> itemPurchaseEvents;
        private List<LevelUpEventsBean> levelUpEvents;
        private List<LevelUpAbilityEventsBean> levelUpAbilityEvents;
        private List<MinionKillEventsBean> minionKillEvents;
        private List<PingEventsBean> pingEvents;
        private List<SpellCastEventsBean> spellCastEvents;
        private List<CampFramesBean> campFrames;
        private List<KillFramesBean> killFrames;
        private List<PositionFramesBean> positionFrames;
        private List<WardFramesBean> wardFrames;

        public List<BuffGainedEventsBean> getBuffGainedEvents() {
            return buffGainedEvents;
        }

        public void setBuffGainedEvents(List<BuffGainedEventsBean> buffGainedEvents) {
            this.buffGainedEvents = buffGainedEvents;
        }

        public List<BuffLostEventsBean> getBuffLostEvents() {
            return buffLostEvents;
        }

        public void setBuffLostEvents(List<BuffLostEventsBean> buffLostEvents) {
            this.buffLostEvents = buffLostEvents;
        }

        public List<DamageEventsBean> getDamageEvents() {
            return damageEvents;
        }

        public void setDamageEvents(List<DamageEventsBean> damageEvents) {
            this.damageEvents = damageEvents;
        }

        public List<ExperienceEarnedEventsBean> getExperienceEarnedEvents() {
            return experienceEarnedEvents;
        }

        public void setExperienceEarnedEvents(List<ExperienceEarnedEventsBean> experienceEarnedEvents) {
            this.experienceEarnedEvents = experienceEarnedEvents;
        }

        public List<GoldEarnedEventsBean> getGoldEarnedEvents() {
            return goldEarnedEvents;
        }

        public void setGoldEarnedEvents(List<GoldEarnedEventsBean> goldEarnedEvents) {
            this.goldEarnedEvents = goldEarnedEvents;
        }

        public List<GoldTickEventsBean> getGoldTickEvents() {
            return goldTickEvents;
        }

        public void setGoldTickEvents(List<GoldTickEventsBean> goldTickEvents) {
            this.goldTickEvents = goldTickEvents;
        }

        public List<ItemPurchaseEventsBean> getItemPurchaseEvents() {
            return itemPurchaseEvents;
        }

        public void setItemPurchaseEvents(List<ItemPurchaseEventsBean> itemPurchaseEvents) {
            this.itemPurchaseEvents = itemPurchaseEvents;
        }

        public List<LevelUpEventsBean> getLevelUpEvents() {
            return levelUpEvents;
        }

        public void setLevelUpEvents(List<LevelUpEventsBean> levelUpEvents) {
            this.levelUpEvents = levelUpEvents;
        }

        public List<LevelUpAbilityEventsBean> getLevelUpAbilityEvents() {
            return levelUpAbilityEvents;
        }

        public void setLevelUpAbilityEvents(List<LevelUpAbilityEventsBean> levelUpAbilityEvents) {
            this.levelUpAbilityEvents = levelUpAbilityEvents;
        }

        public List<MinionKillEventsBean> getMinionKillEvents() {
            return minionKillEvents;
        }

        public void setMinionKillEvents(List<MinionKillEventsBean> minionKillEvents) {
            this.minionKillEvents = minionKillEvents;
        }

        public List<PingEventsBean> getPingEvents() {
            return pingEvents;
        }

        public void setPingEvents(List<PingEventsBean> pingEvents) {
            this.pingEvents = pingEvents;
        }

        public List<SpellCastEventsBean> getSpellCastEvents() {
            return spellCastEvents;
        }

        public void setSpellCastEvents(List<SpellCastEventsBean> spellCastEvents) {
            this.spellCastEvents = spellCastEvents;
        }

        public List<CampFramesBean> getCampFrames() {
            return campFrames;
        }

        public void setCampFrames(List<CampFramesBean> campFrames) {
            this.campFrames = campFrames;
        }

        public List<KillFramesBean> getKillFrames() {
            return killFrames;
        }

        public void setKillFrames(List<KillFramesBean> killFrames) {
            this.killFrames = killFrames;
        }

        public List<PositionFramesBean> getPositionFrames() {
            return positionFrames;
        }

        public void setPositionFrames(List<PositionFramesBean> positionFrames) {
            this.positionFrames = positionFrames;
        }

        public List<WardFramesBean> getWardFrames() {
            return wardFrames;
        }

        public void setWardFrames(List<WardFramesBean> wardFrames) {
            this.wardFrames = wardFrames;
        }

        public static class BuffGainedEventsBean {
        	
            private double time;
            private int unitID;
            private int buffName;
            private double duration;

            public double getTime() {
                return time;
            }

            public void setTime(double time) {
                this.time = time;
            }

            public int getUnitID() {
                return unitID;
            }

            public void setUnitID(int unitID) {
                this.unitID = unitID;
            }

            public int getBuffName() {
                return buffName;
            }

            public void setBuffName(int buffName) {
                this.buffName = buffName;
            }

            public double getDuration() {
                return duration;
            }

            public void setDuration(double duration) {
                this.duration = duration;
            }
        }

        public static class BuffLostEventsBean {
        	
            private double time;
            private int unitID;
            private int buffName;

            public double getTime() {
                return time;
            }

            public void setTime(double time) {
                this.time = time;
            }

            public int getUnitID() {
                return unitID;
            }

            public void setUnitID(int unitID) {
                this.unitID = unitID;
            }

            public int getBuffName() {
                return buffName;
            }

            public void setBuffName(int buffName) {
                this.buffName = buffName;
            }
        }

        public static class DamageEventsBean {
        	
            private double time;
            private int receiverUnitID;
            private int dealerUnitID;
            private double damage;
            private int type;

            public double getTime() {
                return time;
            }

            public void setTime(double time) {
                this.time = time;
            }

            public int getReceiverUnitID() {
                return receiverUnitID;
            }

            public void setReceiverUnitID(int receiverUnitID) {
                this.receiverUnitID = receiverUnitID;
            }

            public int getDealerUnitID() {
                return dealerUnitID;
            }

            public void setDealerUnitID(int dealerUnitID) {
                this.dealerUnitID = dealerUnitID;
            }

            public double getDamage() {
                return damage;
            }

            public void setDamage(double damage) {
                this.damage = damage;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class ExperienceEarnedEventsBean {
        	
            private double time;
            private int unitID;
            private double experienceEarned;

            public double getTime() {
                return time;
            }

            public void setTime(double time) {
                this.time = time;
            }

            public int getUnitID() {
                return unitID;
            }

            public void setUnitID(int unitID) {
                this.unitID = unitID;
            }

            public double getExperienceEarned() {
                return experienceEarned;
            }

            public void setExperienceEarned(double experienceEarned) {
                this.experienceEarned = experienceEarned;
            }
        }

        public static class GoldEarnedEventsBean {
        	
            private double time;
            private int unitID;
            private int sourceUnitID;
            private double goldEarned;

            public double getTime() {
                return time;
            }

            public void setTime(double time) {
                this.time = time;
            }

            public int getUnitID() {
                return unitID;
            }

            public void setUnitID(int unitID) {
                this.unitID = unitID;
            }

            public int getSourceUnitID() {
                return sourceUnitID;
            }

            public void setSourceUnitID(int sourceUnitID) {
                this.sourceUnitID = sourceUnitID;
            }

            public double getGoldEarned() {
                return goldEarned;
            }

            public void setGoldEarned(double goldEarned) {
                this.goldEarned = goldEarned;
            }
        }

        public static class GoldTickEventsBean {
        	
            private int time;
            private int unitID;
            private int inventoryGold;
            private int totalGold;

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public int getUnitID() {
                return unitID;
            }

            public void setUnitID(int unitID) {
                this.unitID = unitID;
            }

            public int getInventoryGold() {
                return inventoryGold;
            }

            public void setInventoryGold(int inventoryGold) {
                this.inventoryGold = inventoryGold;
            }

            public int getTotalGold() {
                return totalGold;
            }

            public void setTotalGold(int totalGold) {
                this.totalGold = totalGold;
            }
        }

        public static class ItemPurchaseEventsBean {
        	
            private double time;
            private int unitID;
            private int itemID;
            private int slot;
            private int quantity;

            public double getTime() {
                return time;
            }

            public void setTime(double time) {
                this.time = time;
            }

            public int getUnitID() {
                return unitID;
            }

            public void setUnitID(int unitID) {
                this.unitID = unitID;
            }

            public int getItemID() {
                return itemID;
            }

            public void setItemID(int itemID) {
                this.itemID = itemID;
            }

            public int getSlot() {
                return slot;
            }

            public void setSlot(int slot) {
                this.slot = slot;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }
        }

        public static class LevelUpEventsBean {
        	
            private double time;
            private int unitID;
            private int level;

            public double getTime() {
                return time;
            }

            public void setTime(double time) {
                this.time = time;
            }

            public int getUnitID() {
                return unitID;
            }

            public void setUnitID(int unitID) {
                this.unitID = unitID;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }
        }

        public static class LevelUpAbilityEventsBean {

            private double time;
            private int unitID;
            private int slot;
            private int points;
            private int pointsRemaining;

            public double getTime() {
                return time;
            }

            public void setTime(double time) {
                this.time = time;
            }

            public int getUnitID() {
                return unitID;
            }

            public void setUnitID(int unitID) {
                this.unitID = unitID;
            }

            public int getSlot() {
                return slot;
            }

            public void setSlot(int slot) {
                this.slot = slot;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }

            public int getPointsRemaining() {
                return pointsRemaining;
            }

            public void setPointsRemaining(int pointsRemaining) {
                this.pointsRemaining = pointsRemaining;
            }
        }

        public static class MinionKillEventsBean {

            private double time;
            private int minionUnitID;
            private int killerUnitID;

            public double getTime() {
                return time;
            }

            public void setTime(double time) {
                this.time = time;
            }

            public int getMinionUnitID() {
                return minionUnitID;
            }

            public void setMinionUnitID(int minionUnitID) {
                this.minionUnitID = minionUnitID;
            }

            public int getKillerUnitID() {
                return killerUnitID;
            }

            public void setKillerUnitID(int killerUnitID) {
                this.killerUnitID = killerUnitID;
            }
        }

        public static class PingEventsBean {

            private double time;
            private int casterUnitID;
            private int targetUnitID;
            private double x;
            private double y;
            private int type;

            public double getTime() {
                return time;
            }

            public void setTime(double time) {
                this.time = time;
            }

            public int getCasterUnitID() {
                return casterUnitID;
            }

            public void setCasterUnitID(int casterUnitID) {
                this.casterUnitID = casterUnitID;
            }

            public int getTargetUnitID() {
                return targetUnitID;
            }

            public void setTargetUnitID(int targetUnitID) {
                this.targetUnitID = targetUnitID;
            }

            public double getX() {
                return x;
            }

            public void setX(double x) {
                this.x = x;
            }

            public double getY() {
                return y;
            }

            public void setY(double y) {
                this.y = y;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class SpellCastEventsBean {

            private double time;
            private int casterUnitID;
            private String name;
            private double x;
            private double y;
            private double z;
            private List<?> targets;

            public double getTime() {
                return time;
            }

            public void setTime(double time) {
                this.time = time;
            }

            public int getCasterUnitID() {
                return casterUnitID;
            }

            public void setCasterUnitID(int casterUnitID) {
                this.casterUnitID = casterUnitID;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getX() {
                return x;
            }

            public void setX(double x) {
                this.x = x;
            }

            public double getY() {
                return y;
            }

            public void setY(double y) {
                this.y = y;
            }

            public double getZ() {
                return z;
            }

            public void setZ(double z) {
                this.z = z;
            }

            public List<?> getTargets() {
                return targets;
            }

            public void setTargets(List<?> targets) {
                this.targets = targets;
            }
        }

        public static class CampFramesBean {

            private double spawnTime;
            private double deathTime;
            private int campUnitID;
            private int killerUnitID;
            private int x;
            private int y;

            public double getSpawnTime() {
                return spawnTime;
            }

            public void setSpawnTime(double spawnTime) {
                this.spawnTime = spawnTime;
            }

            public double getDeathTime() {
                return deathTime;
            }

            public void setDeathTime(double deathTime) {
                this.deathTime = deathTime;
            }

            public int getCampUnitID() {
                return campUnitID;
            }

            public void setCampUnitID(int campUnitID) {
                this.campUnitID = campUnitID;
            }

            public int getKillerUnitID() {
                return killerUnitID;
            }

            public void setKillerUnitID(int killerUnitID) {
                this.killerUnitID = killerUnitID;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }
        }

        public static class KillFramesBean {

            private double killTime;
            private double respawnTime;
            private int killerUnitID;
            private int victimUnitID;
            private int x;
            private int y;
            private List<Integer> assistersUnitIDs;

            public double getKillTime() {
                return killTime;
            }

            public void setKillTime(double killTime) {
                this.killTime = killTime;
            }

            public double getRespawnTime() {
                return respawnTime;
            }

            public void setRespawnTime(double respawnTime) {
                this.respawnTime = respawnTime;
            }

            public int getKillerUnitID() {
                return killerUnitID;
            }

            public void setKillerUnitID(int killerUnitID) {
                this.killerUnitID = killerUnitID;
            }

            public int getVictimUnitID() {
                return victimUnitID;
            }

            public void setVictimUnitID(int victimUnitID) {
                this.victimUnitID = victimUnitID;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public List<Integer> getAssistersUnitIDs() {
                return assistersUnitIDs;
            }

            public void setAssistersUnitIDs(List<Integer> assistersUnitIDs) {
                this.assistersUnitIDs = assistersUnitIDs;
            }
        }

        public static class PositionFramesBean {
        	
            private int time;
            private List<PlayerPositionsBean> playerPositions;

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public List<PlayerPositionsBean> getPlayerPositions() {
                return playerPositions;
            }

            public void setPlayerPositions(List<PlayerPositionsBean> playerPositions) {
                this.playerPositions = playerPositions;
            }

            public static class PlayerPositionsBean {
            	
                private int unitID;
                private PositionBean position;

                public int getUnitID() {
                    return unitID;
                }

                public void setUnitID(int unitID) {
                    this.unitID = unitID;
                }

                public PositionBean getPosition() {
                    return position;
                }

                public void setPosition(PositionBean position) {
                    this.position = position;
                }

                public static class PositionBean {
                	
                    private int x;
                    private int y;

                    public int getX() {
                        return x;
                    }

                    public void setX(int x) {
                        this.x = x;
                    }

                    public int getY() {
                        return y;
                    }

                    public void setY(int y) {
                        this.y = y;
                    }
                }
            }
        }

        public static class WardFramesBean {
        	
            private double startTime;
            private double endTime;
            private int wardUnitID;
            private int casterUnitID;
            private int x;
            private int y;

            public double getStartTime() {
                return startTime;
            }

            public void setStartTime(double startTime) {
                this.startTime = startTime;
            }

            public double getEndTime() {
                return endTime;
            }

            public void setEndTime(double endTime) {
                this.endTime = endTime;
            }

            public int getWardUnitID() {
                return wardUnitID;
            }

            public void setWardUnitID(int wardUnitID) {
                this.wardUnitID = wardUnitID;
            }

            public int getCasterUnitID() {
                return casterUnitID;
            }

            public void setCasterUnitID(int casterUnitID) {
                this.casterUnitID = casterUnitID;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }
        }
    }

    public static class PlayersBean {
    	
        private String name;
        private int teamID;
        private int localID;
        private int spell1ID;
        private int spell2ID;
        private int accountID;
        private int skinIndex;
        private int championID;
        private int summonerID;
        private String internalName;
        private int profileIconID;
        private List<ItemsBean> items;
        private List<Integer> runeIDs;
        private List<MasteriesBean> masteries;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTeamID() {
            return teamID;
        }

        public void setTeamID(int teamID) {
            this.teamID = teamID;
        }

        public int getLocalID() {
            return localID;
        }

        public void setLocalID(int localID) {
            this.localID = localID;
        }

        public int getSpell1ID() {
            return spell1ID;
        }

        public void setSpell1ID(int spell1ID) {
            this.spell1ID = spell1ID;
        }

        public int getSpell2ID() {
            return spell2ID;
        }

        public void setSpell2ID(int spell2ID) {
            this.spell2ID = spell2ID;
        }

        public int getAccountID() {
            return accountID;
        }

        public void setAccountID(int accountID) {
            this.accountID = accountID;
        }

        public int getSkinIndex() {
            return skinIndex;
        }

        public void setSkinIndex(int skinIndex) {
            this.skinIndex = skinIndex;
        }

        public int getChampionID() {
            return championID;
        }

        public void setChampionID(int championID) {
            this.championID = championID;
        }

        public int getSummonerID() {
            return summonerID;
        }

        public void setSummonerID(int summonerID) {
            this.summonerID = summonerID;
        }

        public String getInternalName() {
            return internalName;
        }

        public void setInternalName(String internalName) {
            this.internalName = internalName;
        }

        public int getProfileIconID() {
            return profileIconID;
        }

        public void setProfileIconID(int profileIconID) {
            this.profileIconID = profileIconID;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public List<Integer> getRuneIDs() {
            return runeIDs;
        }

        public void setRuneIDs(List<Integer> runeIDs) {
            this.runeIDs = runeIDs;
        }

        public List<MasteriesBean> getMasteries() {
            return masteries;
        }

        public void setMasteries(List<MasteriesBean> masteries) {
            this.masteries = masteries;
        }

        public static class ItemsBean {
        	
        	private int slot;
            private int itemID;
            private int quantity;

            public int getSlot() {
                return slot;
            }

            public void setSlot(int slot) {
                this.slot = slot;
            }

            public int getItemID() {
                return itemID;
            }

            public void setItemID(int itemID) {
                this.itemID = itemID;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class MasteriesBean {
        	
            private int ID;
            private int points;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }
        }
    }
}
