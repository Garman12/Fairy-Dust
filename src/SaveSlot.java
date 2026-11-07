public class SaveSlot {

    public static class ProgressFlags {
        public byte lvl10_HunterStart;
        public byte lvl10_Bianca;
        public byte lvl10_TikiEnteredPortal;
        public byte addMoneybagsGemsToTotal; // unused under normal means
        public byte lvl31_Bentley;
        public byte lvl11_Sheila;
        public byte lvl13_SgtByrd;
        public byte lvl24_Bentley;
        public byte lvl23_Sheila;
        public byte lvl14_Sheila;
        public byte lvl10_HunterLake;
        public byte lvl10_SealEnteredPortal;
        public byte lvl33_Agent9;
        public byte lvl16_Sheila;
        public byte lvl80_TheDancingBear;
        public byte lvl20_Bianca;
        public byte lvl34_SgtByrd;
        public byte lvl78_ByrdJamesByrd;
        public byte lvl79_ADuplicitousLarcenousUrsine;
        public byte lvl10_HunterFirstLedge;
        public byte lvl00_MoneybagsSpokenTo;
        public byte lvl20_EnchantedTowersOpen;
        public byte lvl10_BalloonUsable;
        public byte lvl20_WhirligigUsable;
        public byte lvl30_RocketUsable;
        public byte unk25;
        public byte lvl77_NoHardFeelings;
        public byte lvl43_Agent9;
        public byte lvl17_BuzzDefeated;
        public byte lvl27_SpikeDefeated;
        public byte lvl37_ScorchDefeated;
        public byte lvl47_SorceressDefeated;
        public byte lvl41_Bentley;
        public byte lvl44_Agent9;
        public byte lvl42_Sheila;
        public byte lvl30_Bianca;
        public byte lvl40_Bianca;
        public byte lvl10_CrawdadFarmComplete;
        public byte lvl20_SpiderTownComplete;
        public byte lvl30_StarfishReefComplete;
        public byte lvl40_BugbotFactoryComplete;
        public byte lvl18_CrawdadFarmTutorialComplete;
        public byte lvl00_HunterTrapped;
        public byte lvl40_BiancaSorceressDoor;
        public byte lvl40_SuperBonusRoundPortalOpen;
        public byte lvl50_Bianca;
        public byte lvl50_SkateboardingComplete;
        public byte[] lvl50_Submarines = new byte[7];
        public byte[] lvl50_UFOs = new byte[7];
        public byte[] lvl50_Thieves = new byte[5];
        public byte lvl46_Agent9ExtraDialogue; // unused under normal means
        public byte lvl10_ZoeAP;
        public byte lvl63_BiancaStrikesBack;
        public byte lvl65_SpikeIsBorn;
        public byte lvl67_AMonsterToEndAllMonsters;
        public byte lvl62_TheSecondWarning;
        public byte lvl64_HuntersTussle;
        public byte lvl66_AnApologyAndLunch;
        public byte lvl68_TheEscape;
        public byte lvl74_TheEnd;
    }

    public static class GemToll {
        public short value;
        public short paid;
    }

    public static class MoneybagsData {
        public GemToll level_12 = new GemToll();
        public GemToll level_23 = new GemToll();
        public GemToll level_10 = new GemToll();
        public GemToll level_21 = new GemToll();
        public GemToll level_13 = new GemToll();
        public GemToll level_34 = new GemToll();
        public GemToll level_20 = new GemToll();
        public GemToll level_30 = new GemToll();
        public GemToll level_42 = new GemToll();
        public GemToll level_40 = new GemToll();
        public GemToll level_31 = new GemToll();
        public GemToll level_41 = new GemToll();
    }

    // SaveData Fields
    public int saveId;                        // 0, for checking if the memory card has changed? Changed every save
    public byte fileId;              // 4, for checking if the memory card has changed? Preserved per save file
    public byte currentLevel;        // 5
    public byte lives;               // 6
    public byte pad1;                         // 7, seems to be unused
    public byte[] visitedLevels = new byte[40];   // 8
    public byte[][] collections = new byte[40][32]; // 30, bitmasks e.g. for gems etc., 8 ints per level
    public short[] gemTotals = new short[40];      // 530
    public byte[] eggs = new byte[40];            // 580, bitmasks for eggs
    public MoneybagsData moneybagsData = new MoneybagsData();       // 5A8 // size 0x30
    public ProgressFlags progressFlags = new ProgressFlags();       // 5D8
    public byte[] dialogueBitmaskArray = new byte[40];     // 624, is this even used?
    public int unk_8006c5d0;                  // 64C
    public int deathCount;                    // 650, not sure if this is ever actually used
    public int unk_8006c710;                  // 654
    public int difficulty;                    // 658, the value, rather than the easy/medium/hard
    public byte[][] actMetThresholds = new byte[40][6];   // 65C, high difficulty thresholds per egg
    public byte[][] actPerformance = new byte[40][6];     // 74C, for the ACT
    public byte[] speedwayTrialsComplete = new byte[4]; // 83C
    public int[] speedwayTrialRecords = new int[4];             // 840
    public byte[] speedwayRacesComplete = new byte[4];  // 850
    public int[] speedwayRaceRecords = new int[4];        // 854
    public int[] skateRecords = new int[4];               // 864
    public byte[] skillPoints = new byte[20];     // 874
    public byte pad2;                         // 888, ?? unused??
    public byte activeCam;           // 889, active if 1
    public byte vibrationOn;         // 88A, on if 1
    public byte voicesOn;            // 88B, on if 1
    public byte soundVolume;         // 88C
    public byte musicVolume;         // 88D
    public byte stereoSpeaker;       // 88E, stereo if 1
    public byte[] pad3 = new byte[109];                    // 88F, ???
    public int checksum;                      // 8FC

    public void parseByteArray(byte[] data){
        byte[] saveIdBytes = new byte[4];
        this.saveId = SaveTools.bytesToInt(data, 0, false);
        //TODO: finish this parsing function
    }
    //TODO: add a function which returns all the fields in the save slot as a byte array
    //TODO: add a function which checksums the fields in the save slot and writes it to the save slot's checksum variable.
}