/**
 * Represents a single native save slot data structure for Spyro: Year of the Dragon.
 * <p>
 * Maps directly to the low-level byte layout used by the PlayStation memory card format.
 * Includes nested classes for progress tracking flags, gem toll structures, and Moneybags state.
 * </p>
 */
public class SaveSlot {
    /**
     * Offset 0x00: Save identifier counter. Increments every save write.
     */
    public int saveId;
    /**
     * Offset 0x04: File ID identifier preserved per save slot.
     */
    public byte fileId;
    /**
     * Offset 0x05: Current active level ID.
     */
    public byte currentLevel;

    // --- Save Data Structure Fields ---
    /**
     * Offset 0x06: Remaining life count.
     */
    public byte lives;
    /**
     * Offset 0x07: Reserved byte padding.
     */
    public byte pad1;
    /**
     * Offset 0x08: Visited levels collection bitmask array (40 levels).
     */
    public byte[] visitedLevels = new byte[40];
    /**
     * Offset 0x30: Gem/item bitmasks array per level (40 levels x 32 bytes).
     */
    public byte[][] collections = new byte[40][32];
    /**
     * Offset 0x530: Gem totals collected per level.
     */
    public short[] gemTotals = new short[40];
    /**
     * Offset 0x580: Dragon egg collection bitmasks per level.
     */
    public byte[] eggs = new byte[40];
    /**
     * Offset 0x5A8: Moneybags gem toll status data structure (Size: 0x30).
     */
    public MoneybagsData moneybagsData = new MoneybagsData();
    /**
     * Offset 0x5D8: Story and objective completion progress flags.
     */
    public ProgressFlags progressFlags = new ProgressFlags();
    /**
     * Offset 0x624: Dialogue bitmask array for character interactions.
     */
    public byte[] dialogueBitmaskArray = new byte[40];
    /**
     * Offset 0x64C: Internal unknown runtime state value.
     */
    public int unk_8006c5d0;
    /**
     * Offset 0x650: Player death count accumulator.
     */
    public int deathCount;
    /**
     * Offset 0x654: Internal unknown runtime state value.
     */
    public int unk_8006c710;
    /**
     * Offset 0x658: Adaptive Difficulty Tuning (ACT) integer value.
     */
    public int difficulty;
    /**
     * Offset 0x65C: ACT high-difficulty thresholds per egg.
     */
    public byte[][] actMetThresholds = new byte[40][6];
    /**
     * Offset 0x74C: ACT performance metrics.
     */
    public byte[][] actPerformance = new byte[40][6];
    /**
     * Offset 0x83C: Speedway trial completion flags.
     */
    public byte[] speedwayTrialsComplete = new byte[4];
    /**
     * Offset 0x840: Speedway trial record times.
     */
    public int[] speedwayTrialRecords = new int[4];
    /**
     * Offset 0x850: Speedway race completion flags.
     */
    public byte[] speedwayRacesComplete = new byte[4];
    /**
     * Offset 0x854: Speedway race record times.
     */
    public int[] speedwayRaceRecords = new int[4];
    /**
     * Offset 0x864: Skateboarding high score records.
     */
    public int[] skateRecords = new int[4];
    /**
     * Offset 0x874: Skill point achievement flags (20 points total).
     */
    public byte[] skillPoints = new byte[20];
    /**
     * Offset 0x888: Reserved padding byte.
     */
    public byte pad2;
    /**
     * Offset 0x889: Active camera mode (1 = active).
     */
    public byte activeCam;
    /**
     * Offset 0x88A: Controller vibration setting toggle (1 = enabled).
     */
    public byte vibrationOn;
    /**
     * Offset 0x88B: Character voices audio setting (1 = enabled).
     */
    public byte voicesOn;
    /**
     * Offset 0x88C: Sound FX volume level setting.
     */
    public byte soundVolume;
    /**
     * Offset 0x88D: Music volume level setting.
     */
    public byte musicVolume;
    /**
     * Offset 0x88E: Speaker output mode (1 = Stereo, 0 = Mono).
     */
    public byte stereoSpeaker;
    /**
     * Offset 0x88F: Extended structure padding (109 bytes).
     */
    public byte[] pad3 = new byte[109];
    /**
     * Offset 0x8FC: Checksum sum value stored at the end of the save slot byte layout.
     */
    public int checksum;

    /**
     * Parses a raw save file byte array and populates the fields of this instance.
     *
     * @param data Raw byte array representing a single save slot block.
     */
    public void parseByteArray(byte[] data) {
        this.saveId = SaveTools.bytesToInt(data, 0, false);
        // TODO: Finish parsing remaining binary fields into their respective properties
    }

    public void setChecksum() {
        // TODO: Add a method to calculate and assign the internal checksum variable
    }

    /**
     * Bit-flag container representing overall story progression, level unlocking states,
     * character state flags, and milestone flags.
     */
    public static class ProgressFlags {
        public byte lvl10_HunterStart;
        public byte lvl10_Bianca;
        public byte lvl10_TikiEnteredPortal;
        public byte addMoneybagsGemsToTotal; // Unused under normal means
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
        public byte lvl46_Agent9ExtraDialogue; // Unused under normal means
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

    //TODO: create a default constructor
    //TODO: create a constructor which accepts a byte array as an argument to run the
    // parseByteArray() and fill in the fields.

    /**
     * Struct tracking gem costs and payment status for Moneybags interactions.
     */
    public static class GemToll {
        /**
         * Total gem toll amount required.
         */
        public short value;
        /**
         * Amount of gems paid so far.
         */
        public short paid;
    }

    /**
     * Collection of all Moneybags toll checkpoints across the game world.
     */
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
    // TODO: Add a method to serialize all instance fields back into a raw byte array
}