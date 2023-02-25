//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.drinkless.tdlib;

public class TdApi {
    public TdApi() {
    }

    public static class WriteGeneratedFilePart extends Function {
        public long generationId;
        public int offset;
        public byte[] data;
        public static final int CONSTRUCTOR = -2062358189;

        public WriteGeneratedFilePart() {
        }

        public WriteGeneratedFilePart(long var1, int var3, byte[] var4) {
            this.generationId = var1;
            this.offset = var3;
            this.data = var4;
        }

        @Override
        public int getConstructor() {
            return -2062358189;
        }
    }

    public static class ViewTrendingStickerSets extends Function {
        public long[] stickerSetIds;
        public static final int CONSTRUCTOR = -952416520;

        public ViewTrendingStickerSets() {
        }

        public ViewTrendingStickerSets(long[] var1) {
            this.stickerSetIds = var1;
        }

        @Override
        public int getConstructor() {
            return -952416520;
        }
    }

    public static class ViewSponsoredMessage extends Function {
        public long chatId;
        public int sponsoredMessageId;
        public static final int CONSTRUCTOR = 1178245499;

        public ViewSponsoredMessage() {
        }

        public ViewSponsoredMessage(long var1, int var3) {
            this.chatId = var1;
            this.sponsoredMessageId = var3;
        }

        @Override
        public int getConstructor() {
            return 1178245499;
        }
    }

    public static class ViewMessages extends Function {
        public long chatId;
        public long messageThreadId;
        public long[] messageIds;
        public boolean forceRead;
        public static final int CONSTRUCTOR = -1155961496;

        public ViewMessages() {
        }

        public ViewMessages(long var1, long var3, long[] var5, boolean var6) {
            this.chatId = var1;
            this.messageThreadId = var3;
            this.messageIds = var5;
            this.forceRead = var6;
        }

        @Override
        public int getConstructor() {
            return -1155961496;
        }
    }

    public static class ValidateOrderInfo extends Function {
        public long chatId;
        public long messageId;
        public OrderInfo orderInfo;
        public boolean allowSave;
        public static final int CONSTRUCTOR = 9480644;

        public ValidateOrderInfo() {
        }

        public ValidateOrderInfo(long var1, long var3, OrderInfo var5, boolean var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.orderInfo = var5;
            this.allowSave = var6;
        }

        @Override
        public int getConstructor() {
            return 9480644;
        }
    }

    public static class UploadStickerFile extends Function {
        public int userId;
        public InputSticker sticker;
        public static final int CONSTRUCTOR = -907712870;

        public UploadStickerFile() {
        }

        public UploadStickerFile(int var1, InputSticker var2) {
            this.userId = var1;
            this.sticker = var2;
        }

        @Override
        public int getConstructor() {
            return -907712870;
        }
    }

    public static class UploadFile extends Function {
        public InputFile file;
        public FileType fileType;
        public int priority;
        public static final int CONSTRUCTOR = -745597786;

        public UploadFile() {
        }

        public UploadFile(InputFile var1, FileType var2, int var3) {
            this.file = var1;
            this.fileType = var2;
            this.priority = var3;
        }

        @Override
        public int getConstructor() {
            return -745597786;
        }
    }

    public static class UpgradeBasicGroupChatToSupergroupChat extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 300488122;

        public UpgradeBasicGroupChatToSupergroupChat() {
        }

        public UpgradeBasicGroupChatToSupergroupChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 300488122;
        }
    }

    public static class UnpinChatMessage extends Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = 2065448670;

        public UnpinChatMessage() {
        }

        public UnpinChatMessage(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        @Override
        public int getConstructor() {
            return 2065448670;
        }
    }

    public static class UnpinAllChatMessages extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = -1437805385;

        public UnpinAllChatMessages() {
        }

        public UnpinAllChatMessages(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return -1437805385;
        }
    }

    public static class TransferChatOwnership extends Function {
        public long chatId;
        public int userId;
        public String password;
        public static final int CONSTRUCTOR = -1925047127;

        public TransferChatOwnership() {
        }

        public TransferChatOwnership(long var1, int var3, String var4) {
            this.chatId = var1;
            this.userId = var3;
            this.password = var4;
        }

        @Override
        public int getConstructor() {
            return -1925047127;
        }
    }

    public static class ToggleSupergroupSignMessages extends Function {
        public int supergroupId;
        public boolean signMessages;
        public static final int CONSTRUCTOR = -558196581;

        public ToggleSupergroupSignMessages() {
        }

        public ToggleSupergroupSignMessages(int var1, boolean var2) {
            this.supergroupId = var1;
            this.signMessages = var2;
        }

        @Override
        public int getConstructor() {
            return -558196581;
        }
    }

    public static class ToggleSupergroupIsBroadcastGroup extends Function {
        public int supergroupId;
        public static final int CONSTRUCTOR = -1673608054;

        public ToggleSupergroupIsBroadcastGroup() {
        }

        public ToggleSupergroupIsBroadcastGroup(int var1) {
            this.supergroupId = var1;
        }

        @Override
        public int getConstructor() {
            return -1673608054;
        }
    }

    public static class ToggleSupergroupIsAllHistoryAvailable extends Function {
        public int supergroupId;
        public boolean isAllHistoryAvailable;
        public static final int CONSTRUCTOR = 1701526555;

        public ToggleSupergroupIsAllHistoryAvailable() {
        }

        public ToggleSupergroupIsAllHistoryAvailable(int var1, boolean var2) {
            this.supergroupId = var1;
            this.isAllHistoryAvailable = var2;
        }

        @Override
        public int getConstructor() {
            return 1701526555;
        }
    }

    public static class ToggleMessageSenderIsBlocked extends Function {
        public MessageSender sender;
        public boolean isBlocked;
        public static final int CONSTRUCTOR = -760132705;

        public ToggleMessageSenderIsBlocked() {
        }

        public ToggleMessageSenderIsBlocked(MessageSender var1, boolean var2) {
            this.sender = var1;
            this.isBlocked = var2;
        }

        @Override
        public int getConstructor() {
            return -760132705;
        }
    }

    public static class ToggleGroupCallScreenSharingIsPaused extends Function {
        public int groupCallId;
        public boolean isPaused;
        public static final int CONSTRUCTOR = -1602530464;

        public ToggleGroupCallScreenSharingIsPaused() {
        }

        public ToggleGroupCallScreenSharingIsPaused(int var1, boolean var2) {
            this.groupCallId = var1;
            this.isPaused = var2;
        }

        @Override
        public int getConstructor() {
            return -1602530464;
        }
    }

    public static class ToggleGroupCallParticipantIsMuted extends Function {
        public int groupCallId;
        public MessageSender participantId;
        public boolean isMuted;
        public static final int CONSTRUCTOR = -1308093433;

        public ToggleGroupCallParticipantIsMuted() {
        }

        public ToggleGroupCallParticipantIsMuted(int var1, MessageSender var2, boolean var3) {
            this.groupCallId = var1;
            this.participantId = var2;
            this.isMuted = var3;
        }

        @Override
        public int getConstructor() {
            return -1308093433;
        }
    }

    public static class ToggleGroupCallParticipantIsHandRaised extends Function {
        public int groupCallId;
        public MessageSender participantId;
        public boolean isHandRaised;
        public static final int CONSTRUCTOR = -1896127519;

        public ToggleGroupCallParticipantIsHandRaised() {
        }

        public ToggleGroupCallParticipantIsHandRaised(int var1, MessageSender var2, boolean var3) {
            this.groupCallId = var1;
            this.participantId = var2;
            this.isHandRaised = var3;
        }

        @Override
        public int getConstructor() {
            return -1896127519;
        }
    }

    public static class ToggleGroupCallMuteNewParticipants extends Function {
        public int groupCallId;
        public boolean muteNewParticipants;
        public static final int CONSTRUCTOR = 284082626;

        public ToggleGroupCallMuteNewParticipants() {
        }

        public ToggleGroupCallMuteNewParticipants(int var1, boolean var2) {
            this.groupCallId = var1;
            this.muteNewParticipants = var2;
        }

        @Override
        public int getConstructor() {
            return 284082626;
        }
    }

    public static class ToggleGroupCallIsMyVideoPaused extends Function {
        public int groupCallId;
        public boolean isMyVideoPaused;
        public static final int CONSTRUCTOR = -478875239;

        public ToggleGroupCallIsMyVideoPaused() {
        }

        public ToggleGroupCallIsMyVideoPaused(int var1, boolean var2) {
            this.groupCallId = var1;
            this.isMyVideoPaused = var2;
        }

        @Override
        public int getConstructor() {
            return -478875239;
        }
    }

    public static class ToggleGroupCallIsMyVideoEnabled extends Function {
        public int groupCallId;
        public boolean isMyVideoEnabled;
        public static final int CONSTRUCTOR = -1624289030;

        public ToggleGroupCallIsMyVideoEnabled() {
        }

        public ToggleGroupCallIsMyVideoEnabled(int var1, boolean var2) {
            this.groupCallId = var1;
            this.isMyVideoEnabled = var2;
        }

        @Override
        public int getConstructor() {
            return -1624289030;
        }
    }

    public static class ToggleGroupCallEnabledStartNotification extends Function {
        public int groupCallId;
        public boolean enabledStartNotification;
        public static final int CONSTRUCTOR = 707839826;

        public ToggleGroupCallEnabledStartNotification() {
        }

        public ToggleGroupCallEnabledStartNotification(int var1, boolean var2) {
            this.groupCallId = var1;
            this.enabledStartNotification = var2;
        }

        @Override
        public int getConstructor() {
            return 707839826;
        }
    }

    public static class ToggleChatIsPinned extends Function {
        public ChatList chatList;
        public long chatId;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -1485429186;

        public ToggleChatIsPinned() {
        }

        public ToggleChatIsPinned(ChatList var1, long var2, boolean var4) {
            this.chatList = var1;
            this.chatId = var2;
            this.isPinned = var4;
        }

        @Override
        public int getConstructor() {
            return -1485429186;
        }
    }

    public static class ToggleChatIsMarkedAsUnread extends Function {
        public long chatId;
        public boolean isMarkedAsUnread;
        public static final int CONSTRUCTOR = -986129697;

        public ToggleChatIsMarkedAsUnread() {
        }

        public ToggleChatIsMarkedAsUnread(long var1, boolean var3) {
            this.chatId = var1;
            this.isMarkedAsUnread = var3;
        }

        @Override
        public int getConstructor() {
            return -986129697;
        }
    }

    public static class ToggleChatDefaultDisableNotification extends Function {
        public long chatId;
        public boolean defaultDisableNotification;
        public static final int CONSTRUCTOR = 314794002;

        public ToggleChatDefaultDisableNotification() {
        }

        public ToggleChatDefaultDisableNotification(long var1, boolean var3) {
            this.chatId = var1;
            this.defaultDisableNotification = var3;
        }

        @Override
        public int getConstructor() {
            return 314794002;
        }
    }

    public static class TestUseUpdate extends Function {
        public static final int CONSTRUCTOR = 717094686;

        public TestUseUpdate() {
        }

        @Override
        public int getConstructor() {
            return 717094686;
        }
    }

    public static class TestSquareInt extends Function {
        public int x;
        public static final int CONSTRUCTOR = -60135024;

        public TestSquareInt() {
        }

        public TestSquareInt(int var1) {
            this.x = var1;
        }

        @Override
        public int getConstructor() {
            return -60135024;
        }
    }

    public static class TestReturnError extends Function {
        public Error error;
        public static final int CONSTRUCTOR = 455179506;

        public TestReturnError() {
        }

        public TestReturnError(Error var1) {
            this.error = var1;
        }

        @Override
        public int getConstructor() {
            return 455179506;
        }
    }

    public static class TestProxy extends Function {
        public String server;
        public int port;
        public ProxyType type;
        public int dcId;
        public double timeout;
        public static final int CONSTRUCTOR = -1197366626;

        public TestProxy() {
        }

        public TestProxy(String var1, int var2, ProxyType var3, int var4, double var5) {
            this.server = var1;
            this.port = var2;
            this.type = var3;
            this.dcId = var4;
            this.timeout = var5;
        }

        @Override
        public int getConstructor() {
            return -1197366626;
        }
    }

    public static class TestNetwork extends Function {
        public static final int CONSTRUCTOR = -1343998901;

        public TestNetwork() {
        }

        @Override
        public int getConstructor() {
            return -1343998901;
        }
    }

    public static class TestGetDifference extends Function {
        public static final int CONSTRUCTOR = 1747084069;

        public TestGetDifference() {
        }

        @Override
        public int getConstructor() {
            return 1747084069;
        }
    }

    public static class TestCallVectorStringObject extends Function {
        public TestString[] x;
        public static final int CONSTRUCTOR = 1527666429;

        public TestCallVectorStringObject() {
        }

        public TestCallVectorStringObject(TestString[] var1) {
            this.x = var1;
        }

        @Override
        public int getConstructor() {
            return 1527666429;
        }
    }

    public static class TestCallVectorString extends Function {
        public String[] x;
        public static final int CONSTRUCTOR = -408600900;

        public TestCallVectorString() {
        }

        public TestCallVectorString(String[] var1) {
            this.x = var1;
        }

        @Override
        public int getConstructor() {
            return -408600900;
        }
    }

    public static class TestCallVectorIntObject extends Function {
        public TestInt[] x;
        public static final int CONSTRUCTOR = 1825428218;

        public TestCallVectorIntObject() {
        }

        public TestCallVectorIntObject(TestInt[] var1) {
            this.x = var1;
        }

        @Override
        public int getConstructor() {
            return 1825428218;
        }
    }

    public static class TestCallVectorInt extends Function {
        public int[] x;
        public static final int CONSTRUCTOR = -2137277793;

        public TestCallVectorInt() {
        }

        public TestCallVectorInt(int[] var1) {
            this.x = var1;
        }

        @Override
        public int getConstructor() {
            return -2137277793;
        }
    }

    public static class TestCallString extends Function {
        public String x;
        public static final int CONSTRUCTOR = -1732818385;

        public TestCallString() {
        }

        public TestCallString(String var1) {
            this.x = var1;
        }

        @Override
        public int getConstructor() {
            return -1732818385;
        }
    }

    public static class TestCallEmpty extends Function {
        public static final int CONSTRUCTOR = -627291626;

        public TestCallEmpty() {
        }

        @Override
        public int getConstructor() {
            return -627291626;
        }
    }

    public static class TestCallBytes extends Function {
        public byte[] x;
        public static final int CONSTRUCTOR = -736011607;

        public TestCallBytes() {
        }

        public TestCallBytes(byte[] var1) {
            this.x = var1;
        }

        @Override
        public int getConstructor() {
            return -736011607;
        }
    }

    public static class TerminateSession extends Function {
        public long sessionId;
        public static final int CONSTRUCTOR = -407385812;

        public TerminateSession() {
        }

        public TerminateSession(long var1) {
            this.sessionId = var1;
        }

        @Override
        public int getConstructor() {
            return -407385812;
        }
    }

    public static class TerminateAllOtherSessions extends Function {
        public static final int CONSTRUCTOR = 1874485523;

        public TerminateAllOtherSessions() {
        }

        @Override
        public int getConstructor() {
            return 1874485523;
        }
    }

    public static class SynchronizeLanguagePack extends Function {
        public String languagePackId;
        public static final int CONSTRUCTOR = -2065307858;

        public SynchronizeLanguagePack() {
        }

        public SynchronizeLanguagePack(String var1) {
            this.languagePackId = var1;
        }

        @Override
        public int getConstructor() {
            return -2065307858;
        }
    }

    public static class StopPoll extends Function {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = 1659374253;

        public StopPoll() {
        }

        public StopPoll(long var1, long var3, ReplyMarkup var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
        }

        @Override
        public int getConstructor() {
            return 1659374253;
        }
    }

    public static class StartScheduledGroupCall extends Function {
        public int groupCallId;
        public static final int CONSTRUCTOR = 1519938838;

        public StartScheduledGroupCall() {
        }

        public StartScheduledGroupCall(int var1) {
            this.groupCallId = var1;
        }

        @Override
        public int getConstructor() {
            return 1519938838;
        }
    }

    public static class StartGroupCallScreenSharing extends Function {
        public int groupCallId;
        public int audioSourceId;
        public String payload;
        public static final int CONSTRUCTOR = -884068051;

        public StartGroupCallScreenSharing() {
        }

        public StartGroupCallScreenSharing(int var1, int var2, String var3) {
            this.groupCallId = var1;
            this.audioSourceId = var2;
            this.payload = var3;
        }

        @Override
        public int getConstructor() {
            return -884068051;
        }
    }

    public static class StartGroupCallRecording extends Function {
        public int groupCallId;
        public String title;
        public boolean recordVideo;
        public boolean usePortraitOrientation;
        public static final int CONSTRUCTOR = 1757774971;

        public StartGroupCallRecording() {
        }

        public StartGroupCallRecording(int var1, String var2, boolean var3, boolean var4) {
            this.groupCallId = var1;
            this.title = var2;
            this.recordVideo = var3;
            this.usePortraitOrientation = var4;
        }

        @Override
        public int getConstructor() {
            return 1757774971;
        }
    }

    public static class SharePhoneNumber extends Function {
        public int userId;
        public static final int CONSTRUCTOR = -370669878;

        public SharePhoneNumber() {
        }

        public SharePhoneNumber(int var1) {
            this.userId = var1;
        }

        @Override
        public int getConstructor() {
            return -370669878;
        }
    }

    public static class SetVoiceChatDefaultParticipant extends Function {
        public long chatId;
        public MessageSender defaultParticipantId;
        public static final int CONSTRUCTOR = 525463197;

        public SetVoiceChatDefaultParticipant() {
        }

        public SetVoiceChatDefaultParticipant(long var1, MessageSender var3) {
            this.chatId = var1;
            this.defaultParticipantId = var3;
        }

        @Override
        public int getConstructor() {
            return 525463197;
        }
    }

    public static class SetUsername extends Function {
        public String username;
        public static final int CONSTRUCTOR = 439901214;

        public SetUsername() {
        }

        public SetUsername(String var1) {
            this.username = var1;
        }

        @Override
        public int getConstructor() {
            return 439901214;
        }
    }

    public static class SetUserPrivacySettingRules extends Function {
        public UserPrivacySetting setting;
        public UserPrivacySettingRules rules;
        public static final int CONSTRUCTOR = -473812741;

        public SetUserPrivacySettingRules() {
        }

        public SetUserPrivacySettingRules(UserPrivacySetting var1, UserPrivacySettingRules var2) {
            this.setting = var1;
            this.rules = var2;
        }

        @Override
        public int getConstructor() {
            return -473812741;
        }
    }

    public static class SetTdlibParameters extends Function {
        public TdlibParameters parameters;
        public static final int CONSTRUCTOR = -1912557997;

        public SetTdlibParameters() {
        }

        public SetTdlibParameters(TdlibParameters var1) {
            this.parameters = var1;
        }

        @Override
        public int getConstructor() {
            return -1912557997;
        }
    }

    public static class SetSupergroupUsername extends Function {
        public int supergroupId;
        public String username;
        public static final int CONSTRUCTOR = -1428333122;

        public SetSupergroupUsername() {
        }

        public SetSupergroupUsername(int var1, String var2) {
            this.supergroupId = var1;
            this.username = var2;
        }

        @Override
        public int getConstructor() {
            return -1428333122;
        }
    }

    public static class SetSupergroupStickerSet extends Function {
        public int supergroupId;
        public long stickerSetId;
        public static final int CONSTRUCTOR = -295782298;

        public SetSupergroupStickerSet() {
        }

        public SetSupergroupStickerSet(int var1, long var2) {
            this.supergroupId = var1;
            this.stickerSetId = var2;
        }

        @Override
        public int getConstructor() {
            return -295782298;
        }
    }

    public static class SetStickerSetThumbnail extends Function {
        public int userId;
        public String name;
        public InputFile thumbnail;
        public static final int CONSTRUCTOR = -1694737404;

        public SetStickerSetThumbnail() {
        }

        public SetStickerSetThumbnail(int var1, String var2, InputFile var3) {
            this.userId = var1;
            this.name = var2;
            this.thumbnail = var3;
        }

        @Override
        public int getConstructor() {
            return -1694737404;
        }
    }

    public static class SetStickerPositionInSet extends Function {
        public InputFile sticker;
        public int position;
        public static final int CONSTRUCTOR = 2075281185;

        public SetStickerPositionInSet() {
        }

        public SetStickerPositionInSet(InputFile var1, int var2) {
            this.sticker = var1;
            this.position = var2;
        }

        @Override
        public int getConstructor() {
            return 2075281185;
        }
    }

    public static class SetScopeNotificationSettings extends Function {
        public NotificationSettingsScope scope;
        public ScopeNotificationSettings notificationSettings;
        public static final int CONSTRUCTOR = -2049984966;

        public SetScopeNotificationSettings() {
        }

        public SetScopeNotificationSettings(NotificationSettingsScope var1, ScopeNotificationSettings var2) {
            this.scope = var1;
            this.notificationSettings = var2;
        }

        @Override
        public int getConstructor() {
            return -2049984966;
        }
    }

    public static class SetRecoveryEmailAddress extends Function {
        public String password;
        public String newRecoveryEmailAddress;
        public static final int CONSTRUCTOR = -1981836385;

        public SetRecoveryEmailAddress() {
        }

        public SetRecoveryEmailAddress(String var1, String var2) {
            this.password = var1;
            this.newRecoveryEmailAddress = var2;
        }

        @Override
        public int getConstructor() {
            return -1981836385;
        }
    }

    public static class SetProfilePhoto extends Function {
        public InputChatPhoto photo;
        public static final int CONSTRUCTOR = -2069678882;

        public SetProfilePhoto() {
        }

        public SetProfilePhoto(InputChatPhoto var1) {
            this.photo = var1;
        }

        @Override
        public int getConstructor() {
            return -2069678882;
        }
    }

    public static class SetPollAnswer extends Function {
        public long chatId;
        public long messageId;
        public int[] optionIds;
        public static final int CONSTRUCTOR = -1399388792;

        public SetPollAnswer() {
        }

        public SetPollAnswer(long var1, long var3, int[] var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.optionIds = var5;
        }

        @Override
        public int getConstructor() {
            return -1399388792;
        }
    }

    public static class SetPinnedChats extends Function {
        public ChatList chatList;
        public long[] chatIds;
        public static final int CONSTRUCTOR = -695640000;

        public SetPinnedChats() {
        }

        public SetPinnedChats(ChatList var1, long[] var2) {
            this.chatList = var1;
            this.chatIds = var2;
        }

        @Override
        public int getConstructor() {
            return -695640000;
        }
    }

    public static class SetPassword extends Function {
        public String oldPassword;
        public String newPassword;
        public String newHint;
        public boolean setRecoveryEmailAddress;
        public String newRecoveryEmailAddress;
        public static final int CONSTRUCTOR = -1193589027;

        public SetPassword() {
        }

        public SetPassword(String var1, String var2, String var3, boolean var4, String var5) {
            this.oldPassword = var1;
            this.newPassword = var2;
            this.newHint = var3;
            this.setRecoveryEmailAddress = var4;
            this.newRecoveryEmailAddress = var5;
        }

        @Override
        public int getConstructor() {
            return -1193589027;
        }
    }

    public static class SetPassportElementErrors extends Function {
        public int userId;
        public InputPassportElementError[] errors;
        public static final int CONSTRUCTOR = 1455869875;

        public SetPassportElementErrors() {
        }

        public SetPassportElementErrors(int var1, InputPassportElementError[] var2) {
            this.userId = var1;
            this.errors = var2;
        }

        @Override
        public int getConstructor() {
            return 1455869875;
        }
    }

    public static class SetPassportElement extends Function {
        public InputPassportElement element;
        public String password;
        public static final int CONSTRUCTOR = 2068173212;

        public SetPassportElement() {
        }

        public SetPassportElement(InputPassportElement var1, String var2) {
            this.element = var1;
            this.password = var2;
        }

        @Override
        public int getConstructor() {
            return 2068173212;
        }
    }

    public static class SetOption extends Function {
        public String name;
        public OptionValue value;
        public static final int CONSTRUCTOR = 2114670322;

        public SetOption() {
        }

        public SetOption(String var1, OptionValue var2) {
            this.name = var1;
            this.value = var2;
        }

        @Override
        public int getConstructor() {
            return 2114670322;
        }
    }

    public static class SetNetworkType extends Function {
        public NetworkType type;
        public static final int CONSTRUCTOR = -701635234;

        public SetNetworkType() {
        }

        public SetNetworkType(NetworkType var1) {
            this.type = var1;
        }

        @Override
        public int getConstructor() {
            return -701635234;
        }
    }

    public static class SetName extends Function {
        public String firstName;
        public String lastName;
        public static final int CONSTRUCTOR = 1711693584;

        public SetName() {
        }

        public SetName(String var1, String var2) {
            this.firstName = var1;
            this.lastName = var2;
        }

        @Override
        public int getConstructor() {
            return 1711693584;
        }
    }

    public static class SetLogVerbosityLevel extends Function {
        public int newVerbosityLevel;
        public static final int CONSTRUCTOR = -303429678;

        public SetLogVerbosityLevel() {
        }

        public SetLogVerbosityLevel(int var1) {
            this.newVerbosityLevel = var1;
        }

        @Override
        public int getConstructor() {
            return -303429678;
        }
    }

    public static class SetLogTagVerbosityLevel extends Function {
        public String tag;
        public int newVerbosityLevel;
        public static final int CONSTRUCTOR = -2095589738;

        public SetLogTagVerbosityLevel() {
        }

        public SetLogTagVerbosityLevel(String var1, int var2) {
            this.tag = var1;
            this.newVerbosityLevel = var2;
        }

        @Override
        public int getConstructor() {
            return -2095589738;
        }
    }

    public static class SetLogStream extends Function {
        public LogStream logStream;
        public static final int CONSTRUCTOR = -1364199535;

        public SetLogStream() {
        }

        public SetLogStream(LogStream var1) {
            this.logStream = var1;
        }

        @Override
        public int getConstructor() {
            return -1364199535;
        }
    }

    public static class SetLocation extends Function {
        public Location location;
        public static final int CONSTRUCTOR = 93926257;

        public SetLocation() {
        }

        public SetLocation(Location var1) {
            this.location = var1;
        }

        @Override
        public int getConstructor() {
            return 93926257;
        }
    }

    public static class SetInlineGameScore extends Function {
        public String inlineMessageId;
        public boolean editMessage;
        public int userId;
        public int score;
        public boolean force;
        public static final int CONSTRUCTOR = 758435487;

        public SetInlineGameScore() {
        }

        public SetInlineGameScore(String var1, boolean var2, int var3, int var4, boolean var5) {
            this.inlineMessageId = var1;
            this.editMessage = var2;
            this.userId = var3;
            this.score = var4;
            this.force = var5;
        }

        @Override
        public int getConstructor() {
            return 758435487;
        }
    }

    public static class SetGroupCallTitle extends Function {
        public int groupCallId;
        public String title;
        public static final int CONSTRUCTOR = -1228825139;

        public SetGroupCallTitle() {
        }

        public SetGroupCallTitle(int var1, String var2) {
            this.groupCallId = var1;
            this.title = var2;
        }

        @Override
        public int getConstructor() {
            return -1228825139;
        }
    }

    public static class SetGroupCallParticipantVolumeLevel extends Function {
        public int groupCallId;
        public MessageSender participantId;
        public int volumeLevel;
        public static final int CONSTRUCTOR = -1753769944;

        public SetGroupCallParticipantVolumeLevel() {
        }

        public SetGroupCallParticipantVolumeLevel(int var1, MessageSender var2, int var3) {
            this.groupCallId = var1;
            this.participantId = var2;
            this.volumeLevel = var3;
        }

        @Override
        public int getConstructor() {
            return -1753769944;
        }
    }

    public static class SetGroupCallParticipantIsSpeaking extends Function {
        public int groupCallId;
        public int audioSource;
        public boolean isSpeaking;
        public static final int CONSTRUCTOR = 927506917;

        public SetGroupCallParticipantIsSpeaking() {
        }

        public SetGroupCallParticipantIsSpeaking(int var1, int var2, boolean var3) {
            this.groupCallId = var1;
            this.audioSource = var2;
            this.isSpeaking = var3;
        }

        @Override
        public int getConstructor() {
            return 927506917;
        }
    }

    public static class SetGameScore extends Function {
        public long chatId;
        public long messageId;
        public boolean editMessage;
        public int userId;
        public int score;
        public boolean force;
        public static final int CONSTRUCTOR = -1768307069;

        public SetGameScore() {
        }

        public SetGameScore(long var1, long var3, boolean var5, int var6, int var7, boolean var8) {
            this.chatId = var1;
            this.messageId = var3;
            this.editMessage = var5;
            this.userId = var6;
            this.score = var7;
            this.force = var8;
        }

        @Override
        public int getConstructor() {
            return -1768307069;
        }
    }

    public static class SetFileGenerationProgress extends Function {
        public long generationId;
        public int expectedSize;
        public int localPrefixSize;
        public static final int CONSTRUCTOR = -540459953;

        public SetFileGenerationProgress() {
        }

        public SetFileGenerationProgress(long var1, int var3, int var4) {
            this.generationId = var1;
            this.expectedSize = var3;
            this.localPrefixSize = var4;
        }

        @Override
        public int getConstructor() {
            return -540459953;
        }
    }

    public static class SetDatabaseEncryptionKey extends Function {
        public byte[] newEncryptionKey;
        public static final int CONSTRUCTOR = -1204599371;

        public SetDatabaseEncryptionKey() {
        }

        public SetDatabaseEncryptionKey(byte[] var1) {
            this.newEncryptionKey = var1;
        }

        @Override
        public int getConstructor() {
            return -1204599371;
        }
    }

    public static class SetCustomLanguagePackString extends Function {
        public String languagePackId;
        public LanguagePackString newString;
        public static final int CONSTRUCTOR = 1316365592;

        public SetCustomLanguagePackString() {
        }

        public SetCustomLanguagePackString(String var1, LanguagePackString var2) {
            this.languagePackId = var1;
            this.newString = var2;
        }

        @Override
        public int getConstructor() {
            return 1316365592;
        }
    }

    public static class SetCustomLanguagePack extends Function {
        public LanguagePackInfo info;
        public LanguagePackString[] strings;
        public static final int CONSTRUCTOR = -296742819;

        public SetCustomLanguagePack() {
        }

        public SetCustomLanguagePack(LanguagePackInfo var1, LanguagePackString[] var2) {
            this.info = var1;
            this.strings = var2;
        }

        @Override
        public int getConstructor() {
            return -296742819;
        }
    }

    public static class SetCommands extends Function {
        public BotCommandScope scope;
        public String languageCode;
        public BotCommand[] commands;
        public static final int CONSTRUCTOR = -907165606;

        public SetCommands() {
        }

        public SetCommands(BotCommandScope var1, String var2, BotCommand[] var3) {
            this.scope = var1;
            this.languageCode = var2;
            this.commands = var3;
        }

        @Override
        public int getConstructor() {
            return -907165606;
        }
    }

    public static class SetChatTitle extends Function {
        public long chatId;
        public String title;
        public static final int CONSTRUCTOR = 164282047;

        public SetChatTitle() {
        }

        public SetChatTitle(long var1, String var3) {
            this.chatId = var1;
            this.title = var3;
        }

        @Override
        public int getConstructor() {
            return 164282047;
        }
    }

    public static class SetChatTheme extends Function {
        public long chatId;
        public String themeName;
        public static final int CONSTRUCTOR = -1895234925;

        public SetChatTheme() {
        }

        public SetChatTheme(long var1, String var3) {
            this.chatId = var1;
            this.themeName = var3;
        }

        @Override
        public int getConstructor() {
            return -1895234925;
        }
    }

    public static class SetChatSlowModeDelay extends Function {
        public long chatId;
        public int slowModeDelay;
        public static final int CONSTRUCTOR = -540350914;

        public SetChatSlowModeDelay() {
        }

        public SetChatSlowModeDelay(long var1, int var3) {
            this.chatId = var1;
            this.slowModeDelay = var3;
        }

        @Override
        public int getConstructor() {
            return -540350914;
        }
    }

    public static class SetChatPhoto extends Function {
        public long chatId;
        public InputChatPhoto photo;
        public static final int CONSTRUCTOR = -377778941;

        public SetChatPhoto() {
        }

        public SetChatPhoto(long var1, InputChatPhoto var3) {
            this.chatId = var1;
            this.photo = var3;
        }

        @Override
        public int getConstructor() {
            return -377778941;
        }
    }

    public static class SetChatPermissions extends Function {
        public long chatId;
        public ChatPermissions permissions;
        public static final int CONSTRUCTOR = 2138507006;

        public SetChatPermissions() {
        }

        public SetChatPermissions(long var1, ChatPermissions var3) {
            this.chatId = var1;
            this.permissions = var3;
        }

        @Override
        public int getConstructor() {
            return 2138507006;
        }
    }

    public static class SetChatNotificationSettings extends Function {
        public long chatId;
        public ChatNotificationSettings notificationSettings;
        public static final int CONSTRUCTOR = 777199614;

        public SetChatNotificationSettings() {
        }

        public SetChatNotificationSettings(long var1, ChatNotificationSettings var3) {
            this.chatId = var1;
            this.notificationSettings = var3;
        }

        @Override
        public int getConstructor() {
            return 777199614;
        }
    }

    public static class SetChatMessageTtlSetting extends Function {
        public long chatId;
        public int ttl;
        public static final int CONSTRUCTOR = 316076791;

        public SetChatMessageTtlSetting() {
        }

        public SetChatMessageTtlSetting(long var1, int var3) {
            this.chatId = var1;
            this.ttl = var3;
        }

        @Override
        public int getConstructor() {
            return 316076791;
        }
    }

    public static class SetChatMemberStatus extends Function {
        public long chatId;
        public MessageSender memberId;
        public ChatMemberStatus status;
        public static final int CONSTRUCTOR = 81794847;

        public SetChatMemberStatus() {
        }

        public SetChatMemberStatus(long var1, MessageSender var3, ChatMemberStatus var4) {
            this.chatId = var1;
            this.memberId = var3;
            this.status = var4;
        }

        @Override
        public int getConstructor() {
            return 81794847;
        }
    }

    public static class SetChatLocation extends Function {
        public long chatId;
        public ChatLocation location;
        public static final int CONSTRUCTOR = -767091286;

        public SetChatLocation() {
        }

        public SetChatLocation(long var1, ChatLocation var3) {
            this.chatId = var1;
            this.location = var3;
        }

        @Override
        public int getConstructor() {
            return -767091286;
        }
    }

    public static class SetChatDraftMessage extends Function {
        public long chatId;
        public long messageThreadId;
        public DraftMessage draftMessage;
        public static final int CONSTRUCTOR = 1683889946;

        public SetChatDraftMessage() {
        }

        public SetChatDraftMessage(long var1, long var3, DraftMessage var5) {
            this.chatId = var1;
            this.messageThreadId = var3;
            this.draftMessage = var5;
        }

        @Override
        public int getConstructor() {
            return 1683889946;
        }
    }

    public static class SetChatDiscussionGroup extends Function {
        public long chatId;
        public long discussionChatId;
        public static final int CONSTRUCTOR = -918801736;

        public SetChatDiscussionGroup() {
        }

        public SetChatDiscussionGroup(long var1, long var3) {
            this.chatId = var1;
            this.discussionChatId = var3;
        }

        @Override
        public int getConstructor() {
            return -918801736;
        }
    }

    public static class SetChatDescription extends Function {
        public long chatId;
        public String description;
        public static final int CONSTRUCTOR = 1957213277;

        public SetChatDescription() {
        }

        public SetChatDescription(long var1, String var3) {
            this.chatId = var1;
            this.description = var3;
        }

        @Override
        public int getConstructor() {
            return 1957213277;
        }
    }

    public static class SetChatClientData extends Function {
        public long chatId;
        public String clientData;
        public static final int CONSTRUCTOR = -827119811;

        public SetChatClientData() {
        }

        public SetChatClientData(long var1, String var3) {
            this.chatId = var1;
            this.clientData = var3;
        }

        @Override
        public int getConstructor() {
            return -827119811;
        }
    }

    public static class SetBotUpdatesStatus extends Function {
        public int pendingUpdateCount;
        public String errorMessage;
        public static final int CONSTRUCTOR = -1154926191;

        public SetBotUpdatesStatus() {
        }

        public SetBotUpdatesStatus(int var1, String var2) {
            this.pendingUpdateCount = var1;
            this.errorMessage = var2;
        }

        @Override
        public int getConstructor() {
            return -1154926191;
        }
    }

    public static class SetBio extends Function {
        public String bio;
        public static final int CONSTRUCTOR = -1619582124;

        public SetBio() {
        }

        public SetBio(String var1) {
            this.bio = var1;
        }

        @Override
        public int getConstructor() {
            return -1619582124;
        }
    }

    public static class SetBackground extends Function {
        public InputBackground background;
        public BackgroundType type;
        public boolean forDarkTheme;
        public static final int CONSTRUCTOR = -1035439225;

        public SetBackground() {
        }

        public SetBackground(InputBackground var1, BackgroundType var2, boolean var3) {
            this.background = var1;
            this.type = var2;
            this.forDarkTheme = var3;
        }

        @Override
        public int getConstructor() {
            return -1035439225;
        }
    }

    public static class SetAutoDownloadSettings extends Function {
        public AutoDownloadSettings settings;
        public NetworkType type;
        public static final int CONSTRUCTOR = -353671948;

        public SetAutoDownloadSettings() {
        }

        public SetAutoDownloadSettings(AutoDownloadSettings var1, NetworkType var2) {
            this.settings = var1;
            this.type = var2;
        }

        @Override
        public int getConstructor() {
            return -353671948;
        }
    }

    public static class SetAuthenticationPhoneNumber extends Function {
        public String phoneNumber;
        public PhoneNumberAuthenticationSettings settings;
        public static final int CONSTRUCTOR = 868276259;

        public SetAuthenticationPhoneNumber() {
        }

        public SetAuthenticationPhoneNumber(String var1, PhoneNumberAuthenticationSettings var2) {
            this.phoneNumber = var1;
            this.settings = var2;
        }

        @Override
        public int getConstructor() {
            return 868276259;
        }
    }

    public static class SetAlarm extends Function {
        public double seconds;
        public static final int CONSTRUCTOR = -873497067;

        public SetAlarm() {
        }

        public SetAlarm(double var1) {
            this.seconds = var1;
        }

        @Override
        public int getConstructor() {
            return -873497067;
        }
    }

    public static class SetAccountTtl extends Function {
        public AccountTtl ttl;
        public static final int CONSTRUCTOR = 701389032;

        public SetAccountTtl() {
        }

        public SetAccountTtl(AccountTtl var1) {
            this.ttl = var1;
        }

        @Override
        public int getConstructor() {
            return 701389032;
        }
    }

    public static class SendPhoneNumberVerificationCode extends Function {
        public String phoneNumber;
        public PhoneNumberAuthenticationSettings settings;
        public static final int CONSTRUCTOR = 2081689035;

        public SendPhoneNumberVerificationCode() {
        }

        public SendPhoneNumberVerificationCode(String var1, PhoneNumberAuthenticationSettings var2) {
            this.phoneNumber = var1;
            this.settings = var2;
        }

        @Override
        public int getConstructor() {
            return 2081689035;
        }
    }

    public static class SendPhoneNumberConfirmationCode extends Function {
        public String hash;
        public String phoneNumber;
        public PhoneNumberAuthenticationSettings settings;
        public static final int CONSTRUCTOR = -1901171495;

        public SendPhoneNumberConfirmationCode() {
        }

        public SendPhoneNumberConfirmationCode(String var1, String var2, PhoneNumberAuthenticationSettings var3) {
            this.hash = var1;
            this.phoneNumber = var2;
            this.settings = var3;
        }

        @Override
        public int getConstructor() {
            return -1901171495;
        }
    }

    public static class SendPaymentForm extends Function {
        public long chatId;
        public long messageId;
        public long paymentFormId;
        public String orderInfoId;
        public String shippingOptionId;
        public InputCredentials credentials;
        public long tipAmount;
        public static final int CONSTRUCTOR = 1536242687;

        public SendPaymentForm() {
        }

        public SendPaymentForm(long var1, long var3, long var5, String var7, String var8, InputCredentials var9, long var10) {
            this.chatId = var1;
            this.messageId = var3;
            this.paymentFormId = var5;
            this.orderInfoId = var7;
            this.shippingOptionId = var8;
            this.credentials = var9;
            this.tipAmount = var10;
        }

        @Override
        public int getConstructor() {
            return 1536242687;
        }
    }

    public static class SendPassportAuthorizationForm extends Function {
        public int autorizationFormId;
        public PassportElementType[] types;
        public static final int CONSTRUCTOR = -602402218;

        public SendPassportAuthorizationForm() {
        }

        public SendPassportAuthorizationForm(int var1, PassportElementType[] var2) {
            this.autorizationFormId = var1;
            this.types = var2;
        }

        @Override
        public int getConstructor() {
            return -602402218;
        }
    }

    public static class SendMessageAlbum extends Function {
        public long chatId;
        public long messageThreadId;
        public long replyToMessageId;
        public MessageSendOptions options;
        public InputMessageContent[] inputMessageContents;
        public static final int CONSTRUCTOR = 983360432;

        public SendMessageAlbum() {
        }

        public SendMessageAlbum(long var1, long var3, long var5, MessageSendOptions var7, InputMessageContent[] var8) {
            this.chatId = var1;
            this.messageThreadId = var3;
            this.replyToMessageId = var5;
            this.options = var7;
            this.inputMessageContents = var8;
        }

        @Override
        public int getConstructor() {
            return 983360432;
        }
    }

    public static class SendMessage extends Function {
        public long chatId;
        public long messageThreadId;
        public long replyToMessageId;
        public MessageSendOptions options;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 960453021;

        public SendMessage() {
        }

        public SendMessage(long var1, long var3, long var5, MessageSendOptions var7, ReplyMarkup var8, InputMessageContent var9) {
            this.chatId = var1;
            this.messageThreadId = var3;
            this.replyToMessageId = var5;
            this.options = var7;
            this.replyMarkup = var8;
            this.inputMessageContent = var9;
        }

        @Override
        public int getConstructor() {
            return 960453021;
        }
    }

    public static class SendInlineQueryResultMessage extends Function {
        public long chatId;
        public long messageThreadId;
        public long replyToMessageId;
        public MessageSendOptions options;
        public long queryId;
        public String resultId;
        public boolean hideViaBot;
        public static final int CONSTRUCTOR = -948639588;

        public SendInlineQueryResultMessage() {
        }

        public SendInlineQueryResultMessage(long var1, long var3, long var5, MessageSendOptions var7, long var8, String var10, boolean var11) {
            this.chatId = var1;
            this.messageThreadId = var3;
            this.replyToMessageId = var5;
            this.options = var7;
            this.queryId = var8;
            this.resultId = var10;
            this.hideViaBot = var11;
        }

        @Override
        public int getConstructor() {
            return -948639588;
        }
    }

    public static class SendEmailAddressVerificationCode extends Function {
        public String emailAddress;
        public static final int CONSTRUCTOR = -221621379;

        public SendEmailAddressVerificationCode() {
        }

        public SendEmailAddressVerificationCode(String var1) {
            this.emailAddress = var1;
        }

        @Override
        public int getConstructor() {
            return -221621379;
        }
    }

    public static class SendCustomRequest extends Function {
        public String method;
        public String parameters;
        public static final int CONSTRUCTOR = 285045153;

        public SendCustomRequest() {
        }

        public SendCustomRequest(String var1, String var2) {
            this.method = var1;
            this.parameters = var2;
        }

        @Override
        public int getConstructor() {
            return 285045153;
        }
    }

    public static class SendChatScreenshotTakenNotification extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 448399457;

        public SendChatScreenshotTakenNotification() {
        }

        public SendChatScreenshotTakenNotification(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 448399457;
        }
    }

    public static class SendChatAction extends Function {
        public long chatId;
        public long messageThreadId;
        public ChatAction action;
        public static final int CONSTRUCTOR = 2096947540;

        public SendChatAction() {
        }

        public SendChatAction(long var1, long var3, ChatAction var5) {
            this.chatId = var1;
            this.messageThreadId = var3;
            this.action = var5;
        }

        @Override
        public int getConstructor() {
            return 2096947540;
        }
    }

    public static class SendCallSignalingData extends Function {
        public int callId;
        public byte[] data;
        public static final int CONSTRUCTOR = 1412280732;

        public SendCallSignalingData() {
        }

        public SendCallSignalingData(int var1, byte[] var2) {
            this.callId = var1;
            this.data = var2;
        }

        @Override
        public int getConstructor() {
            return 1412280732;
        }
    }

    public static class SendCallRating extends Function {
        public int callId;
        public int rating;
        public String comment;
        public CallProblem[] problems;
        public static final int CONSTRUCTOR = -1402719502;

        public SendCallRating() {
        }

        public SendCallRating(int var1, int var2, String var3, CallProblem[] var4) {
            this.callId = var1;
            this.rating = var2;
            this.comment = var3;
            this.problems = var4;
        }

        @Override
        public int getConstructor() {
            return -1402719502;
        }
    }

    public static class SendCallDebugInformation extends Function {
        public int callId;
        public String debugInformation;
        public static final int CONSTRUCTOR = 2019243839;

        public SendCallDebugInformation() {
        }

        public SendCallDebugInformation(int var1, String var2) {
            this.callId = var1;
            this.debugInformation = var2;
        }

        @Override
        public int getConstructor() {
            return 2019243839;
        }
    }

    public static class SendBotStartMessage extends Function {
        public int botUserId;
        public long chatId;
        public String parameter;
        public static final int CONSTRUCTOR = 1112181339;

        public SendBotStartMessage() {
        }

        public SendBotStartMessage(int var1, long var2, String var4) {
            this.botUserId = var1;
            this.chatId = var2;
            this.parameter = var4;
        }

        @Override
        public int getConstructor() {
            return 1112181339;
        }
    }

    public static class SearchStickers extends Function {
        public String emoji;
        public int limit;
        public static final int CONSTRUCTOR = 1555771203;

        public SearchStickers() {
        }

        public SearchStickers(String var1, int var2) {
            this.emoji = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return 1555771203;
        }
    }

    public static class SearchStickerSets extends Function {
        public String query;
        public static final int CONSTRUCTOR = -1082314629;

        public SearchStickerSets() {
        }

        public SearchStickerSets(String var1) {
            this.query = var1;
        }

        @Override
        public int getConstructor() {
            return -1082314629;
        }
    }

    public static class SearchStickerSet extends Function {
        public String name;
        public static final int CONSTRUCTOR = 1157930222;

        public SearchStickerSet() {
        }

        public SearchStickerSet(String var1) {
            this.name = var1;
        }

        @Override
        public int getConstructor() {
            return 1157930222;
        }
    }

    public static class SearchSecretMessages extends Function {
        public long chatId;
        public String query;
        public String offset;
        public int limit;
        public SearchMessagesFilter filter;
        public static final int CONSTRUCTOR = -852865892;

        public SearchSecretMessages() {
        }

        public SearchSecretMessages(long var1, String var3, String var4, int var5, SearchMessagesFilter var6) {
            this.chatId = var1;
            this.query = var3;
            this.offset = var4;
            this.limit = var5;
            this.filter = var6;
        }

        @Override
        public int getConstructor() {
            return -852865892;
        }
    }

    public static class SearchPublicChats extends Function {
        public String query;
        public static final int CONSTRUCTOR = 970385337;

        public SearchPublicChats() {
        }

        public SearchPublicChats(String var1) {
            this.query = var1;
        }

        @Override
        public int getConstructor() {
            return 970385337;
        }
    }

    public static class SearchPublicChat extends Function {
        public String username;
        public static final int CONSTRUCTOR = 857135533;

        public SearchPublicChat() {
        }

        public SearchPublicChat(String var1) {
            this.username = var1;
        }

        @Override
        public int getConstructor() {
            return 857135533;
        }
    }

    public static class SearchMessages extends Function {
        public ChatList chatList;
        public String query;
        public int offsetDate;
        public long offsetChatId;
        public long offsetMessageId;
        public int limit;
        public SearchMessagesFilter filter;
        public int minDate;
        public int maxDate;
        public static final int CONSTRUCTOR = -225214062;

        public SearchMessages() {
        }

        public SearchMessages(ChatList var1, String var2, int var3, long var4, long var6, int var8, SearchMessagesFilter var9, int var10, int var11) {
            this.chatList = var1;
            this.query = var2;
            this.offsetDate = var3;
            this.offsetChatId = var4;
            this.offsetMessageId = var6;
            this.limit = var8;
            this.filter = var9;
            this.minDate = var10;
            this.maxDate = var11;
        }

        @Override
        public int getConstructor() {
            return -225214062;
        }
    }

    public static class SearchInstalledStickerSets extends Function {
        public boolean isMasks;
        public String query;
        public int limit;
        public static final int CONSTRUCTOR = 681171344;

        public SearchInstalledStickerSets() {
        }

        public SearchInstalledStickerSets(boolean var1, String var2, int var3) {
            this.isMasks = var1;
            this.query = var2;
            this.limit = var3;
        }

        @Override
        public int getConstructor() {
            return 681171344;
        }
    }

    public static class SearchHashtags extends Function {
        public String prefix;
        public int limit;
        public static final int CONSTRUCTOR = 1043637617;

        public SearchHashtags() {
        }

        public SearchHashtags(String var1, int var2) {
            this.prefix = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return 1043637617;
        }
    }

    public static class SearchEmojis extends Function {
        public String text;
        public boolean exactMatch;
        public String[] inputLanguageCodes;
        public static final int CONSTRUCTOR = 398837927;

        public SearchEmojis() {
        }

        public SearchEmojis(String var1, boolean var2, String[] var3) {
            this.text = var1;
            this.exactMatch = var2;
            this.inputLanguageCodes = var3;
        }

        @Override
        public int getConstructor() {
            return 398837927;
        }
    }

    public static class SearchContacts extends Function {
        public String query;
        public int limit;
        public static final int CONSTRUCTOR = -1794690715;

        public SearchContacts() {
        }

        public SearchContacts(String var1, int var2) {
            this.query = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return -1794690715;
        }
    }

    public static class SearchChatsOnServer extends Function {
        public String query;
        public int limit;
        public static final int CONSTRUCTOR = -1158402188;

        public SearchChatsOnServer() {
        }

        public SearchChatsOnServer(String var1, int var2) {
            this.query = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return -1158402188;
        }
    }

    public static class SearchChatsNearby extends Function {
        public Location location;
        public static final int CONSTRUCTOR = -196753377;

        public SearchChatsNearby() {
        }

        public SearchChatsNearby(Location var1) {
            this.location = var1;
        }

        @Override
        public int getConstructor() {
            return -196753377;
        }
    }

    public static class SearchChats extends Function {
        public String query;
        public int limit;
        public static final int CONSTRUCTOR = -1879787060;

        public SearchChats() {
        }

        public SearchChats(String var1, int var2) {
            this.query = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return -1879787060;
        }
    }

    public static class SearchChatRecentLocationMessages extends Function {
        public long chatId;
        public int limit;
        public static final int CONSTRUCTOR = 950238950;

        public SearchChatRecentLocationMessages() {
        }

        public SearchChatRecentLocationMessages(long var1, int var3) {
            this.chatId = var1;
            this.limit = var3;
        }

        @Override
        public int getConstructor() {
            return 950238950;
        }
    }

    public static class SearchChatMessages extends Function {
        public long chatId;
        public String query;
        public MessageSender sender;
        public long fromMessageId;
        public int offset;
        public int limit;
        public SearchMessagesFilter filter;
        public long messageThreadId;
        public static final int CONSTRUCTOR = -1700459472;

        public SearchChatMessages() {
        }

        public SearchChatMessages(long var1, String var3, MessageSender var4, long var5, int var7, int var8, SearchMessagesFilter var9, long var10) {
            this.chatId = var1;
            this.query = var3;
            this.sender = var4;
            this.fromMessageId = var5;
            this.offset = var7;
            this.limit = var8;
            this.filter = var9;
            this.messageThreadId = var10;
        }

        @Override
        public int getConstructor() {
            return -1700459472;
        }
    }

    public static class SearchChatMembers extends Function {
        public long chatId;
        public String query;
        public int limit;
        public ChatMembersFilter filter;
        public static final int CONSTRUCTOR = -445823291;

        public SearchChatMembers() {
        }

        public SearchChatMembers(long var1, String var3, int var4, ChatMembersFilter var5) {
            this.chatId = var1;
            this.query = var3;
            this.limit = var4;
            this.filter = var5;
        }

        @Override
        public int getConstructor() {
            return -445823291;
        }
    }

    public static class SearchCallMessages extends Function {
        public long fromMessageId;
        public int limit;
        public boolean onlyMissed;
        public static final int CONSTRUCTOR = -1077230820;

        public SearchCallMessages() {
        }

        public SearchCallMessages(long var1, int var3, boolean var4) {
            this.fromMessageId = var1;
            this.limit = var3;
            this.onlyMissed = var4;
        }

        @Override
        public int getConstructor() {
            return -1077230820;
        }
    }

    public static class SearchBackground extends Function {
        public String name;
        public static final int CONSTRUCTOR = -2130996959;

        public SearchBackground() {
        }

        public SearchBackground(String var1) {
            this.name = var1;
        }

        @Override
        public int getConstructor() {
            return -2130996959;
        }
    }

    public static class SaveApplicationLogEvent extends Function {
        public String type;
        public long chatId;
        public JsonValue data;
        public static final int CONSTRUCTOR = -811154930;

        public SaveApplicationLogEvent() {
        }

        public SaveApplicationLogEvent(String var1, long var2, JsonValue var4) {
            this.type = var1;
            this.chatId = var2;
            this.data = var4;
        }

        @Override
        public int getConstructor() {
            return -811154930;
        }
    }

    public static class RevokeGroupCallInviteLink extends Function {
        public int groupCallId;
        public static final int CONSTRUCTOR = 501589140;

        public RevokeGroupCallInviteLink() {
        }

        public RevokeGroupCallInviteLink(int var1) {
            this.groupCallId = var1;
        }

        @Override
        public int getConstructor() {
            return 501589140;
        }
    }

    public static class RevokeChatInviteLink extends Function {
        public long chatId;
        public String inviteLink;
        public static final int CONSTRUCTOR = -776514135;

        public RevokeChatInviteLink() {
        }

        public RevokeChatInviteLink(long var1, String var3) {
            this.chatId = var1;
            this.inviteLink = var3;
        }

        @Override
        public int getConstructor() {
            return -776514135;
        }
    }

    public static class ResetPassword extends Function {
        public static final int CONSTRUCTOR = -593589091;

        public ResetPassword() {
        }

        @Override
        public int getConstructor() {
            return -593589091;
        }
    }

    public static class ResetNetworkStatistics extends Function {
        public static final int CONSTRUCTOR = 1646452102;

        public ResetNetworkStatistics() {
        }

        @Override
        public int getConstructor() {
            return 1646452102;
        }
    }

    public static class ResetBackgrounds extends Function {
        public static final int CONSTRUCTOR = 204852088;

        public ResetBackgrounds() {
        }

        @Override
        public int getConstructor() {
            return 204852088;
        }
    }

    public static class ResetAllNotificationSettings extends Function {
        public static final int CONSTRUCTOR = -174020359;

        public ResetAllNotificationSettings() {
        }

        @Override
        public int getConstructor() {
            return -174020359;
        }
    }

    public static class ResendRecoveryEmailAddressCode extends Function {
        public static final int CONSTRUCTOR = 433483548;

        public ResendRecoveryEmailAddressCode() {
        }

        @Override
        public int getConstructor() {
            return 433483548;
        }
    }

    public static class ResendPhoneNumberVerificationCode extends Function {
        public static final int CONSTRUCTOR = 1367629820;

        public ResendPhoneNumberVerificationCode() {
        }

        @Override
        public int getConstructor() {
            return 1367629820;
        }
    }

    public static class ResendPhoneNumberConfirmationCode extends Function {
        public static final int CONSTRUCTOR = 2069068522;

        public ResendPhoneNumberConfirmationCode() {
        }

        @Override
        public int getConstructor() {
            return 2069068522;
        }
    }

    public static class ResendMessages extends Function {
        public long chatId;
        public long[] messageIds;
        public static final int CONSTRUCTOR = -940655817;

        public ResendMessages() {
        }

        public ResendMessages(long var1, long[] var3) {
            this.chatId = var1;
            this.messageIds = var3;
        }

        @Override
        public int getConstructor() {
            return -940655817;
        }
    }

    public static class ResendEmailAddressVerificationCode extends Function {
        public static final int CONSTRUCTOR = -1872416732;

        public ResendEmailAddressVerificationCode() {
        }

        @Override
        public int getConstructor() {
            return -1872416732;
        }
    }

    public static class ResendChangePhoneNumberCode extends Function {
        public static final int CONSTRUCTOR = -786772060;

        public ResendChangePhoneNumberCode() {
        }

        @Override
        public int getConstructor() {
            return -786772060;
        }
    }

    public static class ResendAuthenticationCode extends Function {
        public static final int CONSTRUCTOR = -814377191;

        public ResendAuthenticationCode() {
        }

        @Override
        public int getConstructor() {
            return -814377191;
        }
    }

    public static class RequestQrCodeAuthentication extends Function {
        public int[] otherUserIds;
        public static final int CONSTRUCTOR = -104224560;

        public RequestQrCodeAuthentication() {
        }

        public RequestQrCodeAuthentication(int[] var1) {
            this.otherUserIds = var1;
        }

        @Override
        public int getConstructor() {
            return -104224560;
        }
    }

    public static class RequestPasswordRecovery extends Function {
        public static final int CONSTRUCTOR = -13777582;

        public RequestPasswordRecovery() {
        }

        @Override
        public int getConstructor() {
            return -13777582;
        }
    }

    public static class RequestAuthenticationPasswordRecovery extends Function {
        public static final int CONSTRUCTOR = 1393896118;

        public RequestAuthenticationPasswordRecovery() {
        }

        @Override
        public int getConstructor() {
            return 1393896118;
        }
    }

    public static class ReportSupergroupSpam extends Function {
        public int supergroupId;
        public int userId;
        public long[] messageIds;
        public static final int CONSTRUCTOR = -2125451498;

        public ReportSupergroupSpam() {
        }

        public ReportSupergroupSpam(int var1, int var2, long[] var3) {
            this.supergroupId = var1;
            this.userId = var2;
            this.messageIds = var3;
        }

        @Override
        public int getConstructor() {
            return -2125451498;
        }
    }

    public static class ReportChatPhoto extends Function {
        public long chatId;
        public int fileId;
        public ChatReportReason reason;
        public String text;
        public static final int CONSTRUCTOR = 734652708;

        public ReportChatPhoto() {
        }

        public ReportChatPhoto(long var1, int var3, ChatReportReason var4, String var5) {
            this.chatId = var1;
            this.fileId = var3;
            this.reason = var4;
            this.text = var5;
        }

        @Override
        public int getConstructor() {
            return 734652708;
        }
    }

    public static class ReportChat extends Function {
        public long chatId;
        public long[] messageIds;
        public ChatReportReason reason;
        public String text;
        public static final int CONSTRUCTOR = -964543587;

        public ReportChat() {
        }

        public ReportChat(long var1, long[] var3, ChatReportReason var4, String var5) {
            this.chatId = var1;
            this.messageIds = var3;
            this.reason = var4;
            this.text = var5;
        }

        @Override
        public int getConstructor() {
            return -964543587;
        }
    }

    public static class ReplacePrimaryChatInviteLink extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 1067350941;

        public ReplacePrimaryChatInviteLink() {
        }

        public ReplacePrimaryChatInviteLink(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 1067350941;
        }
    }

    public static class ReorderInstalledStickerSets extends Function {
        public boolean isMasks;
        public long[] stickerSetIds;
        public static final int CONSTRUCTOR = 1114537563;

        public ReorderInstalledStickerSets() {
        }

        public ReorderInstalledStickerSets(boolean var1, long[] var2) {
            this.isMasks = var1;
            this.stickerSetIds = var2;
        }

        @Override
        public int getConstructor() {
            return 1114537563;
        }
    }

    public static class ReorderChatFilters extends Function {
        public int[] chatFilterIds;
        public static final int CONSTRUCTOR = -1258111097;

        public ReorderChatFilters() {
        }

        public ReorderChatFilters(int[] var1) {
            this.chatFilterIds = var1;
        }

        @Override
        public int getConstructor() {
            return -1258111097;
        }
    }

    public static class RemoveTopChat extends Function {
        public TopChatCategory category;
        public long chatId;
        public static final int CONSTRUCTOR = -1907876267;

        public RemoveTopChat() {
        }

        public RemoveTopChat(TopChatCategory var1, long var2) {
            this.category = var1;
            this.chatId = var2;
        }

        @Override
        public int getConstructor() {
            return -1907876267;
        }
    }

    public static class RemoveStickerFromSet extends Function {
        public InputFile sticker;
        public static final int CONSTRUCTOR = 1642196644;

        public RemoveStickerFromSet() {
        }

        public RemoveStickerFromSet(InputFile var1) {
            this.sticker = var1;
        }

        @Override
        public int getConstructor() {
            return 1642196644;
        }
    }

    public static class RemoveSavedAnimation extends Function {
        public InputFile animation;
        public static final int CONSTRUCTOR = -495605479;

        public RemoveSavedAnimation() {
        }

        public RemoveSavedAnimation(InputFile var1) {
            this.animation = var1;
        }

        @Override
        public int getConstructor() {
            return -495605479;
        }
    }

    public static class RemoveRecentlyFoundChat extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 717340444;

        public RemoveRecentlyFoundChat() {
        }

        public RemoveRecentlyFoundChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 717340444;
        }
    }

    public static class RemoveRecentSticker extends Function {
        public boolean isAttached;
        public InputFile sticker;
        public static final int CONSTRUCTOR = 1246577677;

        public RemoveRecentSticker() {
        }

        public RemoveRecentSticker(boolean var1, InputFile var2) {
            this.isAttached = var1;
            this.sticker = var2;
        }

        @Override
        public int getConstructor() {
            return 1246577677;
        }
    }

    public static class RemoveRecentHashtag extends Function {
        public String hashtag;
        public static final int CONSTRUCTOR = -1013735260;

        public RemoveRecentHashtag() {
        }

        public RemoveRecentHashtag(String var1) {
            this.hashtag = var1;
        }

        @Override
        public int getConstructor() {
            return -1013735260;
        }
    }

    public static class RemoveProxy extends Function {
        public int proxyId;
        public static final int CONSTRUCTOR = 1369219847;

        public RemoveProxy() {
        }

        public RemoveProxy(int var1) {
            this.proxyId = var1;
        }

        @Override
        public int getConstructor() {
            return 1369219847;
        }
    }

    public static class RemoveNotificationGroup extends Function {
        public int notificationGroupId;
        public int maxNotificationId;
        public static final int CONSTRUCTOR = 1713005454;

        public RemoveNotificationGroup() {
        }

        public RemoveNotificationGroup(int var1, int var2) {
            this.notificationGroupId = var1;
            this.maxNotificationId = var2;
        }

        @Override
        public int getConstructor() {
            return 1713005454;
        }
    }

    public static class RemoveNotification extends Function {
        public int notificationGroupId;
        public int notificationId;
        public static final int CONSTRUCTOR = 862630734;

        public RemoveNotification() {
        }

        public RemoveNotification(int var1, int var2) {
            this.notificationGroupId = var1;
            this.notificationId = var2;
        }

        @Override
        public int getConstructor() {
            return 862630734;
        }
    }

    public static class RemoveFavoriteSticker extends Function {
        public InputFile sticker;
        public static final int CONSTRUCTOR = 1152945264;

        public RemoveFavoriteSticker() {
        }

        public RemoveFavoriteSticker(InputFile var1) {
            this.sticker = var1;
        }

        @Override
        public int getConstructor() {
            return 1152945264;
        }
    }

    public static class RemoveContacts extends Function {
        public int[] userIds;
        public static final int CONSTRUCTOR = -615510759;

        public RemoveContacts() {
        }

        public RemoveContacts(int[] var1) {
            this.userIds = var1;
        }

        @Override
        public int getConstructor() {
            return -615510759;
        }
    }

    public static class RemoveChatActionBar extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = -1650968070;

        public RemoveChatActionBar() {
        }

        public RemoveChatActionBar(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return -1650968070;
        }
    }

    public static class RemoveBackground extends Function {
        public long backgroundId;
        public static final int CONSTRUCTOR = -1484545642;

        public RemoveBackground() {
        }

        public RemoveBackground(long var1) {
            this.backgroundId = var1;
        }

        @Override
        public int getConstructor() {
            return -1484545642;
        }
    }

    public static class RegisterUser extends Function {
        public String firstName;
        public String lastName;
        public static final int CONSTRUCTOR = -109994467;

        public RegisterUser() {
        }

        public RegisterUser(String var1, String var2) {
            this.firstName = var1;
            this.lastName = var2;
        }

        @Override
        public int getConstructor() {
            return -109994467;
        }
    }

    public static class RegisterDevice extends Function {
        public DeviceToken deviceToken;
        public int[] otherUserIds;
        public static final int CONSTRUCTOR = 1734127493;

        public RegisterDevice() {
        }

        public RegisterDevice(DeviceToken var1, int[] var2) {
            this.deviceToken = var1;
            this.otherUserIds = var2;
        }

        @Override
        public int getConstructor() {
            return 1734127493;
        }
    }

    public static class RecoverPassword extends Function {
        public String recoveryCode;
        public String newPassword;
        public String newHint;
        public static final int CONSTRUCTOR = -1524262541;

        public RecoverPassword() {
        }

        public RecoverPassword(String var1, String var2, String var3) {
            this.recoveryCode = var1;
            this.newPassword = var2;
            this.newHint = var3;
        }

        @Override
        public int getConstructor() {
            return -1524262541;
        }
    }

    public static class RecoverAuthenticationPassword extends Function {
        public String recoveryCode;
        public String newPassword;
        public String newHint;
        public static final int CONSTRUCTOR = -131001053;

        public RecoverAuthenticationPassword() {
        }

        public RecoverAuthenticationPassword(String var1, String var2, String var3) {
            this.recoveryCode = var1;
            this.newPassword = var2;
            this.newHint = var3;
        }

        @Override
        public int getConstructor() {
            return -131001053;
        }
    }

    public static class ReadFilePart extends Function {
        public int fileId;
        public int offset;
        public int count;
        public static final int CONSTRUCTOR = -407749314;

        public ReadFilePart() {
        }

        public ReadFilePart(int var1, int var2, int var3) {
            this.fileId = var1;
            this.offset = var2;
            this.count = var3;
        }

        @Override
        public int getConstructor() {
            return -407749314;
        }
    }

    public static class ReadAllChatMentions extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 1357558453;

        public ReadAllChatMentions() {
        }

        public ReadAllChatMentions(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 1357558453;
        }
    }

    public static class ProcessPushNotification extends Function {
        public String payload;
        public static final int CONSTRUCTOR = 786679952;

        public ProcessPushNotification() {
        }

        public ProcessPushNotification(String var1) {
            this.payload = var1;
        }

        @Override
        public int getConstructor() {
            return 786679952;
        }
    }

    public static class PingProxy extends Function {
        public int proxyId;
        public static final int CONSTRUCTOR = -979681103;

        public PingProxy() {
        }

        public PingProxy(int var1) {
            this.proxyId = var1;
        }

        @Override
        public int getConstructor() {
            return -979681103;
        }
    }

    public static class PinChatMessage extends Function {
        public long chatId;
        public long messageId;
        public boolean disableNotification;
        public boolean onlyForSelf;
        public static final int CONSTRUCTOR = 2034719663;

        public PinChatMessage() {
        }

        public PinChatMessage(long var1, long var3, boolean var5, boolean var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.disableNotification = var5;
            this.onlyForSelf = var6;
        }

        @Override
        public int getConstructor() {
            return 2034719663;
        }
    }

    public static class ParseTextEntities extends Function {
        public String text;
        public TextParseMode parseMode;
        public static final int CONSTRUCTOR = -1709194593;

        public ParseTextEntities() {
        }

        public ParseTextEntities(String var1, TextParseMode var2) {
            this.text = var1;
            this.parseMode = var2;
        }

        @Override
        public int getConstructor() {
            return -1709194593;
        }
    }

    public static class ParseMarkdown extends Function {
        public FormattedText text;
        public static final int CONSTRUCTOR = 756366063;

        public ParseMarkdown() {
        }

        public ParseMarkdown(FormattedText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return 756366063;
        }
    }

    public static class OptimizeStorage extends Function {
        public long size;
        public int ttl;
        public int count;
        public int immunityDelay;
        public FileType[] fileTypes;
        public long[] chatIds;
        public long[] excludeChatIds;
        public boolean returnDeletedFileStatistics;
        public int chatLimit;
        public static final int CONSTRUCTOR = 853186759;

        public OptimizeStorage() {
        }

        public OptimizeStorage(long var1, int var3, int var4, int var5, FileType[] var6, long[] var7, long[] var8, boolean var9, int var10) {
            this.size = var1;
            this.ttl = var3;
            this.count = var4;
            this.immunityDelay = var5;
            this.fileTypes = var6;
            this.chatIds = var7;
            this.excludeChatIds = var8;
            this.returnDeletedFileStatistics = var9;
            this.chatLimit = var10;
        }

        @Override
        public int getConstructor() {
            return 853186759;
        }
    }

    public static class OpenMessageContent extends Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -739088005;

        public OpenMessageContent() {
        }

        public OpenMessageContent(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        @Override
        public int getConstructor() {
            return -739088005;
        }
    }

    public static class OpenChat extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = -323371509;

        public OpenChat() {
        }

        public OpenChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return -323371509;
        }
    }

    public static class LogOut extends Function {
        public static final int CONSTRUCTOR = -1581923301;

        public LogOut() {
        }

        @Override
        public int getConstructor() {
            return -1581923301;
        }
    }

    public static class LoadGroupCallParticipants extends Function {
        public int groupCallId;
        public int limit;
        public static final int CONSTRUCTOR = 938720974;

        public LoadGroupCallParticipants() {
        }

        public LoadGroupCallParticipants(int var1, int var2) {
            this.groupCallId = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return 938720974;
        }
    }

    public static class LoadChats extends Function {
        public ChatList chatList;
        public int limit;
        public static final int CONSTRUCTOR = -1885635205;

        public LoadChats() {
        }

        public LoadChats(ChatList var1, int var2) {
            this.chatList = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return -1885635205;
        }
    }

    public static class LeaveGroupCall extends Function {
        public int groupCallId;
        public static final int CONSTRUCTOR = 980152233;

        public LeaveGroupCall() {
        }

        public LeaveGroupCall(int var1) {
            this.groupCallId = var1;
        }

        @Override
        public int getConstructor() {
            return 980152233;
        }
    }

    public static class LeaveChat extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = -1825080735;

        public LeaveChat() {
        }

        public LeaveChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return -1825080735;
        }
    }

    public static class JoinGroupCall extends Function {
        public int groupCallId;
        public MessageSender participantId;
        public int audioSourceId;
        public String payload;
        public boolean isMuted;
        public boolean isMyVideoEnabled;
        public String inviteHash;
        public static final int CONSTRUCTOR = -1043773467;

        public JoinGroupCall() {
        }

        public JoinGroupCall(int var1, MessageSender var2, int var3, String var4, boolean var5, boolean var6, String var7) {
            this.groupCallId = var1;
            this.participantId = var2;
            this.audioSourceId = var3;
            this.payload = var4;
            this.isMuted = var5;
            this.isMyVideoEnabled = var6;
            this.inviteHash = var7;
        }

        @Override
        public int getConstructor() {
            return -1043773467;
        }
    }

    public static class JoinChatByInviteLink extends Function {
        public String inviteLink;
        public static final int CONSTRUCTOR = -1049973882;

        public JoinChatByInviteLink() {
        }

        public JoinChatByInviteLink(String var1) {
            this.inviteLink = var1;
        }

        @Override
        public int getConstructor() {
            return -1049973882;
        }
    }

    public static class JoinChat extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 326769313;

        public JoinChat() {
        }

        public JoinChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 326769313;
        }
    }

    public static class InviteGroupCallParticipants extends Function {
        public int groupCallId;
        public int[] userIds;
        public static final int CONSTRUCTOR = -943374128;

        public InviteGroupCallParticipants() {
        }

        public InviteGroupCallParticipants(int var1, int[] var2) {
            this.groupCallId = var1;
            this.userIds = var2;
        }

        @Override
        public int getConstructor() {
            return -943374128;
        }
    }

    public static class ImportMessages extends Function {
        public long chatId;
        public InputFile messageFile;
        public InputFile[] attachedFiles;
        public static final int CONSTRUCTOR = -1864116784;

        public ImportMessages() {
        }

        public ImportMessages(long var1, InputFile var3, InputFile[] var4) {
            this.chatId = var1;
            this.messageFile = var3;
            this.attachedFiles = var4;
        }

        @Override
        public int getConstructor() {
            return -1864116784;
        }
    }

    public static class ImportContacts extends Function {
        public Contact[] contacts;
        public static final int CONSTRUCTOR = -215132767;

        public ImportContacts() {
        }

        public ImportContacts(Contact[] var1) {
            this.contacts = var1;
        }

        @Override
        public int getConstructor() {
            return -215132767;
        }
    }

    public static class HideSuggestedAction extends Function {
        public SuggestedAction action;
        public static final int CONSTRUCTOR = -1561384065;

        public HideSuggestedAction() {
        }

        public HideSuggestedAction(SuggestedAction var1) {
            this.action = var1;
        }

        @Override
        public int getConstructor() {
            return -1561384065;
        }
    }

    public static class GetWebPagePreview extends Function {
        public FormattedText text;
        public static final int CONSTRUCTOR = 573441580;

        public GetWebPagePreview() {
        }

        public GetWebPagePreview(FormattedText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return 573441580;
        }
    }

    public static class GetWebPageInstantView extends Function {
        public String url;
        public boolean forceFull;
        public static final int CONSTRUCTOR = -1962649975;

        public GetWebPageInstantView() {
        }

        public GetWebPageInstantView(String var1, boolean var2) {
            this.url = var1;
            this.forceFull = var2;
        }

        @Override
        public int getConstructor() {
            return -1962649975;
        }
    }

    public static class GetVoiceChatAvailableParticipants extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 1833478489;

        public GetVoiceChatAvailableParticipants() {
        }

        public GetVoiceChatAvailableParticipants(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 1833478489;
        }
    }

    public static class GetUserProfilePhotos extends Function {
        public int userId;
        public int offset;
        public int limit;
        public static final int CONSTRUCTOR = -768699141;

        public GetUserProfilePhotos() {
        }

        public GetUserProfilePhotos(int var1, int var2, int var3) {
            this.userId = var1;
            this.offset = var2;
            this.limit = var3;
        }

        @Override
        public int getConstructor() {
            return -768699141;
        }
    }

    public static class GetUserPrivacySettingRules extends Function {
        public UserPrivacySetting setting;
        public static final int CONSTRUCTOR = -2077223311;

        public GetUserPrivacySettingRules() {
        }

        public GetUserPrivacySettingRules(UserPrivacySetting var1) {
            this.setting = var1;
        }

        @Override
        public int getConstructor() {
            return -2077223311;
        }
    }

    public static class GetUserFullInfo extends Function {
        public int userId;
        public static final int CONSTRUCTOR = -655443263;

        public GetUserFullInfo() {
        }

        public GetUserFullInfo(int var1) {
            this.userId = var1;
        }

        @Override
        public int getConstructor() {
            return -655443263;
        }
    }

    public static class GetUser extends Function {
        public int userId;
        public static final int CONSTRUCTOR = -47586017;

        public GetUser() {
        }

        public GetUser(int var1) {
            this.userId = var1;
        }

        @Override
        public int getConstructor() {
            return -47586017;
        }
    }

    public static class GetTrendingStickerSets extends Function {
        public int offset;
        public int limit;
        public static final int CONSTRUCTOR = -1494581948;

        public GetTrendingStickerSets() {
        }

        public GetTrendingStickerSets(int var1, int var2) {
            this.offset = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return -1494581948;
        }
    }

    public static class GetTopChats extends Function {
        public TopChatCategory category;
        public int limit;
        public static final int CONSTRUCTOR = -388410847;

        public GetTopChats() {
        }

        public GetTopChats(TopChatCategory var1, int var2) {
            this.category = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return -388410847;
        }
    }

    public static class GetTextEntities extends Function {
        public String text;
        public static final int CONSTRUCTOR = -341490693;

        public GetTextEntities() {
        }

        public GetTextEntities(String var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return -341490693;
        }
    }

    public static class GetTemporaryPasswordState extends Function {
        public static final int CONSTRUCTOR = -12670830;

        public GetTemporaryPasswordState() {
        }

        @Override
        public int getConstructor() {
            return -12670830;
        }
    }

    public static class GetSupportUser extends Function {
        public static final int CONSTRUCTOR = -1733497700;

        public GetSupportUser() {
        }

        @Override
        public int getConstructor() {
            return -1733497700;
        }
    }

    public static class GetSupergroupMembers extends Function {
        public int supergroupId;
        public SupergroupMembersFilter filter;
        public int offset;
        public int limit;
        public static final int CONSTRUCTOR = 1427643098;

        public GetSupergroupMembers() {
        }

        public GetSupergroupMembers(int var1, SupergroupMembersFilter var2, int var3, int var4) {
            this.supergroupId = var1;
            this.filter = var2;
            this.offset = var3;
            this.limit = var4;
        }

        @Override
        public int getConstructor() {
            return 1427643098;
        }
    }

    public static class GetSupergroupFullInfo extends Function {
        public int supergroupId;
        public static final int CONSTRUCTOR = -1150331262;

        public GetSupergroupFullInfo() {
        }

        public GetSupergroupFullInfo(int var1) {
            this.supergroupId = var1;
        }

        @Override
        public int getConstructor() {
            return -1150331262;
        }
    }

    public static class GetSupergroup extends Function {
        public int supergroupId;
        public static final int CONSTRUCTOR = -2063063706;

        public GetSupergroup() {
        }

        public GetSupergroup(int var1) {
            this.supergroupId = var1;
        }

        @Override
        public int getConstructor() {
            return -2063063706;
        }
    }

    public static class GetSuitableDiscussionChats extends Function {
        public static final int CONSTRUCTOR = 49044982;

        public GetSuitableDiscussionChats() {
        }

        @Override
        public int getConstructor() {
            return 49044982;
        }
    }

    public static class GetSuggestedStickerSetName extends Function {
        public String title;
        public static final int CONSTRUCTOR = -1340995520;

        public GetSuggestedStickerSetName() {
        }

        public GetSuggestedStickerSetName(String var1) {
            this.title = var1;
        }

        @Override
        public int getConstructor() {
            return -1340995520;
        }
    }

    public static class GetSuggestedFileName extends Function {
        public int fileId;
        public String directory;
        public static final int CONSTRUCTOR = -2049399674;

        public GetSuggestedFileName() {
        }

        public GetSuggestedFileName(int var1, String var2) {
            this.fileId = var1;
            this.directory = var2;
        }

        @Override
        public int getConstructor() {
            return -2049399674;
        }
    }

    public static class GetStorageStatisticsFast extends Function {
        public static final int CONSTRUCTOR = 61368066;

        public GetStorageStatisticsFast() {
        }

        @Override
        public int getConstructor() {
            return 61368066;
        }
    }

    public static class GetStorageStatistics extends Function {
        public int chatLimit;
        public static final int CONSTRUCTOR = -853193929;

        public GetStorageStatistics() {
        }

        public GetStorageStatistics(int var1) {
            this.chatLimit = var1;
        }

        @Override
        public int getConstructor() {
            return -853193929;
        }
    }

    public static class GetStickers extends Function {
        public String emoji;
        public int limit;
        public static final int CONSTRUCTOR = -1594919556;

        public GetStickers() {
        }

        public GetStickers(String var1, int var2) {
            this.emoji = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return -1594919556;
        }
    }

    public static class GetStickerSet extends Function {
        public long setId;
        public static final int CONSTRUCTOR = 1052318659;

        public GetStickerSet() {
        }

        public GetStickerSet(long var1) {
            this.setId = var1;
        }

        @Override
        public int getConstructor() {
            return 1052318659;
        }
    }

    public static class GetStickerEmojis extends Function {
        public InputFile sticker;
        public static final int CONSTRUCTOR = -1895508665;

        public GetStickerEmojis() {
        }

        public GetStickerEmojis(InputFile var1) {
            this.sticker = var1;
        }

        @Override
        public int getConstructor() {
            return -1895508665;
        }
    }

    public static class GetStatisticalGraph extends Function {
        public long chatId;
        public String token;
        public long x;
        public static final int CONSTRUCTOR = 1100975515;

        public GetStatisticalGraph() {
        }

        public GetStatisticalGraph(long var1, String var3, long var4) {
            this.chatId = var1;
            this.token = var3;
            this.x = var4;
        }

        @Override
        public int getConstructor() {
            return 1100975515;
        }
    }

    public static class GetSecretChat extends Function {
        public int secretChatId;
        public static final int CONSTRUCTOR = 40599169;

        public GetSecretChat() {
        }

        public GetSecretChat(int var1) {
            this.secretChatId = var1;
        }

        @Override
        public int getConstructor() {
            return 40599169;
        }
    }

    public static class GetScopeNotificationSettings extends Function {
        public NotificationSettingsScope scope;
        public static final int CONSTRUCTOR = -995613361;

        public GetScopeNotificationSettings() {
        }

        public GetScopeNotificationSettings(NotificationSettingsScope var1) {
            this.scope = var1;
        }

        @Override
        public int getConstructor() {
            return -995613361;
        }
    }

    public static class GetSavedOrderInfo extends Function {
        public static final int CONSTRUCTOR = -1152016675;

        public GetSavedOrderInfo() {
        }

        @Override
        public int getConstructor() {
            return -1152016675;
        }
    }

    public static class GetSavedAnimations extends Function {
        public static final int CONSTRUCTOR = 7051032;

        public GetSavedAnimations() {
        }

        @Override
        public int getConstructor() {
            return 7051032;
        }
    }

    public static class GetRepliedMessage extends Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -641918531;

        public GetRepliedMessage() {
        }

        public GetRepliedMessage(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        @Override
        public int getConstructor() {
            return -641918531;
        }
    }

    public static class GetRemoteFile extends Function {
        public String remoteFileId;
        public FileType fileType;
        public static final int CONSTRUCTOR = 2137204530;

        public GetRemoteFile() {
        }

        public GetRemoteFile(String var1, FileType var2) {
            this.remoteFileId = var1;
            this.fileType = var2;
        }

        @Override
        public int getConstructor() {
            return 2137204530;
        }
    }

    public static class GetRecoveryEmailAddress extends Function {
        public String password;
        public static final int CONSTRUCTOR = -1594770947;

        public GetRecoveryEmailAddress() {
        }

        public GetRecoveryEmailAddress(String var1) {
            this.password = var1;
        }

        @Override
        public int getConstructor() {
            return -1594770947;
        }
    }

    public static class GetRecommendedChatFilters extends Function {
        public static final int CONSTRUCTOR = -779390746;

        public GetRecommendedChatFilters() {
        }

        @Override
        public int getConstructor() {
            return -779390746;
        }
    }

    public static class GetRecentlyVisitedTMeUrls extends Function {
        public String referrer;
        public static final int CONSTRUCTOR = 806754961;

        public GetRecentlyVisitedTMeUrls() {
        }

        public GetRecentlyVisitedTMeUrls(String var1) {
            this.referrer = var1;
        }

        @Override
        public int getConstructor() {
            return 806754961;
        }
    }

    public static class GetRecentlyOpenedChats extends Function {
        public int limit;
        public static final int CONSTRUCTOR = -1924156893;

        public GetRecentlyOpenedChats() {
        }

        public GetRecentlyOpenedChats(int var1) {
            this.limit = var1;
        }

        @Override
        public int getConstructor() {
            return -1924156893;
        }
    }

    public static class GetRecentStickers extends Function {
        public boolean isAttached;
        public static final int CONSTRUCTOR = -579622241;

        public GetRecentStickers() {
        }

        public GetRecentStickers(boolean var1) {
            this.isAttached = var1;
        }

        @Override
        public int getConstructor() {
            return -579622241;
        }
    }

    public static class GetRecentInlineBots extends Function {
        public static final int CONSTRUCTOR = 1437823548;

        public GetRecentInlineBots() {
        }

        @Override
        public int getConstructor() {
            return 1437823548;
        }
    }

    public static class GetPushReceiverId extends Function {
        public String payload;
        public static final int CONSTRUCTOR = -286505294;

        public GetPushReceiverId() {
        }

        public GetPushReceiverId(String var1) {
            this.payload = var1;
        }

        @Override
        public int getConstructor() {
            return -286505294;
        }
    }

    public static class GetProxyLink extends Function {
        public int proxyId;
        public static final int CONSTRUCTOR = -1054495112;

        public GetProxyLink() {
        }

        public GetProxyLink(int var1) {
            this.proxyId = var1;
        }

        @Override
        public int getConstructor() {
            return -1054495112;
        }
    }

    public static class GetProxies extends Function {
        public static final int CONSTRUCTOR = -95026381;

        public GetProxies() {
        }

        @Override
        public int getConstructor() {
            return -95026381;
        }
    }

    public static class GetPreferredCountryLanguage extends Function {
        public String countryCode;
        public static final int CONSTRUCTOR = -933049386;

        public GetPreferredCountryLanguage() {
        }

        public GetPreferredCountryLanguage(String var1) {
            this.countryCode = var1;
        }

        @Override
        public int getConstructor() {
            return -933049386;
        }
    }

    public static class GetPollVoters extends Function {
        public long chatId;
        public long messageId;
        public int optionId;
        public int offset;
        public int limit;
        public static final int CONSTRUCTOR = 2075288734;

        public GetPollVoters() {
        }

        public GetPollVoters(long var1, long var3, int var5, int var6, int var7) {
            this.chatId = var1;
            this.messageId = var3;
            this.optionId = var5;
            this.offset = var6;
            this.limit = var7;
        }

        @Override
        public int getConstructor() {
            return 2075288734;
        }
    }

    public static class GetPhoneNumberInfoSync extends Function {
        public String languageCode;
        public String phoneNumberPrefix;
        public static final int CONSTRUCTOR = 547061048;

        public GetPhoneNumberInfoSync() {
        }

        public GetPhoneNumberInfoSync(String var1, String var2) {
            this.languageCode = var1;
            this.phoneNumberPrefix = var2;
        }

        @Override
        public int getConstructor() {
            return 547061048;
        }
    }

    public static class GetPhoneNumberInfo extends Function {
        public String phoneNumberPrefix;
        public static final int CONSTRUCTOR = -1608344583;

        public GetPhoneNumberInfo() {
        }

        public GetPhoneNumberInfo(String var1) {
            this.phoneNumberPrefix = var1;
        }

        @Override
        public int getConstructor() {
            return -1608344583;
        }
    }

    public static class GetPaymentReceipt extends Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = 1013758294;

        public GetPaymentReceipt() {
        }

        public GetPaymentReceipt(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        @Override
        public int getConstructor() {
            return 1013758294;
        }
    }

    public static class GetPaymentForm extends Function {
        public long chatId;
        public long messageId;
        public PaymentFormTheme theme;
        public static final int CONSTRUCTOR = 158229273;

        public GetPaymentForm() {
        }

        public GetPaymentForm(long var1, long var3, PaymentFormTheme var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.theme = var5;
        }

        @Override
        public int getConstructor() {
            return 158229273;
        }
    }

    public static class GetPasswordState extends Function {
        public static final int CONSTRUCTOR = -174752904;

        public GetPasswordState() {
        }

        @Override
        public int getConstructor() {
            return -174752904;
        }
    }

    public static class GetPassportElement extends Function {
        public PassportElementType type;
        public String password;
        public static final int CONSTRUCTOR = -1882398342;

        public GetPassportElement() {
        }

        public GetPassportElement(PassportElementType var1, String var2) {
            this.type = var1;
            this.password = var2;
        }

        @Override
        public int getConstructor() {
            return -1882398342;
        }
    }

    public static class GetPassportAuthorizationFormAvailableElements extends Function {
        public int autorizationFormId;
        public String password;
        public static final int CONSTRUCTOR = 1738134754;

        public GetPassportAuthorizationFormAvailableElements() {
        }

        public GetPassportAuthorizationFormAvailableElements(int var1, String var2) {
            this.autorizationFormId = var1;
            this.password = var2;
        }

        @Override
        public int getConstructor() {
            return 1738134754;
        }
    }

    public static class GetPassportAuthorizationForm extends Function {
        public int botUserId;
        public String scope;
        public String publicKey;
        public String nonce;
        public static final int CONSTRUCTOR = -1468394095;

        public GetPassportAuthorizationForm() {
        }

        public GetPassportAuthorizationForm(int var1, String var2, String var3, String var4) {
            this.botUserId = var1;
            this.scope = var2;
            this.publicKey = var3;
            this.nonce = var4;
        }

        @Override
        public int getConstructor() {
            return -1468394095;
        }
    }

    public static class GetOption extends Function {
        public String name;
        public static final int CONSTRUCTOR = -1572495746;

        public GetOption() {
        }

        public GetOption(String var1) {
            this.name = var1;
        }

        @Override
        public int getConstructor() {
            return -1572495746;
        }
    }

    public static class GetNetworkStatistics extends Function {
        public boolean onlyCurrent;
        public static final int CONSTRUCTOR = -986228706;

        public GetNetworkStatistics() {
        }

        public GetNetworkStatistics(boolean var1) {
            this.onlyCurrent = var1;
        }

        @Override
        public int getConstructor() {
            return -986228706;
        }
    }

    public static class GetMessages extends Function {
        public long chatId;
        public long[] messageIds;
        public static final int CONSTRUCTOR = 425299338;

        public GetMessages() {
        }

        public GetMessages(long var1, long[] var3) {
            this.chatId = var1;
            this.messageIds = var3;
        }

        @Override
        public int getConstructor() {
            return 425299338;
        }
    }

    public static class GetMessageThreadHistory extends Function {
        public long chatId;
        public long messageId;
        public long fromMessageId;
        public int offset;
        public int limit;
        public static final int CONSTRUCTOR = -1808411608;

        public GetMessageThreadHistory() {
        }

        public GetMessageThreadHistory(long var1, long var3, long var5, int var7, int var8) {
            this.chatId = var1;
            this.messageId = var3;
            this.fromMessageId = var5;
            this.offset = var7;
            this.limit = var8;
        }

        @Override
        public int getConstructor() {
            return -1808411608;
        }
    }

    public static class GetMessageThread extends Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = 2062695998;

        public GetMessageThread() {
        }

        public GetMessageThread(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        @Override
        public int getConstructor() {
            return 2062695998;
        }
    }

    public static class GetMessageStatistics extends Function {
        public long chatId;
        public long messageId;
        public boolean isDark;
        public static final int CONSTRUCTOR = 1270194648;

        public GetMessageStatistics() {
        }

        public GetMessageStatistics(long var1, long var3, boolean var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.isDark = var5;
        }

        @Override
        public int getConstructor() {
            return 1270194648;
        }
    }

    public static class GetMessagePublicForwards extends Function {
        public long chatId;
        public long messageId;
        public String offset;
        public int limit;
        public static final int CONSTRUCTOR = 1611049289;

        public GetMessagePublicForwards() {
        }

        public GetMessagePublicForwards(long var1, long var3, String var5, int var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.offset = var5;
            this.limit = var6;
        }

        @Override
        public int getConstructor() {
            return 1611049289;
        }
    }

    public static class GetMessageLocally extends Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -603575444;

        public GetMessageLocally() {
        }

        public GetMessageLocally(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        @Override
        public int getConstructor() {
            return -603575444;
        }
    }

    public static class GetMessageLinkInfo extends Function {
        public String url;
        public static final int CONSTRUCTOR = -700533672;

        public GetMessageLinkInfo() {
        }

        public GetMessageLinkInfo(String var1) {
            this.url = var1;
        }

        @Override
        public int getConstructor() {
            return -700533672;
        }
    }

    public static class GetMessageLink extends Function {
        public long chatId;
        public long messageId;
        public int mediaTimestamp;
        public boolean forAlbum;
        public boolean forComment;
        public static final int CONSTRUCTOR = -1607389329;

        public GetMessageLink() {
        }

        public GetMessageLink(long var1, long var3, int var5, boolean var6, boolean var7) {
            this.chatId = var1;
            this.messageId = var3;
            this.mediaTimestamp = var5;
            this.forAlbum = var6;
            this.forComment = var7;
        }

        @Override
        public int getConstructor() {
            return -1607389329;
        }
    }

    public static class GetMessageImportConfirmationText extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 390627752;

        public GetMessageImportConfirmationText() {
        }

        public GetMessageImportConfirmationText(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 390627752;
        }
    }

    public static class GetMessageFileType extends Function {
        public String messageFileHead;
        public static final int CONSTRUCTOR = -490270764;

        public GetMessageFileType() {
        }

        public GetMessageFileType(String var1) {
            this.messageFileHead = var1;
        }

        @Override
        public int getConstructor() {
            return -490270764;
        }
    }

    public static class GetMessageEmbeddingCode extends Function {
        public long chatId;
        public long messageId;
        public boolean forAlbum;
        public static final int CONSTRUCTOR = 1654967561;

        public GetMessageEmbeddingCode() {
        }

        public GetMessageEmbeddingCode(long var1, long var3, boolean var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.forAlbum = var5;
        }

        @Override
        public int getConstructor() {
            return 1654967561;
        }
    }

    public static class GetMessage extends Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -1821196160;

        public GetMessage() {
        }

        public GetMessage(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        @Override
        public int getConstructor() {
            return -1821196160;
        }
    }

    public static class GetMe extends Function {
        public static final int CONSTRUCTOR = -191516033;

        public GetMe() {
        }

        @Override
        public int getConstructor() {
            return -191516033;
        }
    }

    public static class GetMarkdownText extends Function {
        public FormattedText text;
        public static final int CONSTRUCTOR = 164524584;

        public GetMarkdownText() {
        }

        public GetMarkdownText(FormattedText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return 164524584;
        }
    }

    public static class GetMapThumbnailFile extends Function {
        public Location location;
        public int zoom;
        public int width;
        public int height;
        public int scale;
        public long chatId;
        public static final int CONSTRUCTOR = -152660070;

        public GetMapThumbnailFile() {
        }

        public GetMapThumbnailFile(Location var1, int var2, int var3, int var4, int var5, long var6) {
            this.location = var1;
            this.zoom = var2;
            this.width = var3;
            this.height = var4;
            this.scale = var5;
            this.chatId = var6;
        }

        @Override
        public int getConstructor() {
            return -152660070;
        }
    }

    public static class GetLoginUrlInfo extends Function {
        public long chatId;
        public long messageId;
        public int buttonId;
        public static final int CONSTRUCTOR = -980042966;

        public GetLoginUrlInfo() {
        }

        public GetLoginUrlInfo(long var1, long var3, int var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.buttonId = var5;
        }

        @Override
        public int getConstructor() {
            return -980042966;
        }
    }

    public static class GetLoginUrl extends Function {
        public long chatId;
        public long messageId;
        public int buttonId;
        public boolean allowWriteAccess;
        public static final int CONSTRUCTOR = 694973925;

        public GetLoginUrl() {
        }

        public GetLoginUrl(long var1, long var3, int var5, boolean var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.buttonId = var5;
            this.allowWriteAccess = var6;
        }

        @Override
        public int getConstructor() {
            return 694973925;
        }
    }

    public static class GetLogVerbosityLevel extends Function {
        public static final int CONSTRUCTOR = 594057956;

        public GetLogVerbosityLevel() {
        }

        @Override
        public int getConstructor() {
            return 594057956;
        }
    }

    public static class GetLogTags extends Function {
        public static final int CONSTRUCTOR = -254449190;

        public GetLogTags() {
        }

        @Override
        public int getConstructor() {
            return -254449190;
        }
    }

    public static class GetLogTagVerbosityLevel extends Function {
        public String tag;
        public static final int CONSTRUCTOR = 951004547;

        public GetLogTagVerbosityLevel() {
        }

        public GetLogTagVerbosityLevel(String var1) {
            this.tag = var1;
        }

        @Override
        public int getConstructor() {
            return 951004547;
        }
    }

    public static class GetLogStream extends Function {
        public static final int CONSTRUCTOR = 1167608667;

        public GetLogStream() {
        }

        @Override
        public int getConstructor() {
            return 1167608667;
        }
    }

    public static class GetLocalizationTargetInfo extends Function {
        public boolean onlyLocal;
        public static final int CONSTRUCTOR = 1849499526;

        public GetLocalizationTargetInfo() {
        }

        public GetLocalizationTargetInfo(boolean var1) {
            this.onlyLocal = var1;
        }

        @Override
        public int getConstructor() {
            return 1849499526;
        }
    }

    public static class GetLanguagePackStrings extends Function {
        public String languagePackId;
        public String[] keys;
        public static final int CONSTRUCTOR = 1246259088;

        public GetLanguagePackStrings() {
        }

        public GetLanguagePackStrings(String var1, String[] var2) {
            this.languagePackId = var1;
            this.keys = var2;
        }

        @Override
        public int getConstructor() {
            return 1246259088;
        }
    }

    public static class GetLanguagePackString extends Function {
        public String languagePackDatabasePath;
        public String localizationTarget;
        public String languagePackId;
        public String key;
        public static final int CONSTRUCTOR = 150789747;

        public GetLanguagePackString() {
        }

        public GetLanguagePackString(String var1, String var2, String var3, String var4) {
            this.languagePackDatabasePath = var1;
            this.localizationTarget = var2;
            this.languagePackId = var3;
            this.key = var4;
        }

        @Override
        public int getConstructor() {
            return 150789747;
        }
    }

    public static class GetLanguagePackInfo extends Function {
        public String languagePackId;
        public static final int CONSTRUCTOR = 2077809320;

        public GetLanguagePackInfo() {
        }

        public GetLanguagePackInfo(String var1) {
            this.languagePackId = var1;
        }

        @Override
        public int getConstructor() {
            return 2077809320;
        }
    }

    public static class GetJsonValue extends Function {
        public String json;
        public static final int CONSTRUCTOR = -1829086715;

        public GetJsonValue() {
        }

        public GetJsonValue(String var1) {
            this.json = var1;
        }

        @Override
        public int getConstructor() {
            return -1829086715;
        }
    }

    public static class GetJsonString extends Function {
        public JsonValue jsonValue;
        public static final int CONSTRUCTOR = 663458849;

        public GetJsonString() {
        }

        public GetJsonString(JsonValue var1) {
            this.jsonValue = var1;
        }

        @Override
        public int getConstructor() {
            return 663458849;
        }
    }

    public static class GetInternalLinkType extends Function {
        public String link;
        public static final int CONSTRUCTOR = -1948428535;

        public GetInternalLinkType() {
        }

        public GetInternalLinkType(String var1) {
            this.link = var1;
        }

        @Override
        public int getConstructor() {
            return -1948428535;
        }
    }

    public static class GetInstalledStickerSets extends Function {
        public boolean isMasks;
        public static final int CONSTRUCTOR = 1214523749;

        public GetInstalledStickerSets() {
        }

        public GetInstalledStickerSets(boolean var1) {
            this.isMasks = var1;
        }

        @Override
        public int getConstructor() {
            return 1214523749;
        }
    }

    public static class GetInlineQueryResults extends Function {
        public int botUserId;
        public long chatId;
        public Location userLocation;
        public String query;
        public String offset;
        public static final int CONSTRUCTOR = -1182511172;

        public GetInlineQueryResults() {
        }

        public GetInlineQueryResults(int var1, long var2, Location var4, String var5, String var6) {
            this.botUserId = var1;
            this.chatId = var2;
            this.userLocation = var4;
            this.query = var5;
            this.offset = var6;
        }

        @Override
        public int getConstructor() {
            return -1182511172;
        }
    }

    public static class GetInlineGameHighScores extends Function {
        public String inlineMessageId;
        public int userId;
        public static final int CONSTRUCTOR = -1833445800;

        public GetInlineGameHighScores() {
        }

        public GetInlineGameHighScores(String var1, int var2) {
            this.inlineMessageId = var1;
            this.userId = var2;
        }

        @Override
        public int getConstructor() {
            return -1833445800;
        }
    }

    public static class GetInactiveSupergroupChats extends Function {
        public static final int CONSTRUCTOR = -657720907;

        public GetInactiveSupergroupChats() {
        }

        @Override
        public int getConstructor() {
            return -657720907;
        }
    }

    public static class GetImportedContactCount extends Function {
        public static final int CONSTRUCTOR = -656336346;

        public GetImportedContactCount() {
        }

        @Override
        public int getConstructor() {
            return -656336346;
        }
    }

    public static class GetGroupsInCommon extends Function {
        public int userId;
        public long offsetChatId;
        public int limit;
        public static final int CONSTRUCTOR = -23238689;

        public GetGroupsInCommon() {
        }

        public GetGroupsInCommon(int var1, long var2, int var4) {
            this.userId = var1;
            this.offsetChatId = var2;
            this.limit = var4;
        }

        @Override
        public int getConstructor() {
            return -23238689;
        }
    }

    public static class GetGroupCallStreamSegment extends Function {
        public int groupCallId;
        public long timeOffset;
        public int scale;
        public int channelId;
        public GroupCallVideoQuality videoQuality;
        public static final int CONSTRUCTOR = -2077959515;

        public GetGroupCallStreamSegment() {
        }

        public GetGroupCallStreamSegment(int var1, long var2, int var4, int var5, GroupCallVideoQuality var6) {
            this.groupCallId = var1;
            this.timeOffset = var2;
            this.scale = var4;
            this.channelId = var5;
            this.videoQuality = var6;
        }

        @Override
        public int getConstructor() {
            return -2077959515;
        }
    }

    public static class GetGroupCallInviteLink extends Function {
        public int groupCallId;
        public boolean canSelfUnmute;
        public static final int CONSTRUCTOR = 719407396;

        public GetGroupCallInviteLink() {
        }

        public GetGroupCallInviteLink(int var1, boolean var2) {
            this.groupCallId = var1;
            this.canSelfUnmute = var2;
        }

        @Override
        public int getConstructor() {
            return 719407396;
        }
    }

    public static class GetGroupCall extends Function {
        public int groupCallId;
        public static final int CONSTRUCTOR = 1468491406;

        public GetGroupCall() {
        }

        public GetGroupCall(int var1) {
            this.groupCallId = var1;
        }

        @Override
        public int getConstructor() {
            return 1468491406;
        }
    }

    public static class GetGameHighScores extends Function {
        public long chatId;
        public long messageId;
        public int userId;
        public static final int CONSTRUCTOR = 1920923753;

        public GetGameHighScores() {
        }

        public GetGameHighScores(long var1, long var3, int var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.userId = var5;
        }

        @Override
        public int getConstructor() {
            return 1920923753;
        }
    }

    public static class GetFileMimeType extends Function {
        public String fileName;
        public static final int CONSTRUCTOR = -2073879671;

        public GetFileMimeType() {
        }

        public GetFileMimeType(String var1) {
            this.fileName = var1;
        }

        @Override
        public int getConstructor() {
            return -2073879671;
        }
    }

    public static class GetFileExtension extends Function {
        public String mimeType;
        public static final int CONSTRUCTOR = -106055372;

        public GetFileExtension() {
        }

        public GetFileExtension(String var1) {
            this.mimeType = var1;
        }

        @Override
        public int getConstructor() {
            return -106055372;
        }
    }

    public static class GetFileDownloadedPrefixSize extends Function {
        public int fileId;
        public int offset;
        public static final int CONSTRUCTOR = -1668864864;

        public GetFileDownloadedPrefixSize() {
        }

        public GetFileDownloadedPrefixSize(int var1, int var2) {
            this.fileId = var1;
            this.offset = var2;
        }

        @Override
        public int getConstructor() {
            return -1668864864;
        }
    }

    public static class GetFile extends Function {
        public int fileId;
        public static final int CONSTRUCTOR = 1553923406;

        public GetFile() {
        }

        public GetFile(int var1) {
            this.fileId = var1;
        }

        @Override
        public int getConstructor() {
            return 1553923406;
        }
    }

    public static class GetFavoriteStickers extends Function {
        public static final int CONSTRUCTOR = -338964672;

        public GetFavoriteStickers() {
        }

        @Override
        public int getConstructor() {
            return -338964672;
        }
    }

    public static class GetExternalLinkInfo extends Function {
        public String link;
        public static final int CONSTRUCTOR = 1175288383;

        public GetExternalLinkInfo() {
        }

        public GetExternalLinkInfo(String var1) {
            this.link = var1;
        }

        @Override
        public int getConstructor() {
            return 1175288383;
        }
    }

    public static class GetExternalLink extends Function {
        public String link;
        public boolean allowWriteAccess;
        public static final int CONSTRUCTOR = 1586688235;

        public GetExternalLink() {
        }

        public GetExternalLink(String var1, boolean var2) {
            this.link = var1;
            this.allowWriteAccess = var2;
        }

        @Override
        public int getConstructor() {
            return 1586688235;
        }
    }

    public static class GetEmojiSuggestionsUrl extends Function {
        public String languageCode;
        public static final int CONSTRUCTOR = -1404101841;

        public GetEmojiSuggestionsUrl() {
        }

        public GetEmojiSuggestionsUrl(String var1) {
            this.languageCode = var1;
        }

        @Override
        public int getConstructor() {
            return -1404101841;
        }
    }

    public static class GetDeepLinkInfo extends Function {
        public String link;
        public static final int CONSTRUCTOR = 680673150;

        public GetDeepLinkInfo() {
        }

        public GetDeepLinkInfo(String var1) {
            this.link = var1;
        }

        @Override
        public int getConstructor() {
            return 680673150;
        }
    }

    public static class GetDatabaseStatistics extends Function {
        public static final int CONSTRUCTOR = -1942760263;

        public GetDatabaseStatistics() {
        }

        @Override
        public int getConstructor() {
            return -1942760263;
        }
    }

    public static class GetCurrentState extends Function {
        public static final int CONSTRUCTOR = -1191417719;

        public GetCurrentState() {
        }

        @Override
        public int getConstructor() {
            return -1191417719;
        }
    }

    public static class GetCreatedPublicChats extends Function {
        public PublicChatType type;
        public static final int CONSTRUCTOR = 710354415;

        public GetCreatedPublicChats() {
        }

        public GetCreatedPublicChats(PublicChatType var1) {
            this.type = var1;
        }

        @Override
        public int getConstructor() {
            return 710354415;
        }
    }

    public static class GetCountryCode extends Function {
        public static final int CONSTRUCTOR = 1540593906;

        public GetCountryCode() {
        }

        @Override
        public int getConstructor() {
            return 1540593906;
        }
    }

    public static class GetCountries extends Function {
        public static final int CONSTRUCTOR = -51902050;

        public GetCountries() {
        }

        @Override
        public int getConstructor() {
            return -51902050;
        }
    }

    public static class GetContacts extends Function {
        public static final int CONSTRUCTOR = -1417722768;

        public GetContacts() {
        }

        @Override
        public int getConstructor() {
            return -1417722768;
        }
    }

    public static class GetConnectedWebsites extends Function {
        public static final int CONSTRUCTOR = -170536110;

        public GetConnectedWebsites() {
        }

        @Override
        public int getConstructor() {
            return -170536110;
        }
    }

    public static class GetCommands extends Function {
        public BotCommandScope scope;
        public String languageCode;
        public static final int CONSTRUCTOR = 1488621559;

        public GetCommands() {
        }

        public GetCommands(BotCommandScope var1, String var2) {
            this.scope = var1;
            this.languageCode = var2;
        }

        @Override
        public int getConstructor() {
            return 1488621559;
        }
    }

    public static class GetChats extends Function {
        public ChatList chatList;
        public int limit;
        public static final int CONSTRUCTOR = -972768574;

        public GetChats() {
        }

        public GetChats(ChatList var1, int var2) {
            this.chatList = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return -972768574;
        }
    }

    public static class GetChatStatisticsUrl extends Function {
        public long chatId;
        public String parameters;
        public boolean isDark;
        public static final int CONSTRUCTOR = 1114621183;

        public GetChatStatisticsUrl() {
        }

        public GetChatStatisticsUrl(long var1, String var3, boolean var4) {
            this.chatId = var1;
            this.parameters = var3;
            this.isDark = var4;
        }

        @Override
        public int getConstructor() {
            return 1114621183;
        }
    }

    public static class GetChatStatistics extends Function {
        public long chatId;
        public boolean isDark;
        public static final int CONSTRUCTOR = 327057816;

        public GetChatStatistics() {
        }

        public GetChatStatistics(long var1, boolean var3) {
            this.chatId = var1;
            this.isDark = var3;
        }

        @Override
        public int getConstructor() {
            return 327057816;
        }
    }

    public static class GetChatSponsoredMessages extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 1353203864;

        public GetChatSponsoredMessages() {
        }

        public GetChatSponsoredMessages(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 1353203864;
        }
    }

    public static class GetChatScheduledMessages extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = -549638149;

        public GetChatScheduledMessages() {
        }

        public GetChatScheduledMessages(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return -549638149;
        }
    }

    public static class GetChatPinnedMessage extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 359865008;

        public GetChatPinnedMessage() {
        }

        public GetChatPinnedMessage(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 359865008;
        }
    }

    public static class GetChatNotificationSettingsExceptions extends Function {
        public NotificationSettingsScope scope;
        public boolean compareSound;
        public static final int CONSTRUCTOR = 201199121;

        public GetChatNotificationSettingsExceptions() {
        }

        public GetChatNotificationSettingsExceptions(NotificationSettingsScope var1, boolean var2) {
            this.scope = var1;
            this.compareSound = var2;
        }

        @Override
        public int getConstructor() {
            return 201199121;
        }
    }

    public static class GetChatMessageCount extends Function {
        public long chatId;
        public SearchMessagesFilter filter;
        public boolean returnLocal;
        public static final int CONSTRUCTOR = 205435308;

        public GetChatMessageCount() {
        }

        public GetChatMessageCount(long var1, SearchMessagesFilter var3, boolean var4) {
            this.chatId = var1;
            this.filter = var3;
            this.returnLocal = var4;
        }

        @Override
        public int getConstructor() {
            return 205435308;
        }
    }

    public static class GetChatMessageByDate extends Function {
        public long chatId;
        public int date;
        public static final int CONSTRUCTOR = 1062564150;

        public GetChatMessageByDate() {
        }

        public GetChatMessageByDate(long var1, int var3) {
            this.chatId = var1;
            this.date = var3;
        }

        @Override
        public int getConstructor() {
            return 1062564150;
        }
    }

    public static class GetChatMember extends Function {
        public long chatId;
        public MessageSender memberId;
        public static final int CONSTRUCTOR = -792636814;

        public GetChatMember() {
        }

        public GetChatMember(long var1, MessageSender var3) {
            this.chatId = var1;
            this.memberId = var3;
        }

        @Override
        public int getConstructor() {
            return -792636814;
        }
    }

    public static class GetChatListsToAddChat extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 654956193;

        public GetChatListsToAddChat() {
        }

        public GetChatListsToAddChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 654956193;
        }
    }

    public static class GetChatInviteLinks extends Function {
        public long chatId;
        public int creatorUserId;
        public boolean isRevoked;
        public int offsetDate;
        public String offsetInviteLink;
        public int limit;
        public static final int CONSTRUCTOR = -1801388656;

        public GetChatInviteLinks() {
        }

        public GetChatInviteLinks(long var1, int var3, boolean var4, int var5, String var6, int var7) {
            this.chatId = var1;
            this.creatorUserId = var3;
            this.isRevoked = var4;
            this.offsetDate = var5;
            this.offsetInviteLink = var6;
            this.limit = var7;
        }

        @Override
        public int getConstructor() {
            return -1801388656;
        }
    }

    public static class GetChatInviteLinkMembers extends Function {
        public long chatId;
        public String inviteLink;
        public ChatInviteLinkMember offsetMember;
        public int limit;
        public static final int CONSTRUCTOR = -977921638;

        public GetChatInviteLinkMembers() {
        }

        public GetChatInviteLinkMembers(long var1, String var3, ChatInviteLinkMember var4, int var5) {
            this.chatId = var1;
            this.inviteLink = var3;
            this.offsetMember = var4;
            this.limit = var5;
        }

        @Override
        public int getConstructor() {
            return -977921638;
        }
    }

    public static class GetChatInviteLinkCounts extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 890299025;

        public GetChatInviteLinkCounts() {
        }

        public GetChatInviteLinkCounts(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 890299025;
        }
    }

    public static class GetChatInviteLink extends Function {
        public long chatId;
        public String inviteLink;
        public static final int CONSTRUCTOR = -479575555;

        public GetChatInviteLink() {
        }

        public GetChatInviteLink(long var1, String var3) {
            this.chatId = var1;
            this.inviteLink = var3;
        }

        @Override
        public int getConstructor() {
            return -479575555;
        }
    }

    public static class GetChatHistory extends Function {
        public long chatId;
        public long fromMessageId;
        public int offset;
        public int limit;
        public boolean onlyLocal;
        public static final int CONSTRUCTOR = -799960451;

        public GetChatHistory() {
        }

        public GetChatHistory(long var1, long var3, int var5, int var6, boolean var7) {
            this.chatId = var1;
            this.fromMessageId = var3;
            this.offset = var5;
            this.limit = var6;
            this.onlyLocal = var7;
        }

        @Override
        public int getConstructor() {
            return -799960451;
        }
    }

    public static class GetChatFilterDefaultIconName extends Function {
        public ChatFilter filter;
        public static final int CONSTRUCTOR = -1339828680;

        public GetChatFilterDefaultIconName() {
        }

        public GetChatFilterDefaultIconName(ChatFilter var1) {
            this.filter = var1;
        }

        @Override
        public int getConstructor() {
            return -1339828680;
        }
    }

    public static class GetChatFilter extends Function {
        public int chatFilterId;
        public static final int CONSTRUCTOR = 1826317803;

        public GetChatFilter() {
        }

        public GetChatFilter(int var1) {
            this.chatFilterId = var1;
        }

        @Override
        public int getConstructor() {
            return 1826317803;
        }
    }

    public static class GetChatEventLog extends Function {
        public long chatId;
        public String query;
        public long fromEventId;
        public int limit;
        public ChatEventLogFilters filters;
        public int[] userIds;
        public static final int CONSTRUCTOR = 206900967;

        public GetChatEventLog() {
        }

        public GetChatEventLog(long var1, String var3, long var4, int var6, ChatEventLogFilters var7, int[] var8) {
            this.chatId = var1;
            this.query = var3;
            this.fromEventId = var4;
            this.limit = var6;
            this.filters = var7;
            this.userIds = var8;
        }

        @Override
        public int getConstructor() {
            return 206900967;
        }
    }

    public static class GetChatAdministrators extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 1544468155;

        public GetChatAdministrators() {
        }

        public GetChatAdministrators(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 1544468155;
        }
    }

    public static class GetChat extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 1866601536;

        public GetChat() {
        }

        public GetChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 1866601536;
        }
    }

    public static class GetCallbackQueryMessage extends Function {
        public long chatId;
        public long messageId;
        public long callbackQueryId;
        public static final int CONSTRUCTOR = -1121939086;

        public GetCallbackQueryMessage() {
        }

        public GetCallbackQueryMessage(long var1, long var3, long var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.callbackQueryId = var5;
        }

        @Override
        public int getConstructor() {
            return -1121939086;
        }
    }

    public static class GetCallbackQueryAnswer extends Function {
        public long chatId;
        public long messageId;
        public CallbackQueryPayload payload;
        public static final int CONSTRUCTOR = 116357727;

        public GetCallbackQueryAnswer() {
        }

        public GetCallbackQueryAnswer(long var1, long var3, CallbackQueryPayload var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.payload = var5;
        }

        @Override
        public int getConstructor() {
            return 116357727;
        }
    }

    public static class GetBlockedMessageSenders extends Function {
        public int offset;
        public int limit;
        public static final int CONSTRUCTOR = 1947079776;

        public GetBlockedMessageSenders() {
        }

        public GetBlockedMessageSenders(int var1, int var2) {
            this.offset = var1;
            this.limit = var2;
        }

        @Override
        public int getConstructor() {
            return 1947079776;
        }
    }

    public static class GetBasicGroupFullInfo extends Function {
        public int basicGroupId;
        public static final int CONSTRUCTOR = 1770517905;

        public GetBasicGroupFullInfo() {
        }

        public GetBasicGroupFullInfo(int var1) {
            this.basicGroupId = var1;
        }

        @Override
        public int getConstructor() {
            return 1770517905;
        }
    }

    public static class GetBasicGroup extends Function {
        public int basicGroupId;
        public static final int CONSTRUCTOR = 561775568;

        public GetBasicGroup() {
        }

        public GetBasicGroup(int var1) {
            this.basicGroupId = var1;
        }

        @Override
        public int getConstructor() {
            return 561775568;
        }
    }

    public static class GetBankCardInfo extends Function {
        public String bankCardNumber;
        public static final int CONSTRUCTOR = -1310515792;

        public GetBankCardInfo() {
        }

        public GetBankCardInfo(String var1) {
            this.bankCardNumber = var1;
        }

        @Override
        public int getConstructor() {
            return -1310515792;
        }
    }

    public static class GetBackgrounds extends Function {
        public boolean forDarkTheme;
        public static final int CONSTRUCTOR = 249072633;

        public GetBackgrounds() {
        }

        public GetBackgrounds(boolean var1) {
            this.forDarkTheme = var1;
        }

        @Override
        public int getConstructor() {
            return 249072633;
        }
    }

    public static class GetBackgroundUrl extends Function {
        public String name;
        public BackgroundType type;
        public static final int CONSTRUCTOR = 733769682;

        public GetBackgroundUrl() {
        }

        public GetBackgroundUrl(String var1, BackgroundType var2) {
            this.name = var1;
            this.type = var2;
        }

        @Override
        public int getConstructor() {
            return 733769682;
        }
    }

    public static class GetAutoDownloadSettingsPresets extends Function {
        public static final int CONSTRUCTOR = -1721088201;

        public GetAutoDownloadSettingsPresets() {
        }

        @Override
        public int getConstructor() {
            return -1721088201;
        }
    }

    public static class GetAuthorizationState extends Function {
        public static final int CONSTRUCTOR = 1949154877;

        public GetAuthorizationState() {
        }

        @Override
        public int getConstructor() {
            return 1949154877;
        }
    }

    public static class GetAttachedStickerSets extends Function {
        public int fileId;
        public static final int CONSTRUCTOR = 1302172429;

        public GetAttachedStickerSets() {
        }

        public GetAttachedStickerSets(int var1) {
            this.fileId = var1;
        }

        @Override
        public int getConstructor() {
            return 1302172429;
        }
    }

    public static class GetArchivedStickerSets extends Function {
        public boolean isMasks;
        public long offsetStickerSetId;
        public int limit;
        public static final int CONSTRUCTOR = 1996943238;

        public GetArchivedStickerSets() {
        }

        public GetArchivedStickerSets(boolean var1, long var2, int var4) {
            this.isMasks = var1;
            this.offsetStickerSetId = var2;
            this.limit = var4;
        }

        @Override
        public int getConstructor() {
            return 1996943238;
        }
    }

    public static class GetApplicationDownloadLink extends Function {
        public static final int CONSTRUCTOR = 112013252;

        public GetApplicationDownloadLink() {
        }

        @Override
        public int getConstructor() {
            return 112013252;
        }
    }

    public static class GetApplicationConfig extends Function {
        public static final int CONSTRUCTOR = -1823144318;

        public GetApplicationConfig() {
        }

        @Override
        public int getConstructor() {
            return -1823144318;
        }
    }

    public static class GetAllPassportElements extends Function {
        public String password;
        public static final int CONSTRUCTOR = -2038945045;

        public GetAllPassportElements() {
        }

        public GetAllPassportElements(String var1) {
            this.password = var1;
        }

        @Override
        public int getConstructor() {
            return -2038945045;
        }
    }

    public static class GetActiveSessions extends Function {
        public static final int CONSTRUCTOR = 1119710526;

        public GetActiveSessions() {
        }

        @Override
        public int getConstructor() {
            return 1119710526;
        }
    }

    public static class GetActiveLiveLocationMessages extends Function {
        public static final int CONSTRUCTOR = -1425459567;

        public GetActiveLiveLocationMessages() {
        }

        @Override
        public int getConstructor() {
            return -1425459567;
        }
    }

    public static class GetAccountTtl extends Function {
        public static final int CONSTRUCTOR = -443905161;

        public GetAccountTtl() {
        }

        @Override
        public int getConstructor() {
            return -443905161;
        }
    }

    public static class ForwardMessages extends Function {
        public long chatId;
        public long fromChatId;
        public long[] messageIds;
        public MessageSendOptions options;
        public boolean sendCopy;
        public boolean removeCaption;
        public boolean onlyPreview;
        public static final int CONSTRUCTOR = -798726491;

        public ForwardMessages() {
        }

        public ForwardMessages(long var1, long var3, long[] var5, MessageSendOptions var6, boolean var7, boolean var8, boolean var9) {
            this.chatId = var1;
            this.fromChatId = var3;
            this.messageIds = var5;
            this.options = var6;
            this.sendCopy = var7;
            this.removeCaption = var8;
            this.onlyPreview = var9;
        }

        @Override
        public int getConstructor() {
            return -798726491;
        }
    }

    public static class FinishFileGeneration extends Function {
        public long generationId;
        public Error error;
        public static final int CONSTRUCTOR = -1055060835;

        public FinishFileGeneration() {
        }

        public FinishFileGeneration(long var1, Error var3) {
            this.generationId = var1;
            this.error = var3;
        }

        @Override
        public int getConstructor() {
            return -1055060835;
        }
    }

    public static class EndGroupCallScreenSharing extends Function {
        public int groupCallId;
        public static final int CONSTRUCTOR = -2047599540;

        public EndGroupCallScreenSharing() {
        }

        public EndGroupCallScreenSharing(int var1) {
            this.groupCallId = var1;
        }

        @Override
        public int getConstructor() {
            return -2047599540;
        }
    }

    public static class EndGroupCallRecording extends Function {
        public int groupCallId;
        public static final int CONSTRUCTOR = -75799927;

        public EndGroupCallRecording() {
        }

        public EndGroupCallRecording(int var1) {
            this.groupCallId = var1;
        }

        @Override
        public int getConstructor() {
            return -75799927;
        }
    }

    public static class EnableProxy extends Function {
        public int proxyId;
        public static final int CONSTRUCTOR = 1494450838;

        public EnableProxy() {
        }

        public EnableProxy(int var1) {
            this.proxyId = var1;
        }

        @Override
        public int getConstructor() {
            return 1494450838;
        }
    }

    public static class EditProxy extends Function {
        public int proxyId;
        public String server;
        public int port;
        public boolean enable;
        public ProxyType type;
        public static final int CONSTRUCTOR = -1605883821;

        public EditProxy() {
        }

        public EditProxy(int var1, String var2, int var3, boolean var4, ProxyType var5) {
            this.proxyId = var1;
            this.server = var2;
            this.port = var3;
            this.enable = var4;
            this.type = var5;
        }

        @Override
        public int getConstructor() {
            return -1605883821;
        }
    }

    public static class EditMessageText extends Function {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 196272567;

        public EditMessageText() {
        }

        public EditMessageText(long var1, long var3, ReplyMarkup var5, InputMessageContent var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
            this.inputMessageContent = var6;
        }

        @Override
        public int getConstructor() {
            return 196272567;
        }
    }

    public static class EditMessageSchedulingState extends Function {
        public long chatId;
        public long messageId;
        public MessageSchedulingState schedulingState;
        public static final int CONSTRUCTOR = -1372976192;

        public EditMessageSchedulingState() {
        }

        public EditMessageSchedulingState(long var1, long var3, MessageSchedulingState var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.schedulingState = var5;
        }

        @Override
        public int getConstructor() {
            return -1372976192;
        }
    }

    public static class EditMessageReplyMarkup extends Function {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = 332127881;

        public EditMessageReplyMarkup() {
        }

        public EditMessageReplyMarkup(long var1, long var3, ReplyMarkup var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
        }

        @Override
        public int getConstructor() {
            return 332127881;
        }
    }

    public static class EditMessageMedia extends Function {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -1152678125;

        public EditMessageMedia() {
        }

        public EditMessageMedia(long var1, long var3, ReplyMarkup var5, InputMessageContent var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
            this.inputMessageContent = var6;
        }

        @Override
        public int getConstructor() {
            return -1152678125;
        }
    }

    public static class EditMessageLiveLocation extends Function {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;
        public Location location;
        public int heading;
        public int proximityAlertRadius;
        public static final int CONSTRUCTOR = -14047982;

        public EditMessageLiveLocation() {
        }

        public EditMessageLiveLocation(long var1, long var3, ReplyMarkup var5, Location var6, int var7, int var8) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
            this.location = var6;
            this.heading = var7;
            this.proximityAlertRadius = var8;
        }

        @Override
        public int getConstructor() {
            return -14047982;
        }
    }

    public static class EditMessageCaption extends Function {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;
        public FormattedText caption;
        public static final int CONSTRUCTOR = 1154677038;

        public EditMessageCaption() {
        }

        public EditMessageCaption(long var1, long var3, ReplyMarkup var5, FormattedText var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
            this.caption = var6;
        }

        @Override
        public int getConstructor() {
            return 1154677038;
        }
    }

    public static class EditInlineMessageText extends Function {
        public String inlineMessageId;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -855457307;

        public EditInlineMessageText() {
        }

        public EditInlineMessageText(String var1, ReplyMarkup var2, InputMessageContent var3) {
            this.inlineMessageId = var1;
            this.replyMarkup = var2;
            this.inputMessageContent = var3;
        }

        @Override
        public int getConstructor() {
            return -855457307;
        }
    }

    public static class EditInlineMessageReplyMarkup extends Function {
        public String inlineMessageId;
        public ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = -67565858;

        public EditInlineMessageReplyMarkup() {
        }

        public EditInlineMessageReplyMarkup(String var1, ReplyMarkup var2) {
            this.inlineMessageId = var1;
            this.replyMarkup = var2;
        }

        @Override
        public int getConstructor() {
            return -67565858;
        }
    }

    public static class EditInlineMessageMedia extends Function {
        public String inlineMessageId;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 23553921;

        public EditInlineMessageMedia() {
        }

        public EditInlineMessageMedia(String var1, ReplyMarkup var2, InputMessageContent var3) {
            this.inlineMessageId = var1;
            this.replyMarkup = var2;
            this.inputMessageContent = var3;
        }

        @Override
        public int getConstructor() {
            return 23553921;
        }
    }

    public static class EditInlineMessageLiveLocation extends Function {
        public String inlineMessageId;
        public ReplyMarkup replyMarkup;
        public Location location;
        public int heading;
        public int proximityAlertRadius;
        public static final int CONSTRUCTOR = -156902912;

        public EditInlineMessageLiveLocation() {
        }

        public EditInlineMessageLiveLocation(String var1, ReplyMarkup var2, Location var3, int var4, int var5) {
            this.inlineMessageId = var1;
            this.replyMarkup = var2;
            this.location = var3;
            this.heading = var4;
            this.proximityAlertRadius = var5;
        }

        @Override
        public int getConstructor() {
            return -156902912;
        }
    }

    public static class EditInlineMessageCaption extends Function {
        public String inlineMessageId;
        public ReplyMarkup replyMarkup;
        public FormattedText caption;
        public static final int CONSTRUCTOR = -760985929;

        public EditInlineMessageCaption() {
        }

        public EditInlineMessageCaption(String var1, ReplyMarkup var2, FormattedText var3) {
            this.inlineMessageId = var1;
            this.replyMarkup = var2;
            this.caption = var3;
        }

        @Override
        public int getConstructor() {
            return -760985929;
        }
    }

    public static class EditCustomLanguagePackInfo extends Function {
        public LanguagePackInfo info;
        public static final int CONSTRUCTOR = 1320751257;

        public EditCustomLanguagePackInfo() {
        }

        public EditCustomLanguagePackInfo(LanguagePackInfo var1) {
            this.info = var1;
        }

        @Override
        public int getConstructor() {
            return 1320751257;
        }
    }

    public static class EditChatInviteLink extends Function {
        public long chatId;
        public String inviteLink;
        public int expireDate;
        public int memberLimit;
        public static final int CONSTRUCTOR = -537986365;

        public EditChatInviteLink() {
        }

        public EditChatInviteLink(long var1, String var3, int var4, int var5) {
            this.chatId = var1;
            this.inviteLink = var3;
            this.expireDate = var4;
            this.memberLimit = var5;
        }

        @Override
        public int getConstructor() {
            return -537986365;
        }
    }

    public static class EditChatFilter extends Function {
        public int chatFilterId;
        public ChatFilter filter;
        public static final int CONSTRUCTOR = -1674793086;

        public EditChatFilter() {
        }

        public EditChatFilter(int var1, ChatFilter var2) {
            this.chatFilterId = var1;
            this.filter = var2;
        }

        @Override
        public int getConstructor() {
            return -1674793086;
        }
    }

    public static class DownloadFile extends Function {
        public int fileId;
        public int priority;
        public int offset;
        public int limit;
        public boolean synchronous;
        public static final int CONSTRUCTOR = -1102026662;

        public DownloadFile() {
        }

        public DownloadFile(int var1, int var2, int var3, int var4, boolean var5) {
            this.fileId = var1;
            this.priority = var2;
            this.offset = var3;
            this.limit = var4;
            this.synchronous = var5;
        }

        @Override
        public int getConstructor() {
            return -1102026662;
        }
    }

    public static class DisconnectWebsite extends Function {
        public long websiteId;
        public static final int CONSTRUCTOR = -778767395;

        public DisconnectWebsite() {
        }

        public DisconnectWebsite(long var1) {
            this.websiteId = var1;
        }

        @Override
        public int getConstructor() {
            return -778767395;
        }
    }

    public static class DisconnectAllWebsites extends Function {
        public static final int CONSTRUCTOR = -1082985981;

        public DisconnectAllWebsites() {
        }

        @Override
        public int getConstructor() {
            return -1082985981;
        }
    }

    public static class DiscardGroupCall extends Function {
        public int groupCallId;
        public static final int CONSTRUCTOR = 833933657;

        public DiscardGroupCall() {
        }

        public DiscardGroupCall(int var1) {
            this.groupCallId = var1;
        }

        @Override
        public int getConstructor() {
            return 833933657;
        }
    }

    public static class DiscardCall extends Function {
        public int callId;
        public boolean isDisconnected;
        public int duration;
        public boolean isVideo;
        public long connectionId;
        public static final int CONSTRUCTOR = -1784044162;

        public DiscardCall() {
        }

        public DiscardCall(int var1, boolean var2, int var3, boolean var4, long var5) {
            this.callId = var1;
            this.isDisconnected = var2;
            this.duration = var3;
            this.isVideo = var4;
            this.connectionId = var5;
        }

        @Override
        public int getConstructor() {
            return -1784044162;
        }
    }

    public static class DisableProxy extends Function {
        public static final int CONSTRUCTOR = -2100095102;

        public DisableProxy() {
        }

        @Override
        public int getConstructor() {
            return -2100095102;
        }
    }

    public static class Destroy extends Function {
        public static final int CONSTRUCTOR = 685331274;

        public Destroy() {
        }

        @Override
        public int getConstructor() {
            return 685331274;
        }
    }

    public static class DeleteSavedOrderInfo extends Function {
        public static final int CONSTRUCTOR = 1629058164;

        public DeleteSavedOrderInfo() {
        }

        @Override
        public int getConstructor() {
            return 1629058164;
        }
    }

    public static class DeleteSavedCredentials extends Function {
        public static final int CONSTRUCTOR = 826300114;

        public DeleteSavedCredentials() {
        }

        @Override
        public int getConstructor() {
            return 826300114;
        }
    }

    public static class DeleteRevokedChatInviteLink extends Function {
        public long chatId;
        public String inviteLink;
        public static final int CONSTRUCTOR = -1859711873;

        public DeleteRevokedChatInviteLink() {
        }

        public DeleteRevokedChatInviteLink(long var1, String var3) {
            this.chatId = var1;
            this.inviteLink = var3;
        }

        @Override
        public int getConstructor() {
            return -1859711873;
        }
    }

    public static class DeleteProfilePhoto extends Function {
        public long profilePhotoId;
        public static final int CONSTRUCTOR = 1319794625;

        public DeleteProfilePhoto() {
        }

        public DeleteProfilePhoto(long var1) {
            this.profilePhotoId = var1;
        }

        @Override
        public int getConstructor() {
            return 1319794625;
        }
    }

    public static class DeletePassportElement extends Function {
        public PassportElementType type;
        public static final int CONSTRUCTOR = -1719555468;

        public DeletePassportElement() {
        }

        public DeletePassportElement(PassportElementType var1) {
            this.type = var1;
        }

        @Override
        public int getConstructor() {
            return -1719555468;
        }
    }

    public static class DeleteMessages extends Function {
        public long chatId;
        public long[] messageIds;
        public boolean revoke;
        public static final int CONSTRUCTOR = 1130090173;

        public DeleteMessages() {
        }

        public DeleteMessages(long var1, long[] var3, boolean var4) {
            this.chatId = var1;
            this.messageIds = var3;
            this.revoke = var4;
        }

        @Override
        public int getConstructor() {
            return 1130090173;
        }
    }

    public static class DeleteLanguagePack extends Function {
        public String languagePackId;
        public static final int CONSTRUCTOR = -2108761026;

        public DeleteLanguagePack() {
        }

        public DeleteLanguagePack(String var1) {
            this.languagePackId = var1;
        }

        @Override
        public int getConstructor() {
            return -2108761026;
        }
    }

    public static class DeleteFile extends Function {
        public int fileId;
        public static final int CONSTRUCTOR = 1807653676;

        public DeleteFile() {
        }

        public DeleteFile(int var1) {
            this.fileId = var1;
        }

        @Override
        public int getConstructor() {
            return 1807653676;
        }
    }

    public static class DeleteCommands extends Function {
        public BotCommandScope scope;
        public String languageCode;
        public static final int CONSTRUCTOR = 1002732586;

        public DeleteCommands() {
        }

        public DeleteCommands(BotCommandScope var1, String var2) {
            this.scope = var1;
            this.languageCode = var2;
        }

        @Override
        public int getConstructor() {
            return 1002732586;
        }
    }

    public static class DeleteChatReplyMarkup extends Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = 100637531;

        public DeleteChatReplyMarkup() {
        }

        public DeleteChatReplyMarkup(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        @Override
        public int getConstructor() {
            return 100637531;
        }
    }

    public static class DeleteChatMessagesFromUser extends Function {
        public long chatId;
        public int userId;
        public static final int CONSTRUCTOR = -1599689199;

        public DeleteChatMessagesFromUser() {
        }

        public DeleteChatMessagesFromUser(long var1, int var3) {
            this.chatId = var1;
            this.userId = var3;
        }

        @Override
        public int getConstructor() {
            return -1599689199;
        }
    }

    public static class DeleteChatHistory extends Function {
        public long chatId;
        public boolean removeFromChatList;
        public boolean revoke;
        public static final int CONSTRUCTOR = -1472081761;

        public DeleteChatHistory() {
        }

        public DeleteChatHistory(long var1, boolean var3, boolean var4) {
            this.chatId = var1;
            this.removeFromChatList = var3;
            this.revoke = var4;
        }

        @Override
        public int getConstructor() {
            return -1472081761;
        }
    }

    public static class DeleteChatFilter extends Function {
        public int chatFilterId;
        public static final int CONSTRUCTOR = -523220877;

        public DeleteChatFilter() {
        }

        public DeleteChatFilter(int var1) {
            this.chatFilterId = var1;
        }

        @Override
        public int getConstructor() {
            return -523220877;
        }
    }

    public static class DeleteChat extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = -171253666;

        public DeleteChat() {
        }

        public DeleteChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return -171253666;
        }
    }

    public static class DeleteAllRevokedChatInviteLinks extends Function {
        public long chatId;
        public int creatorUserId;
        public static final int CONSTRUCTOR = -356192187;

        public DeleteAllRevokedChatInviteLinks() {
        }

        public DeleteAllRevokedChatInviteLinks(long var1, int var3) {
            this.chatId = var1;
            this.creatorUserId = var3;
        }

        @Override
        public int getConstructor() {
            return -356192187;
        }
    }

    public static class DeleteAllCallMessages extends Function {
        public boolean revoke;
        public static final int CONSTRUCTOR = -1466445325;

        public DeleteAllCallMessages() {
        }

        public DeleteAllCallMessages(boolean var1) {
            this.revoke = var1;
        }

        @Override
        public int getConstructor() {
            return -1466445325;
        }
    }

    public static class DeleteAccount extends Function {
        public String reason;
        public static final int CONSTRUCTOR = -1203056508;

        public DeleteAccount() {
        }

        public DeleteAccount(String var1) {
            this.reason = var1;
        }

        @Override
        public int getConstructor() {
            return -1203056508;
        }
    }

    public static class CreateVoiceChat extends Function {
        public long chatId;
        public String title;
        public int startDate;
        public static final int CONSTRUCTOR = 1239415145;

        public CreateVoiceChat() {
        }

        public CreateVoiceChat(long var1, String var3, int var4) {
            this.chatId = var1;
            this.title = var3;
            this.startDate = var4;
        }

        @Override
        public int getConstructor() {
            return 1239415145;
        }
    }

    public static class CreateTemporaryPassword extends Function {
        public String password;
        public int validFor;
        public static final int CONSTRUCTOR = -1626509434;

        public CreateTemporaryPassword() {
        }

        public CreateTemporaryPassword(String var1, int var2) {
            this.password = var1;
            this.validFor = var2;
        }

        @Override
        public int getConstructor() {
            return -1626509434;
        }
    }

    public static class CreateSupergroupChat extends Function {
        public int supergroupId;
        public boolean force;
        public static final int CONSTRUCTOR = 352742758;

        public CreateSupergroupChat() {
        }

        public CreateSupergroupChat(int var1, boolean var2) {
            this.supergroupId = var1;
            this.force = var2;
        }

        @Override
        public int getConstructor() {
            return 352742758;
        }
    }

    public static class CreateSecretChat extends Function {
        public int secretChatId;
        public static final int CONSTRUCTOR = 1930285615;

        public CreateSecretChat() {
        }

        public CreateSecretChat(int var1) {
            this.secretChatId = var1;
        }

        @Override
        public int getConstructor() {
            return 1930285615;
        }
    }

    public static class CreatePrivateChat extends Function {
        public int userId;
        public boolean force;
        public static final int CONSTRUCTOR = -1807530364;

        public CreatePrivateChat() {
        }

        public CreatePrivateChat(int var1, boolean var2) {
            this.userId = var1;
            this.force = var2;
        }

        @Override
        public int getConstructor() {
            return -1807530364;
        }
    }

    public static class CreateNewSupergroupChat extends Function {
        public String title;
        public boolean isChannel;
        public String description;
        public ChatLocation location;
        public boolean forImport;
        public static final int CONSTRUCTOR = -830232895;

        public CreateNewSupergroupChat() {
        }

        public CreateNewSupergroupChat(String var1, boolean var2, String var3, ChatLocation var4, boolean var5) {
            this.title = var1;
            this.isChannel = var2;
            this.description = var3;
            this.location = var4;
            this.forImport = var5;
        }

        @Override
        public int getConstructor() {
            return -830232895;
        }
    }

    public static class CreateNewStickerSet extends Function {
        public int userId;
        public String title;
        public String name;
        public boolean isMasks;
        public InputSticker[] stickers;
        public String source;
        public static final int CONSTRUCTOR = -778590153;

        public CreateNewStickerSet() {
        }

        public CreateNewStickerSet(int var1, String var2, String var3, boolean var4, InputSticker[] var5, String var6) {
            this.userId = var1;
            this.title = var2;
            this.name = var3;
            this.isMasks = var4;
            this.stickers = var5;
            this.source = var6;
        }

        @Override
        public int getConstructor() {
            return -778590153;
        }
    }

    public static class CreateNewSecretChat extends Function {
        public int userId;
        public static final int CONSTRUCTOR = 1689344881;

        public CreateNewSecretChat() {
        }

        public CreateNewSecretChat(int var1) {
            this.userId = var1;
        }

        @Override
        public int getConstructor() {
            return 1689344881;
        }
    }

    public static class CreateNewBasicGroupChat extends Function {
        public int[] userIds;
        public String title;
        public static final int CONSTRUCTOR = 1874532069;

        public CreateNewBasicGroupChat() {
        }

        public CreateNewBasicGroupChat(int[] var1, String var2) {
            this.userIds = var1;
            this.title = var2;
        }

        @Override
        public int getConstructor() {
            return 1874532069;
        }
    }

    public static class CreateChatInviteLink extends Function {
        public long chatId;
        public int expireDate;
        public int memberLimit;
        public static final int CONSTRUCTOR = 797126142;

        public CreateChatInviteLink() {
        }

        public CreateChatInviteLink(long var1, int var3, int var4) {
            this.chatId = var1;
            this.expireDate = var3;
            this.memberLimit = var4;
        }

        @Override
        public int getConstructor() {
            return 797126142;
        }
    }

    public static class CreateChatFilter extends Function {
        public ChatFilter filter;
        public static final int CONSTRUCTOR = 49065126;

        public CreateChatFilter() {
        }

        public CreateChatFilter(ChatFilter var1) {
            this.filter = var1;
        }

        @Override
        public int getConstructor() {
            return 49065126;
        }
    }

    public static class CreateCall extends Function {
        public int userId;
        public CallProtocol protocol;
        public boolean isVideo;
        public static final int CONSTRUCTOR = 1837533340;

        public CreateCall() {
        }

        public CreateCall(int var1, CallProtocol var2, boolean var3) {
            this.userId = var1;
            this.protocol = var2;
            this.isVideo = var3;
        }

        @Override
        public int getConstructor() {
            return 1837533340;
        }
    }

    public static class CreateBasicGroupChat extends Function {
        public int basicGroupId;
        public boolean force;
        public static final int CONSTRUCTOR = 642492777;

        public CreateBasicGroupChat() {
        }

        public CreateBasicGroupChat(int var1, boolean var2) {
            this.basicGroupId = var1;
            this.force = var2;
        }

        @Override
        public int getConstructor() {
            return 642492777;
        }
    }

    public static class ConfirmQrCodeAuthentication extends Function {
        public String link;
        public static final int CONSTRUCTOR = -376199379;

        public ConfirmQrCodeAuthentication() {
        }

        public ConfirmQrCodeAuthentication(String var1) {
            this.link = var1;
        }

        @Override
        public int getConstructor() {
            return -376199379;
        }
    }

    public static class CloseSecretChat extends Function {
        public int secretChatId;
        public static final int CONSTRUCTOR = -471006133;

        public CloseSecretChat() {
        }

        public CloseSecretChat(int var1) {
            this.secretChatId = var1;
        }

        @Override
        public int getConstructor() {
            return -471006133;
        }
    }

    public static class CloseChat extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = 39749353;

        public CloseChat() {
        }

        public CloseChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 39749353;
        }
    }

    public static class Close extends Function {
        public static final int CONSTRUCTOR = -1187782273;

        public Close() {
        }

        @Override
        public int getConstructor() {
            return -1187782273;
        }
    }

    public static class ClearRecentlyFoundChats extends Function {
        public static final int CONSTRUCTOR = -285582542;

        public ClearRecentlyFoundChats() {
        }

        @Override
        public int getConstructor() {
            return -285582542;
        }
    }

    public static class ClearRecentStickers extends Function {
        public boolean isAttached;
        public static final int CONSTRUCTOR = -321242684;

        public ClearRecentStickers() {
        }

        public ClearRecentStickers(boolean var1) {
            this.isAttached = var1;
        }

        @Override
        public int getConstructor() {
            return -321242684;
        }
    }

    public static class ClearImportedContacts extends Function {
        public static final int CONSTRUCTOR = 869503298;

        public ClearImportedContacts() {
        }

        @Override
        public int getConstructor() {
            return 869503298;
        }
    }

    public static class ClearAllDraftMessages extends Function {
        public boolean excludeSecretChats;
        public static final int CONSTRUCTOR = -46369573;

        public ClearAllDraftMessages() {
        }

        public ClearAllDraftMessages(boolean var1) {
            this.excludeSecretChats = var1;
        }

        @Override
        public int getConstructor() {
            return -46369573;
        }
    }

    public static class CleanFileName extends Function {
        public String fileName;
        public static final int CONSTRUCTOR = 967964667;

        public CleanFileName() {
        }

        public CleanFileName(String var1) {
            this.fileName = var1;
        }

        @Override
        public int getConstructor() {
            return 967964667;
        }
    }

    public static class CheckStickerSetName extends Function {
        public String name;
        public static final int CONSTRUCTOR = -1789392642;

        public CheckStickerSetName() {
        }

        public CheckStickerSetName(String var1) {
            this.name = var1;
        }

        @Override
        public int getConstructor() {
            return -1789392642;
        }
    }

    public static class CheckRecoveryEmailAddressCode extends Function {
        public String code;
        public static final int CONSTRUCTOR = -1997039589;

        public CheckRecoveryEmailAddressCode() {
        }

        public CheckRecoveryEmailAddressCode(String var1) {
            this.code = var1;
        }

        @Override
        public int getConstructor() {
            return -1997039589;
        }
    }

    public static class CheckPhoneNumberVerificationCode extends Function {
        public String code;
        public static final int CONSTRUCTOR = 1497462718;

        public CheckPhoneNumberVerificationCode() {
        }

        public CheckPhoneNumberVerificationCode(String var1) {
            this.code = var1;
        }

        @Override
        public int getConstructor() {
            return 1497462718;
        }
    }

    public static class CheckPhoneNumberConfirmationCode extends Function {
        public String code;
        public static final int CONSTRUCTOR = -1348060966;

        public CheckPhoneNumberConfirmationCode() {
        }

        public CheckPhoneNumberConfirmationCode(String var1) {
            this.code = var1;
        }

        @Override
        public int getConstructor() {
            return -1348060966;
        }
    }

    public static class CheckPasswordRecoveryCode extends Function {
        public String recoveryCode;
        public static final int CONSTRUCTOR = -200794600;

        public CheckPasswordRecoveryCode() {
        }

        public CheckPasswordRecoveryCode(String var1) {
            this.recoveryCode = var1;
        }

        @Override
        public int getConstructor() {
            return -200794600;
        }
    }

    public static class CheckEmailAddressVerificationCode extends Function {
        public String code;
        public static final int CONSTRUCTOR = -426386685;

        public CheckEmailAddressVerificationCode() {
        }

        public CheckEmailAddressVerificationCode(String var1) {
            this.code = var1;
        }

        @Override
        public int getConstructor() {
            return -426386685;
        }
    }

    public static class CheckDatabaseEncryptionKey extends Function {
        public byte[] encryptionKey;
        public static final int CONSTRUCTOR = 1018769307;

        public CheckDatabaseEncryptionKey() {
        }

        public CheckDatabaseEncryptionKey(byte[] var1) {
            this.encryptionKey = var1;
        }

        @Override
        public int getConstructor() {
            return 1018769307;
        }
    }

    public static class CheckCreatedPublicChatsLimit extends Function {
        public PublicChatType type;
        public static final int CONSTRUCTOR = -445546591;

        public CheckCreatedPublicChatsLimit() {
        }

        public CheckCreatedPublicChatsLimit(PublicChatType var1) {
            this.type = var1;
        }

        @Override
        public int getConstructor() {
            return -445546591;
        }
    }

    public static class CheckChatUsername extends Function {
        public long chatId;
        public String username;
        public static final int CONSTRUCTOR = -119119344;

        public CheckChatUsername() {
        }

        public CheckChatUsername(long var1, String var3) {
            this.chatId = var1;
            this.username = var3;
        }

        @Override
        public int getConstructor() {
            return -119119344;
        }
    }

    public static class CheckChatInviteLink extends Function {
        public String inviteLink;
        public static final int CONSTRUCTOR = -496940997;

        public CheckChatInviteLink() {
        }

        public CheckChatInviteLink(String var1) {
            this.inviteLink = var1;
        }

        @Override
        public int getConstructor() {
            return -496940997;
        }
    }

    public static class CheckChangePhoneNumberCode extends Function {
        public String code;
        public static final int CONSTRUCTOR = -1720278429;

        public CheckChangePhoneNumberCode() {
        }

        public CheckChangePhoneNumberCode(String var1) {
            this.code = var1;
        }

        @Override
        public int getConstructor() {
            return -1720278429;
        }
    }

    public static class CheckAuthenticationPasswordRecoveryCode extends Function {
        public String recoveryCode;
        public static final int CONSTRUCTOR = -603309083;

        public CheckAuthenticationPasswordRecoveryCode() {
        }

        public CheckAuthenticationPasswordRecoveryCode(String var1) {
            this.recoveryCode = var1;
        }

        @Override
        public int getConstructor() {
            return -603309083;
        }
    }

    public static class CheckAuthenticationPassword extends Function {
        public String password;
        public static final int CONSTRUCTOR = -2025698400;

        public CheckAuthenticationPassword() {
        }

        public CheckAuthenticationPassword(String var1) {
            this.password = var1;
        }

        @Override
        public int getConstructor() {
            return -2025698400;
        }
    }

    public static class CheckAuthenticationCode extends Function {
        public String code;
        public static final int CONSTRUCTOR = -302103382;

        public CheckAuthenticationCode() {
        }

        public CheckAuthenticationCode(String var1) {
            this.code = var1;
        }

        @Override
        public int getConstructor() {
            return -302103382;
        }
    }

    public static class CheckAuthenticationBotToken extends Function {
        public String token;
        public static final int CONSTRUCTOR = 639321206;

        public CheckAuthenticationBotToken() {
        }

        public CheckAuthenticationBotToken(String var1) {
            this.token = var1;
        }

        @Override
        public int getConstructor() {
            return 639321206;
        }
    }

    public static class ChangeStickerSet extends Function {
        public long setId;
        public boolean isInstalled;
        public boolean isArchived;
        public static final int CONSTRUCTOR = 449357293;

        public ChangeStickerSet() {
        }

        public ChangeStickerSet(long var1, boolean var3, boolean var4) {
            this.setId = var1;
            this.isInstalled = var3;
            this.isArchived = var4;
        }

        @Override
        public int getConstructor() {
            return 449357293;
        }
    }

    public static class ChangePhoneNumber extends Function {
        public String phoneNumber;
        public PhoneNumberAuthenticationSettings settings;
        public static final int CONSTRUCTOR = -124666973;

        public ChangePhoneNumber() {
        }

        public ChangePhoneNumber(String var1, PhoneNumberAuthenticationSettings var2) {
            this.phoneNumber = var1;
            this.settings = var2;
        }

        @Override
        public int getConstructor() {
            return -124666973;
        }
    }

    public static class ChangeImportedContacts extends Function {
        public Contact[] contacts;
        public static final int CONSTRUCTOR = 1968207955;

        public ChangeImportedContacts() {
        }

        public ChangeImportedContacts(Contact[] var1) {
            this.contacts = var1;
        }

        @Override
        public int getConstructor() {
            return 1968207955;
        }
    }

    public static class CancelUploadFile extends Function {
        public int fileId;
        public static final int CONSTRUCTOR = 1623539600;

        public CancelUploadFile() {
        }

        public CancelUploadFile(int var1) {
            this.fileId = var1;
        }

        @Override
        public int getConstructor() {
            return 1623539600;
        }
    }

    public static class CancelPasswordReset extends Function {
        public static final int CONSTRUCTOR = 940733538;

        public CancelPasswordReset() {
        }

        @Override
        public int getConstructor() {
            return 940733538;
        }
    }

    public static class CancelDownloadFile extends Function {
        public int fileId;
        public boolean onlyIfPending;
        public static final int CONSTRUCTOR = -1954524450;

        public CancelDownloadFile() {
        }

        public CancelDownloadFile(int var1, boolean var2) {
            this.fileId = var1;
            this.onlyIfPending = var2;
        }

        @Override
        public int getConstructor() {
            return -1954524450;
        }
    }

    public static class CanTransferOwnership extends Function {
        public static final int CONSTRUCTOR = 634602508;

        public CanTransferOwnership() {
        }

        @Override
        public int getConstructor() {
            return 634602508;
        }
    }

    public static class BlockMessageSenderFromReplies extends Function {
        public long messageId;
        public boolean deleteMessage;
        public boolean deleteAllMessages;
        public boolean reportSpam;
        public static final int CONSTRUCTOR = -1214384757;

        public BlockMessageSenderFromReplies() {
        }

        public BlockMessageSenderFromReplies(long var1, boolean var3, boolean var4, boolean var5) {
            this.messageId = var1;
            this.deleteMessage = var3;
            this.deleteAllMessages = var4;
            this.reportSpam = var5;
        }

        @Override
        public int getConstructor() {
            return -1214384757;
        }
    }

    public static class BanChatMember extends Function {
        public long chatId;
        public MessageSender memberId;
        public int bannedUntilDate;
        public boolean revokeMessages;
        public static final int CONSTRUCTOR = -888111748;

        public BanChatMember() {
        }

        public BanChatMember(long var1, MessageSender var3, int var4, boolean var5) {
            this.chatId = var1;
            this.memberId = var3;
            this.bannedUntilDate = var4;
            this.revokeMessages = var5;
        }

        @Override
        public int getConstructor() {
            return -888111748;
        }
    }

    public static class AnswerShippingQuery extends Function {
        public long shippingQueryId;
        public ShippingOption[] shippingOptions;
        public String errorMessage;
        public static final int CONSTRUCTOR = -434601324;

        public AnswerShippingQuery() {
        }

        public AnswerShippingQuery(long var1, ShippingOption[] var3, String var4) {
            this.shippingQueryId = var1;
            this.shippingOptions = var3;
            this.errorMessage = var4;
        }

        @Override
        public int getConstructor() {
            return -434601324;
        }
    }

    public static class AnswerPreCheckoutQuery extends Function {
        public long preCheckoutQueryId;
        public String errorMessage;
        public static final int CONSTRUCTOR = -1486789653;

        public AnswerPreCheckoutQuery() {
        }

        public AnswerPreCheckoutQuery(long var1, String var3) {
            this.preCheckoutQueryId = var1;
            this.errorMessage = var3;
        }

        @Override
        public int getConstructor() {
            return -1486789653;
        }
    }

    public static class AnswerInlineQuery extends Function {
        public long inlineQueryId;
        public boolean isPersonal;
        public InputInlineQueryResult[] results;
        public int cacheTime;
        public String nextOffset;
        public String switchPmText;
        public String switchPmParameter;
        public static final int CONSTRUCTOR = 485879477;

        public AnswerInlineQuery() {
        }

        public AnswerInlineQuery(long var1, boolean var3, InputInlineQueryResult[] var4, int var5, String var6, String var7, String var8) {
            this.inlineQueryId = var1;
            this.isPersonal = var3;
            this.results = var4;
            this.cacheTime = var5;
            this.nextOffset = var6;
            this.switchPmText = var7;
            this.switchPmParameter = var8;
        }

        @Override
        public int getConstructor() {
            return 485879477;
        }
    }

    public static class AnswerCustomQuery extends Function {
        public long customQueryId;
        public String data;
        public static final int CONSTRUCTOR = -1293603521;

        public AnswerCustomQuery() {
        }

        public AnswerCustomQuery(long var1, String var3) {
            this.customQueryId = var1;
            this.data = var3;
        }

        @Override
        public int getConstructor() {
            return -1293603521;
        }
    }

    public static class AnswerCallbackQuery extends Function {
        public long callbackQueryId;
        public String text;
        public boolean showAlert;
        public String url;
        public int cacheTime;
        public static final int CONSTRUCTOR = -1153028490;

        public AnswerCallbackQuery() {
        }

        public AnswerCallbackQuery(long var1, String var3, boolean var4, String var5, int var6) {
            this.callbackQueryId = var1;
            this.text = var3;
            this.showAlert = var4;
            this.url = var5;
            this.cacheTime = var6;
        }

        @Override
        public int getConstructor() {
            return -1153028490;
        }
    }

    public static class AddStickerToSet extends Function {
        public int userId;
        public String name;
        public InputSticker sticker;
        public static final int CONSTRUCTOR = -454661588;

        public AddStickerToSet() {
        }

        public AddStickerToSet(int var1, String var2, InputSticker var3) {
            this.userId = var1;
            this.name = var2;
            this.sticker = var3;
        }

        @Override
        public int getConstructor() {
            return -454661588;
        }
    }

    public static class AddSavedAnimation extends Function {
        public InputFile animation;
        public static final int CONSTRUCTOR = -1538525088;

        public AddSavedAnimation() {
        }

        public AddSavedAnimation(InputFile var1) {
            this.animation = var1;
        }

        @Override
        public int getConstructor() {
            return -1538525088;
        }
    }

    public static class AddRecentlyFoundChat extends Function {
        public long chatId;
        public static final int CONSTRUCTOR = -1746396787;

        public AddRecentlyFoundChat() {
        }

        public AddRecentlyFoundChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return -1746396787;
        }
    }

    public static class AddRecentSticker extends Function {
        public boolean isAttached;
        public InputFile sticker;
        public static final int CONSTRUCTOR = -1478109026;

        public AddRecentSticker() {
        }

        public AddRecentSticker(boolean var1, InputFile var2) {
            this.isAttached = var1;
            this.sticker = var2;
        }

        @Override
        public int getConstructor() {
            return -1478109026;
        }
    }

    public static class AddProxy extends Function {
        public String server;
        public int port;
        public boolean enable;
        public ProxyType type;
        public static final int CONSTRUCTOR = 331529432;

        public AddProxy() {
        }

        public AddProxy(String var1, int var2, boolean var3, ProxyType var4) {
            this.server = var1;
            this.port = var2;
            this.enable = var3;
            this.type = var4;
        }

        @Override
        public int getConstructor() {
            return 331529432;
        }
    }

    public static class AddNetworkStatistics extends Function {
        public NetworkStatisticsEntry entry;
        public static final int CONSTRUCTOR = 1264825305;

        public AddNetworkStatistics() {
        }

        public AddNetworkStatistics(NetworkStatisticsEntry var1) {
            this.entry = var1;
        }

        @Override
        public int getConstructor() {
            return 1264825305;
        }
    }

    public static class AddLogMessage extends Function {
        public int verbosityLevel;
        public String text;
        public static final int CONSTRUCTOR = 1597427692;

        public AddLogMessage() {
        }

        public AddLogMessage(int var1, String var2) {
            this.verbosityLevel = var1;
            this.text = var2;
        }

        @Override
        public int getConstructor() {
            return 1597427692;
        }
    }

    public static class AddLocalMessage extends Function {
        public long chatId;
        public MessageSender sender;
        public long replyToMessageId;
        public boolean disableNotification;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 856399322;

        public AddLocalMessage() {
        }

        public AddLocalMessage(long var1, MessageSender var3, long var4, boolean var6, InputMessageContent var7) {
            this.chatId = var1;
            this.sender = var3;
            this.replyToMessageId = var4;
            this.disableNotification = var6;
            this.inputMessageContent = var7;
        }

        @Override
        public int getConstructor() {
            return 856399322;
        }
    }

    public static class AddFavoriteSticker extends Function {
        public InputFile sticker;
        public static final int CONSTRUCTOR = 324504799;

        public AddFavoriteSticker() {
        }

        public AddFavoriteSticker(InputFile var1) {
            this.sticker = var1;
        }

        @Override
        public int getConstructor() {
            return 324504799;
        }
    }

    public static class AddCustomServerLanguagePack extends Function {
        public String languagePackId;
        public static final int CONSTRUCTOR = 4492771;

        public AddCustomServerLanguagePack() {
        }

        public AddCustomServerLanguagePack(String var1) {
            this.languagePackId = var1;
        }

        @Override
        public int getConstructor() {
            return 4492771;
        }
    }

    public static class AddContact extends Function {
        public Contact contact;
        public boolean sharePhoneNumber;
        public static final int CONSTRUCTOR = 1869640000;

        public AddContact() {
        }

        public AddContact(Contact var1, boolean var2) {
            this.contact = var1;
            this.sharePhoneNumber = var2;
        }

        @Override
        public int getConstructor() {
            return 1869640000;
        }
    }

    public static class AddChatToList extends Function {
        public long chatId;
        public ChatList chatList;
        public static final int CONSTRUCTOR = -80523595;

        public AddChatToList() {
        }

        public AddChatToList(long var1, ChatList var3) {
            this.chatId = var1;
            this.chatList = var3;
        }

        @Override
        public int getConstructor() {
            return -80523595;
        }
    }

    public static class AddChatMembers extends Function {
        public long chatId;
        public int[] userIds;
        public static final int CONSTRUCTOR = 1234094617;

        public AddChatMembers() {
        }

        public AddChatMembers(long var1, int[] var3) {
            this.chatId = var1;
            this.userIds = var3;
        }

        @Override
        public int getConstructor() {
            return 1234094617;
        }
    }

    public static class AddChatMember extends Function {
        public long chatId;
        public int userId;
        public int forwardLimit;
        public static final int CONSTRUCTOR = 1182817962;

        public AddChatMember() {
        }

        public AddChatMember(long var1, int var3, int var4) {
            this.chatId = var1;
            this.userId = var3;
            this.forwardLimit = var4;
        }

        @Override
        public int getConstructor() {
            return 1182817962;
        }
    }

    public static class AcceptTermsOfService extends Function {
        public String termsOfServiceId;
        public static final int CONSTRUCTOR = 2130576356;

        public AcceptTermsOfService() {
        }

        public AcceptTermsOfService(String var1) {
            this.termsOfServiceId = var1;
        }

        @Override
        public int getConstructor() {
            return 2130576356;
        }
    }

    public static class AcceptCall extends Function {
        public int callId;
        public CallProtocol protocol;
        public static final int CONSTRUCTOR = -646618416;

        public AcceptCall() {
        }

        public AcceptCall(int var1, CallProtocol var2) {
            this.callId = var1;
            this.protocol = var2;
        }

        @Override
        public int getConstructor() {
            return -646618416;
        }
    }

    public static class WebPageInstantView extends Object {
        public PageBlock[] pageBlocks;
        public int viewCount;
        public int version;
        public boolean isRtl;
        public boolean isFull;
        public InternalLinkType feedbackLink;
        public static final int CONSTRUCTOR = 778202453;

        public WebPageInstantView() {
        }

        public WebPageInstantView(PageBlock[] var1, int var2, int var3, boolean var4, boolean var5, InternalLinkType var6) {
            this.pageBlocks = var1;
            this.viewCount = var2;
            this.version = var3;
            this.isRtl = var4;
            this.isFull = var5;
            this.feedbackLink = var6;
        }

        @Override
        public int getConstructor() {
            return 778202453;
        }
    }

    public static class WebPage extends Object {
        public String url;
        public String displayUrl;
        public String type;
        public String siteName;
        public String title;
        public FormattedText description;
        public Photo photo;
        public String embedUrl;
        public String embedType;
        public int embedWidth;
        public int embedHeight;
        public int duration;
        public String author;
        public Animation animation;
        public Audio audio;
        public Document document;
        public Sticker sticker;
        public Video video;
        public VideoNote videoNote;
        public VoiceNote voiceNote;
        public int instantViewVersion;
        public static final int CONSTRUCTOR = -577333714;

        public WebPage() {
        }

        public WebPage(String var1, String var2, String var3, String var4, String var5, FormattedText var6, Photo var7, String var8, String var9, int var10, int var11, int var12, String var13, Animation var14, Audio var15, Document var16, Sticker var17, Video var18, VideoNote var19, VoiceNote var20, int var21) {
            this.url = var1;
            this.displayUrl = var2;
            this.type = var3;
            this.siteName = var4;
            this.title = var5;
            this.description = var6;
            this.photo = var7;
            this.embedUrl = var8;
            this.embedType = var9;
            this.embedWidth = var10;
            this.embedHeight = var11;
            this.duration = var12;
            this.author = var13;
            this.animation = var14;
            this.audio = var15;
            this.document = var16;
            this.sticker = var17;
            this.video = var18;
            this.videoNote = var19;
            this.voiceNote = var20;
            this.instantViewVersion = var21;
        }

        @Override
        public int getConstructor() {
            return -577333714;
        }
    }

    public static class VoiceNote extends Object {
        public int duration;
        public byte[] waveform;
        public String mimeType;
        public File voice;
        public static final int CONSTRUCTOR = -2066012058;

        public VoiceNote() {
        }

        public VoiceNote(int var1, byte[] var2, String var3, File var4) {
            this.duration = var1;
            this.waveform = var2;
            this.mimeType = var3;
            this.voice = var4;
        }

        @Override
        public int getConstructor() {
            return -2066012058;
        }
    }

    public static class VoiceChat extends Object {
        public int groupCallId;
        public boolean hasParticipants;
        public MessageSender defaultParticipantId;
        public static final int CONSTRUCTOR = -254491557;

        public VoiceChat() {
        }

        public VoiceChat(int var1, boolean var2, MessageSender var3) {
            this.groupCallId = var1;
            this.hasParticipants = var2;
            this.defaultParticipantId = var3;
        }

        @Override
        public int getConstructor() {
            return -254491557;
        }
    }

    public static class VideoNote extends Object {
        public int duration;
        public int length;
        public Minithumbnail minithumbnail;
        public Thumbnail thumbnail;
        public File video;
        public static final int CONSTRUCTOR = -71734726;

        public VideoNote() {
        }

        public VideoNote(int var1, int var2, Minithumbnail var3, Thumbnail var4, File var5) {
            this.duration = var1;
            this.length = var2;
            this.minithumbnail = var3;
            this.thumbnail = var4;
            this.video = var5;
        }

        @Override
        public int getConstructor() {
            return -71734726;
        }
    }

    public static class Video extends Object {
        public int duration;
        public int width;
        public int height;
        public String fileName;
        public String mimeType;
        public boolean hasStickers;
        public boolean supportsStreaming;
        public Minithumbnail minithumbnail;
        public Thumbnail thumbnail;
        public File video;
        public static final int CONSTRUCTOR = 832856268;

        public Video() {
        }

        public Video(int var1, int var2, int var3, String var4, String var5, boolean var6, boolean var7, Minithumbnail var8, Thumbnail var9, File var10) {
            this.duration = var1;
            this.width = var2;
            this.height = var3;
            this.fileName = var4;
            this.mimeType = var5;
            this.hasStickers = var6;
            this.supportsStreaming = var7;
            this.minithumbnail = var8;
            this.thumbnail = var9;
            this.video = var10;
        }

        @Override
        public int getConstructor() {
            return 832856268;
        }
    }

    public static class Venue extends Object {
        public Location location;
        public String title;
        public String address;
        public String provider;
        public String id;
        public String type;
        public static final int CONSTRUCTOR = 1070406393;

        public Venue() {
        }

        public Venue(Location var1, String var2, String var3, String var4, String var5, String var6) {
            this.location = var1;
            this.title = var2;
            this.address = var3;
            this.provider = var4;
            this.id = var5;
            this.type = var6;
        }

        @Override
        public int getConstructor() {
            return 1070406393;
        }
    }

    public static class VectorPathCommandCubicBezierCurve extends VectorPathCommand {
        public Point startControlPoint;
        public Point endControlPoint;
        public Point endPoint;
        public static final int CONSTRUCTOR = 1229733434;

        public VectorPathCommandCubicBezierCurve() {
        }

        public VectorPathCommandCubicBezierCurve(Point var1, Point var2, Point var3) {
            this.startControlPoint = var1;
            this.endControlPoint = var2;
            this.endPoint = var3;
        }

        @Override
        public int getConstructor() {
            return 1229733434;
        }
    }

    public static class VectorPathCommandLine extends VectorPathCommand {
        public Point endPoint;
        public static final int CONSTRUCTOR = -614056822;

        public VectorPathCommandLine() {
        }

        public VectorPathCommandLine(Point var1) {
            this.endPoint = var1;
        }

        @Override
        public int getConstructor() {
            return -614056822;
        }
    }

    public abstract static class VectorPathCommand extends Object {
        public VectorPathCommand() {
        }
    }

    public static class ValidatedOrderInfo extends Object {
        public String orderInfoId;
        public ShippingOption[] shippingOptions;
        public static final int CONSTRUCTOR = 1511451484;

        public ValidatedOrderInfo() {
        }

        public ValidatedOrderInfo(String var1, ShippingOption[] var2) {
            this.orderInfoId = var1;
            this.shippingOptions = var2;
        }

        @Override
        public int getConstructor() {
            return 1511451484;
        }
    }

    public static class Users extends Object {
        public int totalCount;
        public int[] userIds;
        public static final int CONSTRUCTOR = 273760088;

        public Users() {
        }

        public Users(int var1, int[] var2) {
            this.totalCount = var1;
            this.userIds = var2;
        }

        @Override
        public int getConstructor() {
            return 273760088;
        }
    }

    public static class UserTypeUnknown extends UserType {
        public static final int CONSTRUCTOR = -724541123;

        public UserTypeUnknown() {
        }

        @Override
        public int getConstructor() {
            return -724541123;
        }
    }

    public static class UserTypeBot extends UserType {
        public boolean canJoinGroups;
        public boolean canReadAllGroupMessages;
        public boolean isInline;
        public String inlineQueryPlaceholder;
        public boolean needLocation;
        public static final int CONSTRUCTOR = 1262387765;

        public UserTypeBot() {
        }

        public UserTypeBot(boolean var1, boolean var2, boolean var3, String var4, boolean var5) {
            this.canJoinGroups = var1;
            this.canReadAllGroupMessages = var2;
            this.isInline = var3;
            this.inlineQueryPlaceholder = var4;
            this.needLocation = var5;
        }

        @Override
        public int getConstructor() {
            return 1262387765;
        }
    }

    public static class UserTypeDeleted extends UserType {
        public static final int CONSTRUCTOR = -1807729372;

        public UserTypeDeleted() {
        }

        @Override
        public int getConstructor() {
            return -1807729372;
        }
    }

    public static class UserTypeRegular extends UserType {
        public static final int CONSTRUCTOR = -598644325;

        public UserTypeRegular() {
        }

        @Override
        public int getConstructor() {
            return -598644325;
        }
    }

    public abstract static class UserType extends Object {
        public UserType() {
        }
    }

    public static class UserStatusLastMonth extends UserStatus {
        public static final int CONSTRUCTOR = 2011940674;

        public UserStatusLastMonth() {
        }

        @Override
        public int getConstructor() {
            return 2011940674;
        }
    }

    public static class UserStatusLastWeek extends UserStatus {
        public static final int CONSTRUCTOR = 129960444;

        public UserStatusLastWeek() {
        }

        @Override
        public int getConstructor() {
            return 129960444;
        }
    }

    public static class UserStatusRecently extends UserStatus {
        public static final int CONSTRUCTOR = -496024847;

        public UserStatusRecently() {
        }

        @Override
        public int getConstructor() {
            return -496024847;
        }
    }

    public static class UserStatusOffline extends UserStatus {
        public int wasOnline;
        public static final int CONSTRUCTOR = -759984891;

        public UserStatusOffline() {
        }

        public UserStatusOffline(int var1) {
            this.wasOnline = var1;
        }

        @Override
        public int getConstructor() {
            return -759984891;
        }
    }

    public static class UserStatusOnline extends UserStatus {
        public int expires;
        public static final int CONSTRUCTOR = -1529460876;

        public UserStatusOnline() {
        }

        public UserStatusOnline(int var1) {
            this.expires = var1;
        }

        @Override
        public int getConstructor() {
            return -1529460876;
        }
    }

    public static class UserStatusEmpty extends UserStatus {
        public static final int CONSTRUCTOR = 164646985;

        public UserStatusEmpty() {
        }

        @Override
        public int getConstructor() {
            return 164646985;
        }
    }

    public abstract static class UserStatus extends Object {
        public UserStatus() {
        }
    }

    public static class UserPrivacySettingRules extends Object {
        public UserPrivacySettingRule[] rules;
        public static final int CONSTRUCTOR = 322477541;

        public UserPrivacySettingRules() {
        }

        public UserPrivacySettingRules(UserPrivacySettingRule[] var1) {
            this.rules = var1;
        }

        @Override
        public int getConstructor() {
            return 322477541;
        }
    }

    public static class UserPrivacySettingRuleRestrictChatMembers extends UserPrivacySettingRule {
        public long[] chatIds;
        public static final int CONSTRUCTOR = 392530897;

        public UserPrivacySettingRuleRestrictChatMembers() {
        }

        public UserPrivacySettingRuleRestrictChatMembers(long[] var1) {
            this.chatIds = var1;
        }

        @Override
        public int getConstructor() {
            return 392530897;
        }
    }

    public static class UserPrivacySettingRuleRestrictUsers extends UserPrivacySettingRule {
        public int[] userIds;
        public static final int CONSTRUCTOR = 2119951802;

        public UserPrivacySettingRuleRestrictUsers() {
        }

        public UserPrivacySettingRuleRestrictUsers(int[] var1) {
            this.userIds = var1;
        }

        @Override
        public int getConstructor() {
            return 2119951802;
        }
    }

    public static class UserPrivacySettingRuleRestrictContacts extends UserPrivacySettingRule {
        public static final int CONSTRUCTOR = 1008389378;

        public UserPrivacySettingRuleRestrictContacts() {
        }

        @Override
        public int getConstructor() {
            return 1008389378;
        }
    }

    public static class UserPrivacySettingRuleRestrictAll extends UserPrivacySettingRule {
        public static final int CONSTRUCTOR = -1406495408;

        public UserPrivacySettingRuleRestrictAll() {
        }

        @Override
        public int getConstructor() {
            return -1406495408;
        }
    }

    public static class UserPrivacySettingRuleAllowChatMembers extends UserPrivacySettingRule {
        public long[] chatIds;
        public static final int CONSTRUCTOR = -2048749863;

        public UserPrivacySettingRuleAllowChatMembers() {
        }

        public UserPrivacySettingRuleAllowChatMembers(long[] var1) {
            this.chatIds = var1;
        }

        @Override
        public int getConstructor() {
            return -2048749863;
        }
    }

    public static class UserPrivacySettingRuleAllowUsers extends UserPrivacySettingRule {
        public int[] userIds;
        public static final int CONSTRUCTOR = 427601278;

        public UserPrivacySettingRuleAllowUsers() {
        }

        public UserPrivacySettingRuleAllowUsers(int[] var1) {
            this.userIds = var1;
        }

        @Override
        public int getConstructor() {
            return 427601278;
        }
    }

    public static class UserPrivacySettingRuleAllowContacts extends UserPrivacySettingRule {
        public static final int CONSTRUCTOR = -1892733680;

        public UserPrivacySettingRuleAllowContacts() {
        }

        @Override
        public int getConstructor() {
            return -1892733680;
        }
    }

    public static class UserPrivacySettingRuleAllowAll extends UserPrivacySettingRule {
        public static final int CONSTRUCTOR = -1967186881;

        public UserPrivacySettingRuleAllowAll() {
        }

        @Override
        public int getConstructor() {
            return -1967186881;
        }
    }

    public abstract static class UserPrivacySettingRule extends Object {
        public UserPrivacySettingRule() {
        }
    }

    public static class UserPrivacySettingAllowFindingByPhoneNumber extends UserPrivacySetting {
        public static final int CONSTRUCTOR = -1846645423;

        public UserPrivacySettingAllowFindingByPhoneNumber() {
        }

        @Override
        public int getConstructor() {
            return -1846645423;
        }
    }

    public static class UserPrivacySettingAllowPeerToPeerCalls extends UserPrivacySetting {
        public static final int CONSTRUCTOR = 352500032;

        public UserPrivacySettingAllowPeerToPeerCalls() {
        }

        @Override
        public int getConstructor() {
            return 352500032;
        }
    }

    public static class UserPrivacySettingAllowCalls extends UserPrivacySetting {
        public static final int CONSTRUCTOR = -906967291;

        public UserPrivacySettingAllowCalls() {
        }

        @Override
        public int getConstructor() {
            return -906967291;
        }
    }

    public static class UserPrivacySettingAllowChatInvites extends UserPrivacySetting {
        public static final int CONSTRUCTOR = 1271668007;

        public UserPrivacySettingAllowChatInvites() {
        }

        @Override
        public int getConstructor() {
            return 1271668007;
        }
    }

    public static class UserPrivacySettingShowPhoneNumber extends UserPrivacySetting {
        public static final int CONSTRUCTOR = -791567831;

        public UserPrivacySettingShowPhoneNumber() {
        }

        @Override
        public int getConstructor() {
            return -791567831;
        }
    }

    public static class UserPrivacySettingShowLinkInForwardedMessages extends UserPrivacySetting {
        public static final int CONSTRUCTOR = 592688870;

        public UserPrivacySettingShowLinkInForwardedMessages() {
        }

        @Override
        public int getConstructor() {
            return 592688870;
        }
    }

    public static class UserPrivacySettingShowProfilePhoto extends UserPrivacySetting {
        public static final int CONSTRUCTOR = 1408485877;

        public UserPrivacySettingShowProfilePhoto() {
        }

        @Override
        public int getConstructor() {
            return 1408485877;
        }
    }

    public static class UserPrivacySettingShowStatus extends UserPrivacySetting {
        public static final int CONSTRUCTOR = 1862829310;

        public UserPrivacySettingShowStatus() {
        }

        @Override
        public int getConstructor() {
            return 1862829310;
        }
    }

    public abstract static class UserPrivacySetting extends Object {
        public UserPrivacySetting() {
        }
    }

    public static class UserFullInfo extends Object {
        public ChatPhoto photo;
        public boolean isBlocked;
        public boolean canBeCalled;
        public boolean supportsVideoCalls;
        public boolean hasPrivateCalls;
        public boolean needPhoneNumberPrivacyException;
        public String bio;
        public String shareText;
        public String description;
        public int groupInCommonCount;
        public BotCommand[] commands;
        public static final int CONSTRUCTOR = -1589269389;

        public UserFullInfo() {
        }

        public UserFullInfo(ChatPhoto var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, String var7, String var8, String var9, int var10, BotCommand[] var11) {
            this.photo = var1;
            this.isBlocked = var2;
            this.canBeCalled = var3;
            this.supportsVideoCalls = var4;
            this.hasPrivateCalls = var5;
            this.needPhoneNumberPrivacyException = var6;
            this.bio = var7;
            this.shareText = var8;
            this.description = var9;
            this.groupInCommonCount = var10;
            this.commands = var11;
        }

        @Override
        public int getConstructor() {
            return -1589269389;
        }
    }

    public static class User extends Object {
        public int id;
        public String firstName;
        public String lastName;
        public String username;
        public String phoneNumber;
        public UserStatus status;
        public ProfilePhoto profilePhoto;
        public boolean isContact;
        public boolean isMutualContact;
        public boolean isVerified;
        public boolean isSupport;
        public String restrictionReason;
        public boolean isScam;
        public boolean isFake;
        public boolean haveAccess;
        public UserType type;
        public String languageCode;
        public static final int CONSTRUCTOR = -740667178;

        public User() {
        }

        public User(int var1, String var2, String var3, String var4, String var5, UserStatus var6, ProfilePhoto var7, boolean var8, boolean var9, boolean var10, boolean var11, String var12, boolean var13, boolean var14, boolean var15, UserType var16, String var17) {
            this.id = var1;
            this.firstName = var2;
            this.lastName = var3;
            this.username = var4;
            this.phoneNumber = var5;
            this.status = var6;
            this.profilePhoto = var7;
            this.isContact = var8;
            this.isMutualContact = var9;
            this.isVerified = var10;
            this.isSupport = var11;
            this.restrictionReason = var12;
            this.isScam = var13;
            this.isFake = var14;
            this.haveAccess = var15;
            this.type = var16;
            this.languageCode = var17;
        }

        @Override
        public int getConstructor() {
            return -740667178;
        }
    }

    public static class Updates extends Object {
        public Update[] updates;
        public static final int CONSTRUCTOR = 475842347;

        public Updates() {
        }

        public Updates(Update[] var1) {
            this.updates = var1;
        }

        @Override
        public int getConstructor() {
            return 475842347;
        }
    }

    public static class UpdateChatMember extends Update {
        public long chatId;
        public int actorUserId;
        public int date;
        public ChatInviteLink inviteLink;
        public ChatMember oldChatMember;
        public ChatMember newChatMember;
        public static final int CONSTRUCTOR = 53431716;

        public UpdateChatMember() {
        }

        public UpdateChatMember(long var1, int var3, int var4, ChatInviteLink var5, ChatMember var6, ChatMember var7) {
            this.chatId = var1;
            this.actorUserId = var3;
            this.date = var4;
            this.inviteLink = var5;
            this.oldChatMember = var6;
            this.newChatMember = var7;
        }

        @Override
        public int getConstructor() {
            return 53431716;
        }
    }

    public static class UpdatePollAnswer extends Update {
        public long pollId;
        public int userId;
        public int[] optionIds;
        public static final int CONSTRUCTOR = 1606139344;

        public UpdatePollAnswer() {
        }

        public UpdatePollAnswer(long var1, int var3, int[] var4) {
            this.pollId = var1;
            this.userId = var3;
            this.optionIds = var4;
        }

        @Override
        public int getConstructor() {
            return 1606139344;
        }
    }

    public static class UpdatePoll extends Update {
        public Poll poll;
        public static final int CONSTRUCTOR = -1771342902;

        public UpdatePoll() {
        }

        public UpdatePoll(Poll var1) {
            this.poll = var1;
        }

        @Override
        public int getConstructor() {
            return -1771342902;
        }
    }

    public static class UpdateNewCustomQuery extends Update {
        public long id;
        public String data;
        public int timeout;
        public static final int CONSTRUCTOR = -687670874;

        public UpdateNewCustomQuery() {
        }

        public UpdateNewCustomQuery(long var1, String var3, int var4) {
            this.id = var1;
            this.data = var3;
            this.timeout = var4;
        }

        @Override
        public int getConstructor() {
            return -687670874;
        }
    }

    public static class UpdateNewCustomEvent extends Update {
        public String event;
        public static final int CONSTRUCTOR = 1994222092;

        public UpdateNewCustomEvent() {
        }

        public UpdateNewCustomEvent(String var1) {
            this.event = var1;
        }

        @Override
        public int getConstructor() {
            return 1994222092;
        }
    }

    public static class UpdateNewPreCheckoutQuery extends Update {
        public long id;
        public int senderUserId;
        public String currency;
        public long totalAmount;
        public byte[] invoicePayload;
        public String shippingOptionId;
        public OrderInfo orderInfo;
        public static final int CONSTRUCTOR = 87964006;

        public UpdateNewPreCheckoutQuery() {
        }

        public UpdateNewPreCheckoutQuery(long var1, int var3, String var4, long var5, byte[] var7, String var8, OrderInfo var9) {
            this.id = var1;
            this.senderUserId = var3;
            this.currency = var4;
            this.totalAmount = var5;
            this.invoicePayload = var7;
            this.shippingOptionId = var8;
            this.orderInfo = var9;
        }

        @Override
        public int getConstructor() {
            return 87964006;
        }
    }

    public static class UpdateNewShippingQuery extends Update {
        public long id;
        public int senderUserId;
        public String invoicePayload;
        public Address shippingAddress;
        public static final int CONSTRUCTOR = -817474682;

        public UpdateNewShippingQuery() {
        }

        public UpdateNewShippingQuery(long var1, int var3, String var4, Address var5) {
            this.id = var1;
            this.senderUserId = var3;
            this.invoicePayload = var4;
            this.shippingAddress = var5;
        }

        @Override
        public int getConstructor() {
            return -817474682;
        }
    }

    public static class UpdateNewInlineCallbackQuery extends Update {
        public long id;
        public int senderUserId;
        public String inlineMessageId;
        public long chatInstance;
        public CallbackQueryPayload payload;
        public static final int CONSTRUCTOR = -1879154829;

        public UpdateNewInlineCallbackQuery() {
        }

        public UpdateNewInlineCallbackQuery(long var1, int var3, String var4, long var5, CallbackQueryPayload var7) {
            this.id = var1;
            this.senderUserId = var3;
            this.inlineMessageId = var4;
            this.chatInstance = var5;
            this.payload = var7;
        }

        @Override
        public int getConstructor() {
            return -1879154829;
        }
    }

    public static class UpdateNewCallbackQuery extends Update {
        public long id;
        public int senderUserId;
        public long chatId;
        public long messageId;
        public long chatInstance;
        public CallbackQueryPayload payload;
        public static final int CONSTRUCTOR = -2044226370;

        public UpdateNewCallbackQuery() {
        }

        public UpdateNewCallbackQuery(long var1, int var3, long var4, long var6, long var8, CallbackQueryPayload var10) {
            this.id = var1;
            this.senderUserId = var3;
            this.chatId = var4;
            this.messageId = var6;
            this.chatInstance = var8;
            this.payload = var10;
        }

        @Override
        public int getConstructor() {
            return -2044226370;
        }
    }

    public static class UpdateNewChosenInlineResult extends Update {
        public int senderUserId;
        public Location userLocation;
        public String query;
        public String resultId;
        public String inlineMessageId;
        public static final int CONSTRUCTOR = 527526965;

        public UpdateNewChosenInlineResult() {
        }

        public UpdateNewChosenInlineResult(int var1, Location var2, String var3, String var4, String var5) {
            this.senderUserId = var1;
            this.userLocation = var2;
            this.query = var3;
            this.resultId = var4;
            this.inlineMessageId = var5;
        }

        @Override
        public int getConstructor() {
            return 527526965;
        }
    }

    public static class UpdateNewInlineQuery extends Update {
        public long id;
        public int senderUserId;
        public Location userLocation;
        public ChatType chatType;
        public String query;
        public String offset;
        public static final int CONSTRUCTOR = 1918474267;

        public UpdateNewInlineQuery() {
        }

        public UpdateNewInlineQuery(long var1, int var3, Location var4, ChatType var5, String var6, String var7) {
            this.id = var1;
            this.senderUserId = var3;
            this.userLocation = var4;
            this.chatType = var5;
            this.query = var6;
            this.offset = var7;
        }

        @Override
        public int getConstructor() {
            return 1918474267;
        }
    }

    public static class UpdateSuggestedActions extends Update {
        public SuggestedAction[] addedActions;
        public SuggestedAction[] removedActions;
        public static final int CONSTRUCTOR = 1459452346;

        public UpdateSuggestedActions() {
        }

        public UpdateSuggestedActions(SuggestedAction[] var1, SuggestedAction[] var2) {
            this.addedActions = var1;
            this.removedActions = var2;
        }

        @Override
        public int getConstructor() {
            return 1459452346;
        }
    }

    public static class UpdateAnimationSearchParameters extends Update {
        public String provider;
        public String[] emojis;
        public static final int CONSTRUCTOR = -1144983202;

        public UpdateAnimationSearchParameters() {
        }

        public UpdateAnimationSearchParameters(String var1, String[] var2) {
            this.provider = var1;
            this.emojis = var2;
        }

        @Override
        public int getConstructor() {
            return -1144983202;
        }
    }

    public static class UpdateDiceEmojis extends Update {
        public String[] emojis;
        public static final int CONSTRUCTOR = -1069066940;

        public UpdateDiceEmojis() {
        }

        public UpdateDiceEmojis(String[] var1) {
            this.emojis = var1;
        }

        @Override
        public int getConstructor() {
            return -1069066940;
        }
    }

    public static class UpdateUsersNearby extends Update {
        public ChatNearby[] usersNearby;
        public static final int CONSTRUCTOR = -1517109163;

        public UpdateUsersNearby() {
        }

        public UpdateUsersNearby(ChatNearby[] var1) {
            this.usersNearby = var1;
        }

        @Override
        public int getConstructor() {
            return -1517109163;
        }
    }

    public static class UpdateTermsOfService extends Update {
        public String termsOfServiceId;
        public TermsOfService termsOfService;
        public static final int CONSTRUCTOR = -1304640162;

        public UpdateTermsOfService() {
        }

        public UpdateTermsOfService(String var1, TermsOfService var2) {
            this.termsOfServiceId = var1;
            this.termsOfService = var2;
        }

        @Override
        public int getConstructor() {
            return -1304640162;
        }
    }

    public static class UpdateConnectionState extends Update {
        public ConnectionState state;
        public static final int CONSTRUCTOR = 1469292078;

        public UpdateConnectionState() {
        }

        public UpdateConnectionState(ConnectionState var1) {
            this.state = var1;
        }

        @Override
        public int getConstructor() {
            return 1469292078;
        }
    }

    public static class UpdateLanguagePackStrings extends Update {
        public String localizationTarget;
        public String languagePackId;
        public LanguagePackString[] strings;
        public static final int CONSTRUCTOR = -1056319886;

        public UpdateLanguagePackStrings() {
        }

        public UpdateLanguagePackStrings(String var1, String var2, LanguagePackString[] var3) {
            this.localizationTarget = var1;
            this.languagePackId = var2;
            this.strings = var3;
        }

        @Override
        public int getConstructor() {
            return -1056319886;
        }
    }

    public static class UpdateChatThemes extends Update {
        public ChatTheme[] chatThemes;
        public static final int CONSTRUCTOR = -1588098376;

        public UpdateChatThemes() {
        }

        public UpdateChatThemes(ChatTheme[] var1) {
            this.chatThemes = var1;
        }

        @Override
        public int getConstructor() {
            return -1588098376;
        }
    }

    public static class UpdateSelectedBackground extends Update {
        public boolean forDarkTheme;
        public Background background;
        public static final int CONSTRUCTOR = -1715658659;

        public UpdateSelectedBackground() {
        }

        public UpdateSelectedBackground(boolean var1, Background var2) {
            this.forDarkTheme = var1;
            this.background = var2;
        }

        @Override
        public int getConstructor() {
            return -1715658659;
        }
    }

    public static class UpdateSavedAnimations extends Update {
        public int[] animationIds;
        public static final int CONSTRUCTOR = 65563814;

        public UpdateSavedAnimations() {
        }

        public UpdateSavedAnimations(int[] var1) {
            this.animationIds = var1;
        }

        @Override
        public int getConstructor() {
            return 65563814;
        }
    }

    public static class UpdateFavoriteStickers extends Update {
        public int[] stickerIds;
        public static final int CONSTRUCTOR = 1662240999;

        public UpdateFavoriteStickers() {
        }

        public UpdateFavoriteStickers(int[] var1) {
            this.stickerIds = var1;
        }

        @Override
        public int getConstructor() {
            return 1662240999;
        }
    }

    public static class UpdateRecentStickers extends Update {
        public boolean isAttached;
        public int[] stickerIds;
        public static final int CONSTRUCTOR = 1906403540;

        public UpdateRecentStickers() {
        }

        public UpdateRecentStickers(boolean var1, int[] var2) {
            this.isAttached = var1;
            this.stickerIds = var2;
        }

        @Override
        public int getConstructor() {
            return 1906403540;
        }
    }

    public static class UpdateTrendingStickerSets extends Update {
        public StickerSets stickerSets;
        public static final int CONSTRUCTOR = 450714593;

        public UpdateTrendingStickerSets() {
        }

        public UpdateTrendingStickerSets(StickerSets var1) {
            this.stickerSets = var1;
        }

        @Override
        public int getConstructor() {
            return 450714593;
        }
    }

    public static class UpdateInstalledStickerSets extends Update {
        public boolean isMasks;
        public long[] stickerSetIds;
        public static final int CONSTRUCTOR = 1125575977;

        public UpdateInstalledStickerSets() {
        }

        public UpdateInstalledStickerSets(boolean var1, long[] var2) {
            this.isMasks = var1;
            this.stickerSetIds = var2;
        }

        @Override
        public int getConstructor() {
            return 1125575977;
        }
    }

    public static class UpdateStickerSet extends Update {
        public StickerSet stickerSet;
        public static final int CONSTRUCTOR = 1879268812;

        public UpdateStickerSet() {
        }

        public UpdateStickerSet(StickerSet var1) {
            this.stickerSet = var1;
        }

        @Override
        public int getConstructor() {
            return 1879268812;
        }
    }

    public static class UpdateOption extends Update {
        public String name;
        public OptionValue value;
        public static final int CONSTRUCTOR = 900822020;

        public UpdateOption() {
        }

        public UpdateOption(String var1, OptionValue var2) {
            this.name = var1;
            this.value = var2;
        }

        @Override
        public int getConstructor() {
            return 900822020;
        }
    }

    public static class UpdateUnreadChatCount extends Update {
        public ChatList chatList;
        public int totalCount;
        public int unreadCount;
        public int unreadUnmutedCount;
        public int markedAsUnreadCount;
        public int markedAsUnreadUnmutedCount;
        public static final int CONSTRUCTOR = 1994494530;

        public UpdateUnreadChatCount() {
        }

        public UpdateUnreadChatCount(ChatList var1, int var2, int var3, int var4, int var5, int var6) {
            this.chatList = var1;
            this.totalCount = var2;
            this.unreadCount = var3;
            this.unreadUnmutedCount = var4;
            this.markedAsUnreadCount = var5;
            this.markedAsUnreadUnmutedCount = var6;
        }

        @Override
        public int getConstructor() {
            return 1994494530;
        }
    }

    public static class UpdateUnreadMessageCount extends Update {
        public ChatList chatList;
        public int unreadCount;
        public int unreadUnmutedCount;
        public static final int CONSTRUCTOR = 78987721;

        public UpdateUnreadMessageCount() {
        }

        public UpdateUnreadMessageCount(ChatList var1, int var2, int var3) {
            this.chatList = var1;
            this.unreadCount = var2;
            this.unreadUnmutedCount = var3;
        }

        @Override
        public int getConstructor() {
            return 78987721;
        }
    }

    public static class UpdateUserPrivacySettingRules extends Update {
        public UserPrivacySetting setting;
        public UserPrivacySettingRules rules;
        public static final int CONSTRUCTOR = -912960778;

        public UpdateUserPrivacySettingRules() {
        }

        public UpdateUserPrivacySettingRules(UserPrivacySetting var1, UserPrivacySettingRules var2) {
            this.setting = var1;
            this.rules = var2;
        }

        @Override
        public int getConstructor() {
            return -912960778;
        }
    }

    public static class UpdateNewCallSignalingData extends Update {
        public int callId;
        public byte[] data;
        public static final int CONSTRUCTOR = 583634317;

        public UpdateNewCallSignalingData() {
        }

        public UpdateNewCallSignalingData(int var1, byte[] var2) {
            this.callId = var1;
            this.data = var2;
        }

        @Override
        public int getConstructor() {
            return 583634317;
        }
    }

    public static class UpdateGroupCallParticipant extends Update {
        public int groupCallId;
        public GroupCallParticipant participant;
        public static final int CONSTRUCTOR = -803128071;

        public UpdateGroupCallParticipant() {
        }

        public UpdateGroupCallParticipant(int var1, GroupCallParticipant var2) {
            this.groupCallId = var1;
            this.participant = var2;
        }

        @Override
        public int getConstructor() {
            return -803128071;
        }
    }

    public static class UpdateGroupCall extends Update {
        public GroupCall groupCall;
        public static final int CONSTRUCTOR = 808603136;

        public UpdateGroupCall() {
        }

        public UpdateGroupCall(GroupCall var1) {
            this.groupCall = var1;
        }

        @Override
        public int getConstructor() {
            return 808603136;
        }
    }

    public static class UpdateCall extends Update {
        public Call call;
        public static final int CONSTRUCTOR = 1337184477;

        public UpdateCall() {
        }

        public UpdateCall(Call var1) {
            this.call = var1;
        }

        @Override
        public int getConstructor() {
            return 1337184477;
        }
    }

    public static class UpdateFileGenerationStop extends Update {
        public long generationId;
        public static final int CONSTRUCTOR = -1894449685;

        public UpdateFileGenerationStop() {
        }

        public UpdateFileGenerationStop(long var1) {
            this.generationId = var1;
        }

        @Override
        public int getConstructor() {
            return -1894449685;
        }
    }

    public static class UpdateFileGenerationStart extends Update {
        public long generationId;
        public String originalPath;
        public String destinationPath;
        public String conversion;
        public static final int CONSTRUCTOR = 216817388;

        public UpdateFileGenerationStart() {
        }

        public UpdateFileGenerationStart(long var1, String var3, String var4, String var5) {
            this.generationId = var1;
            this.originalPath = var3;
            this.destinationPath = var4;
            this.conversion = var5;
        }

        @Override
        public int getConstructor() {
            return 216817388;
        }
    }

    public static class UpdateFile extends Update {
        public File file;
        public static final int CONSTRUCTOR = 114132831;

        public UpdateFile() {
        }

        public UpdateFile(File var1) {
            this.file = var1;
        }

        @Override
        public int getConstructor() {
            return 114132831;
        }
    }

    public static class UpdateServiceNotification extends Update {
        public String type;
        public MessageContent content;
        public static final int CONSTRUCTOR = 1318622637;

        public UpdateServiceNotification() {
        }

        public UpdateServiceNotification(String var1, MessageContent var2) {
            this.type = var1;
            this.content = var2;
        }

        @Override
        public int getConstructor() {
            return 1318622637;
        }
    }

    public static class UpdateSupergroupFullInfo extends Update {
        public int supergroupId;
        public SupergroupFullInfo supergroupFullInfo;
        public static final int CONSTRUCTOR = 1288828758;

        public UpdateSupergroupFullInfo() {
        }

        public UpdateSupergroupFullInfo(int var1, SupergroupFullInfo var2) {
            this.supergroupId = var1;
            this.supergroupFullInfo = var2;
        }

        @Override
        public int getConstructor() {
            return 1288828758;
        }
    }

    public static class UpdateBasicGroupFullInfo extends Update {
        public int basicGroupId;
        public BasicGroupFullInfo basicGroupFullInfo;
        public static final int CONSTRUCTOR = 924030531;

        public UpdateBasicGroupFullInfo() {
        }

        public UpdateBasicGroupFullInfo(int var1, BasicGroupFullInfo var2) {
            this.basicGroupId = var1;
            this.basicGroupFullInfo = var2;
        }

        @Override
        public int getConstructor() {
            return 924030531;
        }
    }

    public static class UpdateUserFullInfo extends Update {
        public int userId;
        public UserFullInfo userFullInfo;
        public static final int CONSTRUCTOR = 222103874;

        public UpdateUserFullInfo() {
        }

        public UpdateUserFullInfo(int var1, UserFullInfo var2) {
            this.userId = var1;
            this.userFullInfo = var2;
        }

        @Override
        public int getConstructor() {
            return 222103874;
        }
    }

    public static class UpdateSecretChat extends Update {
        public SecretChat secretChat;
        public static final int CONSTRUCTOR = -1666903253;

        public UpdateSecretChat() {
        }

        public UpdateSecretChat(SecretChat var1) {
            this.secretChat = var1;
        }

        @Override
        public int getConstructor() {
            return -1666903253;
        }
    }

    public static class UpdateSupergroup extends Update {
        public Supergroup supergroup;
        public static final int CONSTRUCTOR = -76782300;

        public UpdateSupergroup() {
        }

        public UpdateSupergroup(Supergroup var1) {
            this.supergroup = var1;
        }

        @Override
        public int getConstructor() {
            return -76782300;
        }
    }

    public static class UpdateBasicGroup extends Update {
        public BasicGroup basicGroup;
        public static final int CONSTRUCTOR = -1003239581;

        public UpdateBasicGroup() {
        }

        public UpdateBasicGroup(BasicGroup var1) {
            this.basicGroup = var1;
        }

        @Override
        public int getConstructor() {
            return -1003239581;
        }
    }

    public static class UpdateUser extends Update {
        public User user;
        public static final int CONSTRUCTOR = 1183394041;

        public UpdateUser() {
        }

        public UpdateUser(User var1) {
            this.user = var1;
        }

        @Override
        public int getConstructor() {
            return 1183394041;
        }
    }

    public static class UpdateUserStatus extends Update {
        public int userId;
        public UserStatus status;
        public static final int CONSTRUCTOR = -1443545195;

        public UpdateUserStatus() {
        }

        public UpdateUserStatus(int var1, UserStatus var2) {
            this.userId = var1;
            this.status = var2;
        }

        @Override
        public int getConstructor() {
            return -1443545195;
        }
    }

    public static class UpdateUserChatAction extends Update {
        public long chatId;
        public long messageThreadId;
        public int userId;
        public ChatAction action;
        public static final int CONSTRUCTOR = 2066409603;

        public UpdateUserChatAction() {
        }

        public UpdateUserChatAction(long var1, long var3, int var5, ChatAction var6) {
            this.chatId = var1;
            this.messageThreadId = var3;
            this.userId = var5;
            this.action = var6;
        }

        @Override
        public int getConstructor() {
            return 2066409603;
        }
    }

    public static class UpdateDeleteMessages extends Update {
        public long chatId;
        public long[] messageIds;
        public boolean isPermanent;
        public boolean fromCache;
        public static final int CONSTRUCTOR = 1669252686;

        public UpdateDeleteMessages() {
        }

        public UpdateDeleteMessages(long var1, long[] var3, boolean var4, boolean var5) {
            this.chatId = var1;
            this.messageIds = var3;
            this.isPermanent = var4;
            this.fromCache = var5;
        }

        @Override
        public int getConstructor() {
            return 1669252686;
        }
    }

    public static class UpdateHavePendingNotifications extends Update {
        public boolean haveDelayedNotifications;
        public boolean haveUnreceivedNotifications;
        public static final int CONSTRUCTOR = 179233243;

        public UpdateHavePendingNotifications() {
        }

        public UpdateHavePendingNotifications(boolean var1, boolean var2) {
            this.haveDelayedNotifications = var1;
            this.haveUnreceivedNotifications = var2;
        }

        @Override
        public int getConstructor() {
            return 179233243;
        }
    }

    public static class UpdateActiveNotifications extends Update {
        public NotificationGroup[] groups;
        public static final int CONSTRUCTOR = -1306672221;

        public UpdateActiveNotifications() {
        }

        public UpdateActiveNotifications(NotificationGroup[] var1) {
            this.groups = var1;
        }

        @Override
        public int getConstructor() {
            return -1306672221;
        }
    }

    public static class UpdateNotificationGroup extends Update {
        public int notificationGroupId;
        public NotificationGroupType type;
        public long chatId;
        public long notificationSettingsChatId;
        public boolean isSilent;
        public int totalCount;
        public Notification[] addedNotifications;
        public int[] removedNotificationIds;
        public static final int CONSTRUCTOR = -2049005665;

        public UpdateNotificationGroup() {
        }

        public UpdateNotificationGroup(int var1, NotificationGroupType var2, long var3, long var5, boolean var7, int var8, Notification[] var9, int[] var10) {
            this.notificationGroupId = var1;
            this.type = var2;
            this.chatId = var3;
            this.notificationSettingsChatId = var5;
            this.isSilent = var7;
            this.totalCount = var8;
            this.addedNotifications = var9;
            this.removedNotificationIds = var10;
        }

        @Override
        public int getConstructor() {
            return -2049005665;
        }
    }

    public static class UpdateNotification extends Update {
        public int notificationGroupId;
        public Notification notification;
        public static final int CONSTRUCTOR = -1897496876;

        public UpdateNotification() {
        }

        public UpdateNotification(int var1, Notification var2) {
            this.notificationGroupId = var1;
            this.notification = var2;
        }

        @Override
        public int getConstructor() {
            return -1897496876;
        }
    }

    public static class UpdateChatOnlineMemberCount extends Update {
        public long chatId;
        public int onlineMemberCount;
        public static final int CONSTRUCTOR = 487369373;

        public UpdateChatOnlineMemberCount() {
        }

        public UpdateChatOnlineMemberCount(long var1, int var3) {
            this.chatId = var1;
            this.onlineMemberCount = var3;
        }

        @Override
        public int getConstructor() {
            return 487369373;
        }
    }

    public static class UpdateChatFilters extends Update {
        public ChatFilterInfo[] chatFilters;
        public static final int CONSTRUCTOR = -961518713;

        public UpdateChatFilters() {
        }

        public UpdateChatFilters(ChatFilterInfo[] var1) {
            this.chatFilters = var1;
        }

        @Override
        public int getConstructor() {
            return -961518713;
        }
    }

    public static class UpdateChatDraftMessage extends Update {
        public long chatId;
        public DraftMessage draftMessage;
        public ChatPosition[] positions;
        public static final int CONSTRUCTOR = 1455190380;

        public UpdateChatDraftMessage() {
        }

        public UpdateChatDraftMessage(long var1, DraftMessage var3, ChatPosition[] var4) {
            this.chatId = var1;
            this.draftMessage = var3;
            this.positions = var4;
        }

        @Override
        public int getConstructor() {
            return 1455190380;
        }
    }

    public static class UpdateChatReplyMarkup extends Update {
        public long chatId;
        public long replyMarkupMessageId;
        public static final int CONSTRUCTOR = 1309386144;

        public UpdateChatReplyMarkup() {
        }

        public UpdateChatReplyMarkup(long var1, long var3) {
            this.chatId = var1;
            this.replyMarkupMessageId = var3;
        }

        @Override
        public int getConstructor() {
            return 1309386144;
        }
    }

    public static class UpdateChatTheme extends Update {
        public long chatId;
        public String themeName;
        public static final int CONSTRUCTOR = 838063205;

        public UpdateChatTheme() {
        }

        public UpdateChatTheme(long var1, String var3) {
            this.chatId = var1;
            this.themeName = var3;
        }

        @Override
        public int getConstructor() {
            return 838063205;
        }
    }

    public static class UpdateChatActionBar extends Update {
        public long chatId;
        public ChatActionBar actionBar;
        public static final int CONSTRUCTOR = -643671870;

        public UpdateChatActionBar() {
        }

        public UpdateChatActionBar(long var1, ChatActionBar var3) {
            this.chatId = var1;
            this.actionBar = var3;
        }

        @Override
        public int getConstructor() {
            return -643671870;
        }
    }

    public static class UpdateChatMessageTtlSetting extends Update {
        public long chatId;
        public int messageTtlSetting;
        public static final int CONSTRUCTOR = 970801976;

        public UpdateChatMessageTtlSetting() {
        }

        public UpdateChatMessageTtlSetting(long var1, int var3) {
            this.chatId = var1;
            this.messageTtlSetting = var3;
        }

        @Override
        public int getConstructor() {
            return 970801976;
        }
    }

    public static class UpdateScopeNotificationSettings extends Update {
        public NotificationSettingsScope scope;
        public ScopeNotificationSettings notificationSettings;
        public static final int CONSTRUCTOR = -1203975309;

        public UpdateScopeNotificationSettings() {
        }

        public UpdateScopeNotificationSettings(NotificationSettingsScope var1, ScopeNotificationSettings var2) {
            this.scope = var1;
            this.notificationSettings = var2;
        }

        @Override
        public int getConstructor() {
            return -1203975309;
        }
    }

    public static class UpdateChatNotificationSettings extends Update {
        public long chatId;
        public ChatNotificationSettings notificationSettings;
        public static final int CONSTRUCTOR = -803163050;

        public UpdateChatNotificationSettings() {
        }

        public UpdateChatNotificationSettings(long var1, ChatNotificationSettings var3) {
            this.chatId = var1;
            this.notificationSettings = var3;
        }

        @Override
        public int getConstructor() {
            return -803163050;
        }
    }

    public static class UpdateChatUnreadMentionCount extends Update {
        public long chatId;
        public int unreadMentionCount;
        public static final int CONSTRUCTOR = -2131461348;

        public UpdateChatUnreadMentionCount() {
        }

        public UpdateChatUnreadMentionCount(long var1, int var3) {
            this.chatId = var1;
            this.unreadMentionCount = var3;
        }

        @Override
        public int getConstructor() {
            return -2131461348;
        }
    }

    public static class UpdateChatReadOutbox extends Update {
        public long chatId;
        public long lastReadOutboxMessageId;
        public static final int CONSTRUCTOR = 708334213;

        public UpdateChatReadOutbox() {
        }

        public UpdateChatReadOutbox(long var1, long var3) {
            this.chatId = var1;
            this.lastReadOutboxMessageId = var3;
        }

        @Override
        public int getConstructor() {
            return 708334213;
        }
    }

    public static class UpdateChatReadInbox extends Update {
        public long chatId;
        public long lastReadInboxMessageId;
        public int unreadCount;
        public static final int CONSTRUCTOR = -797952281;

        public UpdateChatReadInbox() {
        }

        public UpdateChatReadInbox(long var1, long var3, int var5) {
            this.chatId = var1;
            this.lastReadInboxMessageId = var3;
            this.unreadCount = var5;
        }

        @Override
        public int getConstructor() {
            return -797952281;
        }
    }

    public static class UpdateChatDefaultDisableNotification extends Update {
        public long chatId;
        public boolean defaultDisableNotification;
        public static final int CONSTRUCTOR = 464087707;

        public UpdateChatDefaultDisableNotification() {
        }

        public UpdateChatDefaultDisableNotification(long var1, boolean var3) {
            this.chatId = var1;
            this.defaultDisableNotification = var3;
        }

        @Override
        public int getConstructor() {
            return 464087707;
        }
    }

    public static class UpdateChatVoiceChat extends Update {
        public long chatId;
        public VoiceChat voiceChat;
        public static final int CONSTRUCTOR = -422271433;

        public UpdateChatVoiceChat() {
        }

        public UpdateChatVoiceChat(long var1, VoiceChat var3) {
            this.chatId = var1;
            this.voiceChat = var3;
        }

        @Override
        public int getConstructor() {
            return -422271433;
        }
    }

    public static class UpdateChatHasScheduledMessages extends Update {
        public long chatId;
        public boolean hasScheduledMessages;
        public static final int CONSTRUCTOR = 2064958167;

        public UpdateChatHasScheduledMessages() {
        }

        public UpdateChatHasScheduledMessages(long var1, boolean var3) {
            this.chatId = var1;
            this.hasScheduledMessages = var3;
        }

        @Override
        public int getConstructor() {
            return 2064958167;
        }
    }

    public static class UpdateChatIsBlocked extends Update {
        public long chatId;
        public boolean isBlocked;
        public static final int CONSTRUCTOR = -1998946752;

        public UpdateChatIsBlocked() {
        }

        public UpdateChatIsBlocked(long var1, boolean var3) {
            this.chatId = var1;
            this.isBlocked = var3;
        }

        @Override
        public int getConstructor() {
            return -1998946752;
        }
    }

    public static class UpdateChatIsMarkedAsUnread extends Update {
        public long chatId;
        public boolean isMarkedAsUnread;
        public static final int CONSTRUCTOR = 1468347188;

        public UpdateChatIsMarkedAsUnread() {
        }

        public UpdateChatIsMarkedAsUnread(long var1, boolean var3) {
            this.chatId = var1;
            this.isMarkedAsUnread = var3;
        }

        @Override
        public int getConstructor() {
            return 1468347188;
        }
    }

    public static class UpdateChatPosition extends Update {
        public long chatId;
        public ChatPosition position;
        public static final int CONSTRUCTOR = -8979849;

        public UpdateChatPosition() {
        }

        public UpdateChatPosition(long var1, ChatPosition var3) {
            this.chatId = var1;
            this.position = var3;
        }

        @Override
        public int getConstructor() {
            return -8979849;
        }
    }

    public static class UpdateChatLastMessage extends Update {
        public long chatId;
        public Message lastMessage;
        public ChatPosition[] positions;
        public static final int CONSTRUCTOR = -923244537;

        public UpdateChatLastMessage() {
        }

        public UpdateChatLastMessage(long var1, Message var3, ChatPosition[] var4) {
            this.chatId = var1;
            this.lastMessage = var3;
            this.positions = var4;
        }

        @Override
        public int getConstructor() {
            return -923244537;
        }
    }

    public static class UpdateChatPermissions extends Update {
        public long chatId;
        public ChatPermissions permissions;
        public static final int CONSTRUCTOR = -1622010003;

        public UpdateChatPermissions() {
        }

        public UpdateChatPermissions(long var1, ChatPermissions var3) {
            this.chatId = var1;
            this.permissions = var3;
        }

        @Override
        public int getConstructor() {
            return -1622010003;
        }
    }

    public static class UpdateChatPhoto extends Update {
        public long chatId;
        public ChatPhotoInfo photo;
        public static final int CONSTRUCTOR = -324713921;

        public UpdateChatPhoto() {
        }

        public UpdateChatPhoto(long var1, ChatPhotoInfo var3) {
            this.chatId = var1;
            this.photo = var3;
        }

        @Override
        public int getConstructor() {
            return -324713921;
        }
    }

    public static class UpdateChatTitle extends Update {
        public long chatId;
        public String title;
        public static final int CONSTRUCTOR = -175405660;

        public UpdateChatTitle() {
        }

        public UpdateChatTitle(long var1, String var3) {
            this.chatId = var1;
            this.title = var3;
        }

        @Override
        public int getConstructor() {
            return -175405660;
        }
    }

    public static class UpdateNewChat extends Update {
        public Chat chat;
        public static final int CONSTRUCTOR = 2075757773;

        public UpdateNewChat() {
        }

        public UpdateNewChat(Chat var1) {
            this.chat = var1;
        }

        @Override
        public int getConstructor() {
            return 2075757773;
        }
    }

    public static class UpdateMessageLiveLocationViewed extends Update {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -1308260971;

        public UpdateMessageLiveLocationViewed() {
        }

        public UpdateMessageLiveLocationViewed(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        @Override
        public int getConstructor() {
            return -1308260971;
        }
    }

    public static class UpdateMessageMentionRead extends Update {
        public long chatId;
        public long messageId;
        public int unreadMentionCount;
        public static final int CONSTRUCTOR = -252228282;

        public UpdateMessageMentionRead() {
        }

        public UpdateMessageMentionRead(long var1, long var3, int var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.unreadMentionCount = var5;
        }

        @Override
        public int getConstructor() {
            return -252228282;
        }
    }

    public static class UpdateMessageContentOpened extends Update {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -1520523131;

        public UpdateMessageContentOpened() {
        }

        public UpdateMessageContentOpened(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        @Override
        public int getConstructor() {
            return -1520523131;
        }
    }

    public static class UpdateMessageInteractionInfo extends Update {
        public long chatId;
        public long messageId;
        public MessageInteractionInfo interactionInfo;
        public static final int CONSTRUCTOR = -1417659394;

        public UpdateMessageInteractionInfo() {
        }

        public UpdateMessageInteractionInfo(long var1, long var3, MessageInteractionInfo var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.interactionInfo = var5;
        }

        @Override
        public int getConstructor() {
            return -1417659394;
        }
    }

    public static class UpdateMessageIsPinned extends Update {
        public long chatId;
        public long messageId;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 1102848829;

        public UpdateMessageIsPinned() {
        }

        public UpdateMessageIsPinned(long var1, long var3, boolean var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.isPinned = var5;
        }

        @Override
        public int getConstructor() {
            return 1102848829;
        }
    }

    public static class UpdateMessageEdited extends Update {
        public long chatId;
        public long messageId;
        public int editDate;
        public ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = -559545626;

        public UpdateMessageEdited() {
        }

        public UpdateMessageEdited(long var1, long var3, int var5, ReplyMarkup var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.editDate = var5;
            this.replyMarkup = var6;
        }

        @Override
        public int getConstructor() {
            return -559545626;
        }
    }

    public static class UpdateMessageContent extends Update {
        public long chatId;
        public long messageId;
        public MessageContent newContent;
        public static final int CONSTRUCTOR = 506903332;

        public UpdateMessageContent() {
        }

        public UpdateMessageContent(long var1, long var3, MessageContent var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.newContent = var5;
        }

        @Override
        public int getConstructor() {
            return 506903332;
        }
    }

    public static class UpdateMessageSendFailed extends Update {
        public Message message;
        public long oldMessageId;
        public int errorCode;
        public String errorMessage;
        public static final int CONSTRUCTOR = -1032335779;

        public UpdateMessageSendFailed() {
        }

        public UpdateMessageSendFailed(Message var1, long var2, int var4, String var5) {
            this.message = var1;
            this.oldMessageId = var2;
            this.errorCode = var4;
            this.errorMessage = var5;
        }

        @Override
        public int getConstructor() {
            return -1032335779;
        }
    }

    public static class UpdateMessageSendSucceeded extends Update {
        public Message message;
        public long oldMessageId;
        public static final int CONSTRUCTOR = 1815715197;

        public UpdateMessageSendSucceeded() {
        }

        public UpdateMessageSendSucceeded(Message var1, long var2) {
            this.message = var1;
            this.oldMessageId = var2;
        }

        @Override
        public int getConstructor() {
            return 1815715197;
        }
    }

    public static class UpdateMessageSendAcknowledged extends Update {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = 1302843961;

        public UpdateMessageSendAcknowledged() {
        }

        public UpdateMessageSendAcknowledged(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        @Override
        public int getConstructor() {
            return 1302843961;
        }
    }

    public static class UpdateNewMessage extends Update {
        public Message message;
        public static final int CONSTRUCTOR = -563105266;

        public UpdateNewMessage() {
        }

        public UpdateNewMessage(Message var1) {
            this.message = var1;
        }

        @Override
        public int getConstructor() {
            return -563105266;
        }
    }

    public static class UpdateAuthorizationState extends Update {
        public AuthorizationState authorizationState;
        public static final int CONSTRUCTOR = 1622347490;

        public UpdateAuthorizationState() {
        }

        public UpdateAuthorizationState(AuthorizationState var1) {
            this.authorizationState = var1;
        }

        @Override
        public int getConstructor() {
            return 1622347490;
        }
    }

    public abstract static class Update extends Object {
        public Update() {
        }
    }

    public static class TopChatCategoryForwardChats extends TopChatCategory {
        public static final int CONSTRUCTOR = 1695922133;

        public TopChatCategoryForwardChats() {
        }

        @Override
        public int getConstructor() {
            return 1695922133;
        }
    }

    public static class TopChatCategoryCalls extends TopChatCategory {
        public static final int CONSTRUCTOR = 356208861;

        public TopChatCategoryCalls() {
        }

        @Override
        public int getConstructor() {
            return 356208861;
        }
    }

    public static class TopChatCategoryInlineBots extends TopChatCategory {
        public static final int CONSTRUCTOR = 377023356;

        public TopChatCategoryInlineBots() {
        }

        @Override
        public int getConstructor() {
            return 377023356;
        }
    }

    public static class TopChatCategoryChannels extends TopChatCategory {
        public static final int CONSTRUCTOR = -500825885;

        public TopChatCategoryChannels() {
        }

        @Override
        public int getConstructor() {
            return -500825885;
        }
    }

    public static class TopChatCategoryGroups extends TopChatCategory {
        public static final int CONSTRUCTOR = 1530056846;

        public TopChatCategoryGroups() {
        }

        @Override
        public int getConstructor() {
            return 1530056846;
        }
    }

    public static class TopChatCategoryBots extends TopChatCategory {
        public static final int CONSTRUCTOR = -1577129195;

        public TopChatCategoryBots() {
        }

        @Override
        public int getConstructor() {
            return -1577129195;
        }
    }

    public static class TopChatCategoryUsers extends TopChatCategory {
        public static final int CONSTRUCTOR = 1026706816;

        public TopChatCategoryUsers() {
        }

        @Override
        public int getConstructor() {
            return 1026706816;
        }
    }

    public abstract static class TopChatCategory extends Object {
        public TopChatCategory() {
        }
    }

    public static class ThumbnailFormatMpeg4 extends ThumbnailFormat {
        public static final int CONSTRUCTOR = 278616062;

        public ThumbnailFormatMpeg4() {
        }

        @Override
        public int getConstructor() {
            return 278616062;
        }
    }

    public static class ThumbnailFormatTgs extends ThumbnailFormat {
        public static final int CONSTRUCTOR = 1315522642;

        public ThumbnailFormatTgs() {
        }

        @Override
        public int getConstructor() {
            return 1315522642;
        }
    }

    public static class ThumbnailFormatGif extends ThumbnailFormat {
        public static final int CONSTRUCTOR = 1252205962;

        public ThumbnailFormatGif() {
        }

        @Override
        public int getConstructor() {
            return 1252205962;
        }
    }

    public static class ThumbnailFormatWebp extends ThumbnailFormat {
        public static final int CONSTRUCTOR = -53588974;

        public ThumbnailFormatWebp() {
        }

        @Override
        public int getConstructor() {
            return -53588974;
        }
    }

    public static class ThumbnailFormatPng extends ThumbnailFormat {
        public static final int CONSTRUCTOR = 1577490421;

        public ThumbnailFormatPng() {
        }

        @Override
        public int getConstructor() {
            return 1577490421;
        }
    }

    public static class ThumbnailFormatJpeg extends ThumbnailFormat {
        public static final int CONSTRUCTOR = -653503352;

        public ThumbnailFormatJpeg() {
        }

        @Override
        public int getConstructor() {
            return -653503352;
        }
    }

    public abstract static class ThumbnailFormat extends Object {
        public ThumbnailFormat() {
        }
    }

    public static class Thumbnail extends Object {
        public ThumbnailFormat format;
        public int width;
        public int height;
        public File file;
        public static final int CONSTRUCTOR = 1243275371;

        public Thumbnail() {
        }

        public Thumbnail(ThumbnailFormat var1, int var2, int var3, File var4) {
            this.format = var1;
            this.width = var2;
            this.height = var3;
            this.file = var4;
        }

        @Override
        public int getConstructor() {
            return 1243275371;
        }
    }

    public static class ThemeSettings extends Object {
        public int accentColor;
        public Background background;
        public BackgroundFill messageFill;
        public boolean animateMessageFill;
        public static final int CONSTRUCTOR = -982342100;

        public ThemeSettings() {
        }

        public ThemeSettings(int var1, Background var2, BackgroundFill var3, boolean var4) {
            this.accentColor = var1;
            this.background = var2;
            this.messageFill = var3;
            this.animateMessageFill = var4;
        }

        @Override
        public int getConstructor() {
            return -982342100;
        }
    }

    public static class TextParseModeHTML extends TextParseMode {
        public static final int CONSTRUCTOR = 1660208627;

        public TextParseModeHTML() {
        }

        @Override
        public int getConstructor() {
            return 1660208627;
        }
    }

    public static class TextParseModeMarkdown extends TextParseMode {
        public int version;
        public static final int CONSTRUCTOR = 360073407;

        public TextParseModeMarkdown() {
        }

        public TextParseModeMarkdown(int var1) {
            this.version = var1;
        }

        @Override
        public int getConstructor() {
            return 360073407;
        }
    }

    public abstract static class TextParseMode extends Object {
        public TextParseMode() {
        }
    }

    public static class TextEntityTypeMediaTimestamp extends TextEntityType {
        public int mediaTimestamp;
        public static final int CONSTRUCTOR = -1841898992;

        public TextEntityTypeMediaTimestamp() {
        }

        public TextEntityTypeMediaTimestamp(int var1) {
            this.mediaTimestamp = var1;
        }

        @Override
        public int getConstructor() {
            return -1841898992;
        }
    }

    public static class TextEntityTypeMentionName extends TextEntityType {
        public int userId;
        public static final int CONSTRUCTOR = -791517091;

        public TextEntityTypeMentionName() {
        }

        public TextEntityTypeMentionName(int var1) {
            this.userId = var1;
        }

        @Override
        public int getConstructor() {
            return -791517091;
        }
    }

    public static class TextEntityTypeTextUrl extends TextEntityType {
        public String url;
        public static final int CONSTRUCTOR = 445719651;

        public TextEntityTypeTextUrl() {
        }

        public TextEntityTypeTextUrl(String var1) {
            this.url = var1;
        }

        @Override
        public int getConstructor() {
            return 445719651;
        }
    }

    public static class TextEntityTypePreCode extends TextEntityType {
        public String language;
        public static final int CONSTRUCTOR = -945325397;

        public TextEntityTypePreCode() {
        }

        public TextEntityTypePreCode(String var1) {
            this.language = var1;
        }

        @Override
        public int getConstructor() {
            return -945325397;
        }
    }

    public static class TextEntityTypePre extends TextEntityType {
        public static final int CONSTRUCTOR = 1648958606;

        public TextEntityTypePre() {
        }

        @Override
        public int getConstructor() {
            return 1648958606;
        }
    }

    public static class TextEntityTypeCode extends TextEntityType {
        public static final int CONSTRUCTOR = -974534326;

        public TextEntityTypeCode() {
        }

        @Override
        public int getConstructor() {
            return -974534326;
        }
    }

    public static class TextEntityTypeStrikethrough extends TextEntityType {
        public static final int CONSTRUCTOR = 961529082;

        public TextEntityTypeStrikethrough() {
        }

        @Override
        public int getConstructor() {
            return 961529082;
        }
    }

    public static class TextEntityTypeUnderline extends TextEntityType {
        public static final int CONSTRUCTOR = 792317842;

        public TextEntityTypeUnderline() {
        }

        @Override
        public int getConstructor() {
            return 792317842;
        }
    }

    public static class TextEntityTypeItalic extends TextEntityType {
        public static final int CONSTRUCTOR = -118253987;

        public TextEntityTypeItalic() {
        }

        @Override
        public int getConstructor() {
            return -118253987;
        }
    }

    public static class TextEntityTypeBold extends TextEntityType {
        public static final int CONSTRUCTOR = -1128210000;

        public TextEntityTypeBold() {
        }

        @Override
        public int getConstructor() {
            return -1128210000;
        }
    }

    public static class TextEntityTypeBankCardNumber extends TextEntityType {
        public static final int CONSTRUCTOR = 105986320;

        public TextEntityTypeBankCardNumber() {
        }

        @Override
        public int getConstructor() {
            return 105986320;
        }
    }

    public static class TextEntityTypePhoneNumber extends TextEntityType {
        public static final int CONSTRUCTOR = -1160140246;

        public TextEntityTypePhoneNumber() {
        }

        @Override
        public int getConstructor() {
            return -1160140246;
        }
    }

    public static class TextEntityTypeEmailAddress extends TextEntityType {
        public static final int CONSTRUCTOR = 1425545249;

        public TextEntityTypeEmailAddress() {
        }

        @Override
        public int getConstructor() {
            return 1425545249;
        }
    }

    public static class TextEntityTypeUrl extends TextEntityType {
        public static final int CONSTRUCTOR = -1312762756;

        public TextEntityTypeUrl() {
        }

        @Override
        public int getConstructor() {
            return -1312762756;
        }
    }

    public static class TextEntityTypeBotCommand extends TextEntityType {
        public static final int CONSTRUCTOR = -1150997581;

        public TextEntityTypeBotCommand() {
        }

        @Override
        public int getConstructor() {
            return -1150997581;
        }
    }

    public static class TextEntityTypeCashtag extends TextEntityType {
        public static final int CONSTRUCTOR = 1222915915;

        public TextEntityTypeCashtag() {
        }

        @Override
        public int getConstructor() {
            return 1222915915;
        }
    }

    public static class TextEntityTypeHashtag extends TextEntityType {
        public static final int CONSTRUCTOR = -1023958307;

        public TextEntityTypeHashtag() {
        }

        @Override
        public int getConstructor() {
            return -1023958307;
        }
    }

    public static class TextEntityTypeMention extends TextEntityType {
        public static final int CONSTRUCTOR = 934535013;

        public TextEntityTypeMention() {
        }

        @Override
        public int getConstructor() {
            return 934535013;
        }
    }

    public abstract static class TextEntityType extends Object {
        public TextEntityType() {
        }
    }

    public static class TextEntity extends Object {
        public int offset;
        public int length;
        public TextEntityType type;
        public static final int CONSTRUCTOR = -1951688280;

        public TextEntity() {
        }

        public TextEntity(int var1, int var2, TextEntityType var3) {
            this.offset = var1;
            this.length = var2;
            this.type = var3;
        }

        @Override
        public int getConstructor() {
            return -1951688280;
        }
    }

    public static class TextEntities extends Object {
        public TextEntity[] entities;
        public static final int CONSTRUCTOR = -933199172;

        public TextEntities() {
        }

        public TextEntities(TextEntity[] var1) {
            this.entities = var1;
        }

        @Override
        public int getConstructor() {
            return -933199172;
        }
    }

    public static class Text extends Object {
        public String text;
        public static final int CONSTRUCTOR = 578181272;

        public Text() {
        }

        public Text(String var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return 578181272;
        }
    }

    public static class TestVectorStringObject extends Object {
        public TestString[] value;
        public static final int CONSTRUCTOR = 80780537;

        public TestVectorStringObject() {
        }

        public TestVectorStringObject(TestString[] var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return 80780537;
        }
    }

    public static class TestVectorString extends Object {
        public String[] value;
        public static final int CONSTRUCTOR = 79339995;

        public TestVectorString() {
        }

        public TestVectorString(String[] var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return 79339995;
        }
    }

    public static class TestVectorIntObject extends Object {
        public TestInt[] value;
        public static final int CONSTRUCTOR = 125891546;

        public TestVectorIntObject() {
        }

        public TestVectorIntObject(TestInt[] var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return 125891546;
        }
    }

    public static class TestVectorInt extends Object {
        public int[] value;
        public static final int CONSTRUCTOR = 593682027;

        public TestVectorInt() {
        }

        public TestVectorInt(int[] var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return 593682027;
        }
    }

    public static class TestString extends Object {
        public String value;
        public static final int CONSTRUCTOR = -27891572;

        public TestString() {
        }

        public TestString(String var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return -27891572;
        }
    }

    public static class TestInt extends Object {
        public int value;
        public static final int CONSTRUCTOR = -574804983;

        public TestInt() {
        }

        public TestInt(int var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return -574804983;
        }
    }

    public static class TestBytes extends Object {
        public byte[] value;
        public static final int CONSTRUCTOR = -1541225250;

        public TestBytes() {
        }

        public TestBytes(byte[] var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return -1541225250;
        }
    }

    public static class TermsOfService extends Object {
        public FormattedText text;
        public int minUserAge;
        public boolean showPopup;
        public static final int CONSTRUCTOR = 739422597;

        public TermsOfService() {
        }

        public TermsOfService(FormattedText var1, int var2, boolean var3) {
            this.text = var1;
            this.minUserAge = var2;
            this.showPopup = var3;
        }

        @Override
        public int getConstructor() {
            return 739422597;
        }
    }

    public static class TemporaryPasswordState extends Object {
        public boolean hasPassword;
        public int validFor;
        public static final int CONSTRUCTOR = 939837410;

        public TemporaryPasswordState() {
        }

        public TemporaryPasswordState(boolean var1, int var2) {
            this.hasPassword = var1;
            this.validFor = var2;
        }

        @Override
        public int getConstructor() {
            return 939837410;
        }
    }

    public static class TdlibParameters extends Object {
        public boolean useTestDc;
        public String databaseDirectory;
        public String filesDirectory;
        public boolean useFileDatabase;
        public boolean useChatInfoDatabase;
        public boolean useMessageDatabase;
        public boolean useSecretChats;
        public int apiId;
        public String apiHash;
        public String systemLanguageCode;
        public String deviceModel;
        public String systemVersion;
        public String applicationVersion;
        public boolean enableStorageOptimizer;
        public boolean ignoreFileNames;
        public static final int CONSTRUCTOR = -761520773;

        public TdlibParameters() {
        }

        public TdlibParameters(boolean var1, String var2, String var3, boolean var4, boolean var5, boolean var6, boolean var7, int var8, String var9, String var10, String var11, String var12, String var13, boolean var14, boolean var15) {
            this.useTestDc = var1;
            this.databaseDirectory = var2;
            this.filesDirectory = var3;
            this.useFileDatabase = var4;
            this.useChatInfoDatabase = var5;
            this.useMessageDatabase = var6;
            this.useSecretChats = var7;
            this.apiId = var8;
            this.apiHash = var9;
            this.systemLanguageCode = var10;
            this.deviceModel = var11;
            this.systemVersion = var12;
            this.applicationVersion = var13;
            this.enableStorageOptimizer = var14;
            this.ignoreFileNames = var15;
        }

        @Override
        public int getConstructor() {
            return -761520773;
        }
    }

    public static class TMeUrls extends Object {
        public TMeUrl[] urls;
        public static final int CONSTRUCTOR = -1130595098;

        public TMeUrls() {
        }

        public TMeUrls(TMeUrl[] var1) {
            this.urls = var1;
        }

        @Override
        public int getConstructor() {
            return -1130595098;
        }
    }

    public static class TMeUrlTypeStickerSet extends TMeUrlType {
        public long stickerSetId;
        public static final int CONSTRUCTOR = 1602473196;

        public TMeUrlTypeStickerSet() {
        }

        public TMeUrlTypeStickerSet(long var1) {
            this.stickerSetId = var1;
        }

        @Override
        public int getConstructor() {
            return 1602473196;
        }
    }

    public static class TMeUrlTypeChatInvite extends TMeUrlType {
        public ChatInviteLinkInfo info;
        public static final int CONSTRUCTOR = 313907785;

        public TMeUrlTypeChatInvite() {
        }

        public TMeUrlTypeChatInvite(ChatInviteLinkInfo var1) {
            this.info = var1;
        }

        @Override
        public int getConstructor() {
            return 313907785;
        }
    }

    public static class TMeUrlTypeSupergroup extends TMeUrlType {
        public long supergroupId;
        public static final int CONSTRUCTOR = -1353369944;

        public TMeUrlTypeSupergroup() {
        }

        public TMeUrlTypeSupergroup(long var1) {
            this.supergroupId = var1;
        }

        @Override
        public int getConstructor() {
            return -1353369944;
        }
    }

    public static class TMeUrlTypeUser extends TMeUrlType {
        public int userId;
        public static final int CONSTRUCTOR = -1198700130;

        public TMeUrlTypeUser() {
        }

        public TMeUrlTypeUser(int var1) {
            this.userId = var1;
        }

        @Override
        public int getConstructor() {
            return -1198700130;
        }
    }

    public abstract static class TMeUrlType extends Object {
        public TMeUrlType() {
        }
    }

    public static class TMeUrl extends Object {
        public String url;
        public TMeUrlType type;
        public static final int CONSTRUCTOR = -1140786622;

        public TMeUrl() {
        }

        public TMeUrl(String var1, TMeUrlType var2) {
            this.url = var1;
            this.type = var2;
        }

        @Override
        public int getConstructor() {
            return -1140786622;
        }
    }

    public static class SupergroupMembersFilterBots extends SupergroupMembersFilter {
        public static final int CONSTRUCTOR = 492138918;

        public SupergroupMembersFilterBots() {
        }

        @Override
        public int getConstructor() {
            return 492138918;
        }
    }

    public static class SupergroupMembersFilterMention extends SupergroupMembersFilter {
        public String query;
        public long messageThreadId;
        public static final int CONSTRUCTOR = 947915036;

        public SupergroupMembersFilterMention() {
        }

        public SupergroupMembersFilterMention(String var1, long var2) {
            this.query = var1;
            this.messageThreadId = var2;
        }

        @Override
        public int getConstructor() {
            return 947915036;
        }
    }

    public static class SupergroupMembersFilterBanned extends SupergroupMembersFilter {
        public String query;
        public static final int CONSTRUCTOR = -1210621683;

        public SupergroupMembersFilterBanned() {
        }

        public SupergroupMembersFilterBanned(String var1) {
            this.query = var1;
        }

        @Override
        public int getConstructor() {
            return -1210621683;
        }
    }

    public static class SupergroupMembersFilterRestricted extends SupergroupMembersFilter {
        public String query;
        public static final int CONSTRUCTOR = -1107800034;

        public SupergroupMembersFilterRestricted() {
        }

        public SupergroupMembersFilterRestricted(String var1) {
            this.query = var1;
        }

        @Override
        public int getConstructor() {
            return -1107800034;
        }
    }

    public static class SupergroupMembersFilterSearch extends SupergroupMembersFilter {
        public String query;
        public static final int CONSTRUCTOR = -1696358469;

        public SupergroupMembersFilterSearch() {
        }

        public SupergroupMembersFilterSearch(String var1) {
            this.query = var1;
        }

        @Override
        public int getConstructor() {
            return -1696358469;
        }
    }

    public static class SupergroupMembersFilterAdministrators extends SupergroupMembersFilter {
        public static final int CONSTRUCTOR = -2097380265;

        public SupergroupMembersFilterAdministrators() {
        }

        @Override
        public int getConstructor() {
            return -2097380265;
        }
    }

    public static class SupergroupMembersFilterContacts extends SupergroupMembersFilter {
        public String query;
        public static final int CONSTRUCTOR = -1282910856;

        public SupergroupMembersFilterContacts() {
        }

        public SupergroupMembersFilterContacts(String var1) {
            this.query = var1;
        }

        @Override
        public int getConstructor() {
            return -1282910856;
        }
    }

    public static class SupergroupMembersFilterRecent extends SupergroupMembersFilter {
        public static final int CONSTRUCTOR = 1178199509;

        public SupergroupMembersFilterRecent() {
        }

        @Override
        public int getConstructor() {
            return 1178199509;
        }
    }

    public abstract static class SupergroupMembersFilter extends Object {
        public SupergroupMembersFilter() {
        }
    }

    public static class SupergroupFullInfo extends Object {
        public ChatPhoto photo;
        public String description;
        public int memberCount;
        public int administratorCount;
        public int restrictedCount;
        public int bannedCount;
        public long linkedChatId;
        public int slowModeDelay;
        public double slowModeDelayExpiresIn;
        public boolean canGetMembers;
        public boolean canSetUsername;
        public boolean canSetStickerSet;
        public boolean canSetLocation;
        public boolean canGetStatistics;
        public boolean isAllHistoryAvailable;
        public long stickerSetId;
        public ChatLocation location;
        public ChatInviteLink inviteLink;
        public BotCommands[] botCommands;
        public int upgradedFromBasicGroupId;
        public long upgradedFromMaxMessageId;
        public static final int CONSTRUCTOR = -1089611772;

        public SupergroupFullInfo() {
        }

        public SupergroupFullInfo(ChatPhoto var1, String var2, int var3, int var4, int var5, int var6, long var7, int var9, double var10, boolean var12, boolean var13, boolean var14, boolean var15, boolean var16, boolean var17, long var18, ChatLocation var20, ChatInviteLink var21, BotCommands[] var22, int var23, long var24) {
            this.photo = var1;
            this.description = var2;
            this.memberCount = var3;
            this.administratorCount = var4;
            this.restrictedCount = var5;
            this.bannedCount = var6;
            this.linkedChatId = var7;
            this.slowModeDelay = var9;
            this.slowModeDelayExpiresIn = var10;
            this.canGetMembers = var12;
            this.canSetUsername = var13;
            this.canSetStickerSet = var14;
            this.canSetLocation = var15;
            this.canGetStatistics = var16;
            this.isAllHistoryAvailable = var17;
            this.stickerSetId = var18;
            this.location = var20;
            this.inviteLink = var21;
            this.botCommands = var22;
            this.upgradedFromBasicGroupId = var23;
            this.upgradedFromMaxMessageId = var24;
        }

        @Override
        public int getConstructor() {
            return -1089611772;
        }
    }

    public static class Supergroup extends Object {
        public int id;
        public String username;
        public int date;
        public ChatMemberStatus status;
        public int memberCount;
        public boolean hasLinkedChat;
        public boolean hasLocation;
        public boolean signMessages;
        public boolean isSlowModeEnabled;
        public boolean isChannel;
        public boolean isBroadcastGroup;
        public boolean isVerified;
        public String restrictionReason;
        public boolean isScam;
        public boolean isFake;
        public static final int CONSTRUCTOR = 306349959;

        public Supergroup() {
        }

        public Supergroup(int var1, String var2, int var3, ChatMemberStatus var4, int var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12, String var13, boolean var14, boolean var15) {
            this.id = var1;
            this.username = var2;
            this.date = var3;
            this.status = var4;
            this.memberCount = var5;
            this.hasLinkedChat = var6;
            this.hasLocation = var7;
            this.signMessages = var8;
            this.isSlowModeEnabled = var9;
            this.isChannel = var10;
            this.isBroadcastGroup = var11;
            this.isVerified = var12;
            this.restrictionReason = var13;
            this.isScam = var14;
            this.isFake = var15;
        }

        @Override
        public int getConstructor() {
            return 306349959;
        }
    }

    public static class SuggestedActionConvertToBroadcastGroup extends SuggestedAction {
        public int supergroupId;
        public static final int CONSTRUCTOR = -1782893643;

        public SuggestedActionConvertToBroadcastGroup() {
        }

        public SuggestedActionConvertToBroadcastGroup(int var1) {
            this.supergroupId = var1;
        }

        @Override
        public int getConstructor() {
            return -1782893643;
        }
    }

    public static class SuggestedActionSeeTicksHint extends SuggestedAction {
        public static final int CONSTRUCTOR = 1061871714;

        public SuggestedActionSeeTicksHint() {
        }

        @Override
        public int getConstructor() {
            return 1061871714;
        }
    }

    public static class SuggestedActionCheckPhoneNumber extends SuggestedAction {
        public static final int CONSTRUCTOR = 648771563;

        public SuggestedActionCheckPhoneNumber() {
        }

        @Override
        public int getConstructor() {
            return 648771563;
        }
    }

    public static class SuggestedActionCheckPassword extends SuggestedAction {
        public static final int CONSTRUCTOR = 1910534839;

        public SuggestedActionCheckPassword() {
        }

        @Override
        public int getConstructor() {
            return 1910534839;
        }
    }

    public static class SuggestedActionEnableArchiveAndMuteNewChats extends SuggestedAction {
        public static final int CONSTRUCTOR = 2017586255;

        public SuggestedActionEnableArchiveAndMuteNewChats() {
        }

        @Override
        public int getConstructor() {
            return 2017586255;
        }
    }

    public abstract static class SuggestedAction extends Object {
        public SuggestedAction() {
        }
    }

    public static class StorageStatisticsFast extends Object {
        public long filesSize;
        public int fileCount;
        public long databaseSize;
        public long languagePackDatabaseSize;
        public long logSize;
        public static final int CONSTRUCTOR = -884922271;

        public StorageStatisticsFast() {
        }

        public StorageStatisticsFast(long var1, int var3, long var4, long var6, long var8) {
            this.filesSize = var1;
            this.fileCount = var3;
            this.databaseSize = var4;
            this.languagePackDatabaseSize = var6;
            this.logSize = var8;
        }

        @Override
        public int getConstructor() {
            return -884922271;
        }
    }

    public static class StorageStatisticsByFileType extends Object {
        public FileType fileType;
        public long size;
        public int count;
        public static final int CONSTRUCTOR = 714012840;

        public StorageStatisticsByFileType() {
        }

        public StorageStatisticsByFileType(FileType var1, long var2, int var4) {
            this.fileType = var1;
            this.size = var2;
            this.count = var4;
        }

        @Override
        public int getConstructor() {
            return 714012840;
        }
    }

    public static class StorageStatisticsByChat extends Object {
        public long chatId;
        public long size;
        public int count;
        public StorageStatisticsByFileType[] byFileType;
        public static final int CONSTRUCTOR = 635434531;

        public StorageStatisticsByChat() {
        }

        public StorageStatisticsByChat(long var1, long var3, int var5, StorageStatisticsByFileType[] var6) {
            this.chatId = var1;
            this.size = var3;
            this.count = var5;
            this.byFileType = var6;
        }

        @Override
        public int getConstructor() {
            return 635434531;
        }
    }

    public static class StorageStatistics extends Object {
        public long size;
        public int count;
        public StorageStatisticsByChat[] byChat;
        public static final int CONSTRUCTOR = 217237013;

        public StorageStatistics() {
        }

        public StorageStatistics(long var1, int var3, StorageStatisticsByChat[] var4) {
            this.size = var1;
            this.count = var3;
            this.byChat = var4;
        }

        @Override
        public int getConstructor() {
            return 217237013;
        }
    }

    public static class Stickers extends Object {
        public Sticker[] stickers;
        public static final int CONSTRUCTOR = 1974859260;

        public Stickers() {
        }

        public Stickers(Sticker[] var1) {
            this.stickers = var1;
        }

        @Override
        public int getConstructor() {
            return 1974859260;
        }
    }

    public static class StickerSets extends Object {
        public int totalCount;
        public StickerSetInfo[] sets;
        public static final int CONSTRUCTOR = -1883828812;

        public StickerSets() {
        }

        public StickerSets(int var1, StickerSetInfo[] var2) {
            this.totalCount = var1;
            this.sets = var2;
        }

        @Override
        public int getConstructor() {
            return -1883828812;
        }
    }

    public static class StickerSetInfo extends Object {
        public long id;
        public String title;
        public String name;
        public Thumbnail thumbnail;
        public ClosedVectorPath[] thumbnailOutline;
        public boolean isInstalled;
        public boolean isArchived;
        public boolean isOfficial;
        public boolean isAnimated;
        public boolean isMasks;
        public boolean isViewed;
        public int size;
        public Sticker[] covers;
        public static final int CONSTRUCTOR = 1307322248;

        public StickerSetInfo() {
        }

        public StickerSetInfo(long var1, String var3, String var4, Thumbnail var5, ClosedVectorPath[] var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12, int var13, Sticker[] var14) {
            this.id = var1;
            this.title = var3;
            this.name = var4;
            this.thumbnail = var5;
            this.thumbnailOutline = var6;
            this.isInstalled = var7;
            this.isArchived = var8;
            this.isOfficial = var9;
            this.isAnimated = var10;
            this.isMasks = var11;
            this.isViewed = var12;
            this.size = var13;
            this.covers = var14;
        }

        @Override
        public int getConstructor() {
            return 1307322248;
        }
    }

    public static class StickerSet extends Object {
        public long id;
        public String title;
        public String name;
        public Thumbnail thumbnail;
        public ClosedVectorPath[] thumbnailOutline;
        public boolean isInstalled;
        public boolean isArchived;
        public boolean isOfficial;
        public boolean isAnimated;
        public boolean isMasks;
        public boolean isViewed;
        public Sticker[] stickers;
        public Emojis[] emojis;
        public static final int CONSTRUCTOR = -79542167;

        public StickerSet() {
        }

        public StickerSet(long var1, String var3, String var4, Thumbnail var5, ClosedVectorPath[] var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12, Sticker[] var13, Emojis[] var14) {
            this.id = var1;
            this.title = var3;
            this.name = var4;
            this.thumbnail = var5;
            this.thumbnailOutline = var6;
            this.isInstalled = var7;
            this.isArchived = var8;
            this.isOfficial = var9;
            this.isAnimated = var10;
            this.isMasks = var11;
            this.isViewed = var12;
            this.stickers = var13;
            this.emojis = var14;
        }

        @Override
        public int getConstructor() {
            return -79542167;
        }
    }

    public static class Sticker extends Object {
        public long setId;
        public int width;
        public int height;
        public String emoji;
        public boolean isAnimated;
        public boolean isMask;
        public MaskPosition maskPosition;
        public ClosedVectorPath[] outline;
        public Thumbnail thumbnail;
        public File sticker;
        public static final int CONSTRUCTOR = 45883239;

        public Sticker() {
        }

        public Sticker(long var1, int var3, int var4, String var5, boolean var6, boolean var7, MaskPosition var8, ClosedVectorPath[] var9, Thumbnail var10, File var11) {
            this.setId = var1;
            this.width = var3;
            this.height = var4;
            this.emoji = var5;
            this.isAnimated = var6;
            this.isMask = var7;
            this.maskPosition = var8;
            this.outline = var9;
            this.thumbnail = var10;
            this.sticker = var11;
        }

        @Override
        public int getConstructor() {
            return 45883239;
        }
    }

    public static class StatisticalValue extends Object {
        public double value;
        public double previousValue;
        public double growthRatePercentage;
        public static final int CONSTRUCTOR = 1651337846;

        public StatisticalValue() {
        }

        public StatisticalValue(double var1, double var3, double var5) {
            this.value = var1;
            this.previousValue = var3;
            this.growthRatePercentage = var5;
        }

        @Override
        public int getConstructor() {
            return 1651337846;
        }
    }

    public static class StatisticalGraphError extends StatisticalGraph {
        public String errorMessage;
        public static final int CONSTRUCTOR = -1006788526;

        public StatisticalGraphError() {
        }

        public StatisticalGraphError(String var1) {
            this.errorMessage = var1;
        }

        @Override
        public int getConstructor() {
            return -1006788526;
        }
    }

    public static class StatisticalGraphAsync extends StatisticalGraph {
        public String token;
        public static final int CONSTRUCTOR = 435891103;

        public StatisticalGraphAsync() {
        }

        public StatisticalGraphAsync(String var1) {
            this.token = var1;
        }

        @Override
        public int getConstructor() {
            return 435891103;
        }
    }

    public static class StatisticalGraphData extends StatisticalGraph {
        public String jsonData;
        public String zoomToken;
        public static final int CONSTRUCTOR = -1988940244;

        public StatisticalGraphData() {
        }

        public StatisticalGraphData(String var1, String var2) {
            this.jsonData = var1;
            this.zoomToken = var2;
        }

        @Override
        public int getConstructor() {
            return -1988940244;
        }
    }

    public abstract static class StatisticalGraph extends Object {
        public StatisticalGraph() {
        }
    }

    public static class SponsoredMessages extends Object {
        public SponsoredMessage[] messages;
        public static final int CONSTRUCTOR = -2083804091;

        public SponsoredMessages() {
        }

        public SponsoredMessages(SponsoredMessage[] var1) {
            this.messages = var1;
        }

        @Override
        public int getConstructor() {
            return -2083804091;
        }
    }

    public static class SponsoredMessage extends Object {
        public int id;
        public long sponsorChatId;
        public String startParameter;
        public MessageContent content;
        public static final int CONSTRUCTOR = 1744991778;

        public SponsoredMessage() {
        }

        public SponsoredMessage(int var1, long var2, String var4, MessageContent var5) {
            this.id = var1;
            this.sponsorChatId = var2;
            this.startParameter = var4;
            this.content = var5;
        }

        @Override
        public int getConstructor() {
            return 1744991778;
        }
    }

    public static class ShippingOption extends Object {
        public String id;
        public String title;
        public LabeledPricePart[] priceParts;
        public static final int CONSTRUCTOR = 1425690001;

        public ShippingOption() {
        }

        public ShippingOption(String var1, String var2, LabeledPricePart[] var3) {
            this.id = var1;
            this.title = var2;
            this.priceParts = var3;
        }

        @Override
        public int getConstructor() {
            return 1425690001;
        }
    }

    public static class Sessions extends Object {
        public Session[] sessions;
        public static final int CONSTRUCTOR = -463118121;

        public Sessions() {
        }

        public Sessions(Session[] var1) {
            this.sessions = var1;
        }

        @Override
        public int getConstructor() {
            return -463118121;
        }
    }

    public static class Session extends Object {
        public long id;
        public boolean isCurrent;
        public boolean isPasswordPending;
        public int apiId;
        public String applicationName;
        public String applicationVersion;
        public boolean isOfficialApplication;
        public String deviceModel;
        public String platform;
        public String systemVersion;
        public int logInDate;
        public int lastActiveDate;
        public String ip;
        public String country;
        public String region;
        public static final int CONSTRUCTOR = 1920553176;

        public Session() {
        }

        public Session(long var1, boolean var3, boolean var4, int var5, String var6, String var7, boolean var8, String var9, String var10, String var11, int var12, int var13, String var14, String var15, String var16) {
            this.id = var1;
            this.isCurrent = var3;
            this.isPasswordPending = var4;
            this.apiId = var5;
            this.applicationName = var6;
            this.applicationVersion = var7;
            this.isOfficialApplication = var8;
            this.deviceModel = var9;
            this.platform = var10;
            this.systemVersion = var11;
            this.logInDate = var12;
            this.lastActiveDate = var13;
            this.ip = var14;
            this.country = var15;
            this.region = var16;
        }

        @Override
        public int getConstructor() {
            return 1920553176;
        }
    }

    public static class SecretChatStateClosed extends SecretChatState {
        public static final int CONSTRUCTOR = -1945106707;

        public SecretChatStateClosed() {
        }

        @Override
        public int getConstructor() {
            return -1945106707;
        }
    }

    public static class SecretChatStateReady extends SecretChatState {
        public static final int CONSTRUCTOR = -1611352087;

        public SecretChatStateReady() {
        }

        @Override
        public int getConstructor() {
            return -1611352087;
        }
    }

    public static class SecretChatStatePending extends SecretChatState {
        public static final int CONSTRUCTOR = -1637050756;

        public SecretChatStatePending() {
        }

        @Override
        public int getConstructor() {
            return -1637050756;
        }
    }

    public abstract static class SecretChatState extends Object {
        public SecretChatState() {
        }
    }

    public static class SecretChat extends Object {
        public int id;
        public int userId;
        public SecretChatState state;
        public boolean isOutbound;
        public byte[] keyHash;
        public int layer;
        public static final int CONSTRUCTOR = 2088050357;

        public SecretChat() {
        }

        public SecretChat(int var1, int var2, SecretChatState var3, boolean var4, byte[] var5, int var6) {
            this.id = var1;
            this.userId = var2;
            this.state = var3;
            this.isOutbound = var4;
            this.keyHash = var5;
            this.layer = var6;
        }

        @Override
        public int getConstructor() {
            return 2088050357;
        }
    }

    public static class Seconds extends Object {
        public double seconds;
        public static final int CONSTRUCTOR = 959899022;

        public Seconds() {
        }

        public Seconds(double var1) {
            this.seconds = var1;
        }

        @Override
        public int getConstructor() {
            return 959899022;
        }
    }

    public static class SearchMessagesFilterPinned extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 371805512;

        public SearchMessagesFilterPinned() {
        }

        @Override
        public int getConstructor() {
            return 371805512;
        }
    }

    public static class SearchMessagesFilterFailedToSend extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = -596322564;

        public SearchMessagesFilterFailedToSend() {
        }

        @Override
        public int getConstructor() {
            return -596322564;
        }
    }

    public static class SearchMessagesFilterUnreadMention extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = -95769149;

        public SearchMessagesFilterUnreadMention() {
        }

        @Override
        public int getConstructor() {
            return -95769149;
        }
    }

    public static class SearchMessagesFilterMention extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 2001258652;

        public SearchMessagesFilterMention() {
        }

        @Override
        public int getConstructor() {
            return 2001258652;
        }
    }

    public static class SearchMessagesFilterVoiceAndVideoNote extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 664174819;

        public SearchMessagesFilterVoiceAndVideoNote() {
        }

        @Override
        public int getConstructor() {
            return 664174819;
        }
    }

    public static class SearchMessagesFilterVideoNote extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 564323321;

        public SearchMessagesFilterVideoNote() {
        }

        @Override
        public int getConstructor() {
            return 564323321;
        }
    }

    public static class SearchMessagesFilterMissedCall extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 970663098;

        public SearchMessagesFilterMissedCall() {
        }

        @Override
        public int getConstructor() {
            return 970663098;
        }
    }

    public static class SearchMessagesFilterCall extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 1305231012;

        public SearchMessagesFilterCall() {
        }

        @Override
        public int getConstructor() {
            return 1305231012;
        }
    }

    public static class SearchMessagesFilterChatPhoto extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = -1247751329;

        public SearchMessagesFilterChatPhoto() {
        }

        @Override
        public int getConstructor() {
            return -1247751329;
        }
    }

    public static class SearchMessagesFilterUrl extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = -1828724341;

        public SearchMessagesFilterUrl() {
        }

        @Override
        public int getConstructor() {
            return -1828724341;
        }
    }

    public static class SearchMessagesFilterPhotoAndVideo extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 1352130963;

        public SearchMessagesFilterPhotoAndVideo() {
        }

        @Override
        public int getConstructor() {
            return 1352130963;
        }
    }

    public static class SearchMessagesFilterVoiceNote extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 1841439357;

        public SearchMessagesFilterVoiceNote() {
        }

        @Override
        public int getConstructor() {
            return 1841439357;
        }
    }

    public static class SearchMessagesFilterVideo extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 115538222;

        public SearchMessagesFilterVideo() {
        }

        @Override
        public int getConstructor() {
            return 115538222;
        }
    }

    public static class SearchMessagesFilterPhoto extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 925932293;

        public SearchMessagesFilterPhoto() {
        }

        @Override
        public int getConstructor() {
            return 925932293;
        }
    }

    public static class SearchMessagesFilterDocument extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 1526331215;

        public SearchMessagesFilterDocument() {
        }

        @Override
        public int getConstructor() {
            return 1526331215;
        }
    }

    public static class SearchMessagesFilterAudio extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = 867505275;

        public SearchMessagesFilterAudio() {
        }

        @Override
        public int getConstructor() {
            return 867505275;
        }
    }

    public static class SearchMessagesFilterAnimation extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = -155713339;

        public SearchMessagesFilterAnimation() {
        }

        @Override
        public int getConstructor() {
            return -155713339;
        }
    }

    public static class SearchMessagesFilterEmpty extends SearchMessagesFilter {
        public static final int CONSTRUCTOR = -869395657;

        public SearchMessagesFilterEmpty() {
        }

        @Override
        public int getConstructor() {
            return -869395657;
        }
    }

    public abstract static class SearchMessagesFilter extends Object {
        public SearchMessagesFilter() {
        }
    }

    public static class ScopeNotificationSettings extends Object {
        public int muteFor;
        public String sound;
        public boolean showPreview;
        public boolean disablePinnedMessageNotifications;
        public boolean disableMentionNotifications;
        public static final int CONSTRUCTOR = -426103745;

        public ScopeNotificationSettings() {
        }

        public ScopeNotificationSettings(int var1, String var2, boolean var3, boolean var4, boolean var5) {
            this.muteFor = var1;
            this.sound = var2;
            this.showPreview = var3;
            this.disablePinnedMessageNotifications = var4;
            this.disableMentionNotifications = var5;
        }

        @Override
        public int getConstructor() {
            return -426103745;
        }
    }

    public static class SavedCredentials extends Object {
        public String id;
        public String title;
        public static final int CONSTRUCTOR = -370273060;

        public SavedCredentials() {
        }

        public SavedCredentials(String var1, String var2) {
            this.id = var1;
            this.title = var2;
        }

        @Override
        public int getConstructor() {
            return -370273060;
        }
    }

    public static class RichTexts extends RichText {
        public RichText[] texts;
        public static final int CONSTRUCTOR = 1647457821;

        public RichTexts() {
        }

        public RichTexts(RichText[] var1) {
            this.texts = var1;
        }

        @Override
        public int getConstructor() {
            return 1647457821;
        }
    }

    public static class RichTextAnchorLink extends RichText {
        public RichText text;
        public String anchorName;
        public String url;
        public static final int CONSTRUCTOR = -1541418282;

        public RichTextAnchorLink() {
        }

        public RichTextAnchorLink(RichText var1, String var2, String var3) {
            this.text = var1;
            this.anchorName = var2;
            this.url = var3;
        }

        @Override
        public int getConstructor() {
            return -1541418282;
        }
    }

    public static class RichTextAnchor extends RichText {
        public String name;
        public static final int CONSTRUCTOR = 1316950068;

        public RichTextAnchor() {
        }

        public RichTextAnchor(String var1) {
            this.name = var1;
        }

        @Override
        public int getConstructor() {
            return 1316950068;
        }
    }

    public static class RichTextReference extends RichText {
        public RichText text;
        public String anchorName;
        public String url;
        public static final int CONSTRUCTOR = -1147530634;

        public RichTextReference() {
        }

        public RichTextReference(RichText var1, String var2, String var3) {
            this.text = var1;
            this.anchorName = var2;
            this.url = var3;
        }

        @Override
        public int getConstructor() {
            return -1147530634;
        }
    }

    public static class RichTextIcon extends RichText {
        public Document document;
        public int width;
        public int height;
        public static final int CONSTRUCTOR = -1480316158;

        public RichTextIcon() {
        }

        public RichTextIcon(Document var1, int var2, int var3) {
            this.document = var1;
            this.width = var2;
            this.height = var3;
        }

        @Override
        public int getConstructor() {
            return -1480316158;
        }
    }

    public static class RichTextPhoneNumber extends RichText {
        public RichText text;
        public String phoneNumber;
        public static final int CONSTRUCTOR = 128521539;

        public RichTextPhoneNumber() {
        }

        public RichTextPhoneNumber(RichText var1, String var2) {
            this.text = var1;
            this.phoneNumber = var2;
        }

        @Override
        public int getConstructor() {
            return 128521539;
        }
    }

    public static class RichTextMarked extends RichText {
        public RichText text;
        public static final int CONSTRUCTOR = -1271999614;

        public RichTextMarked() {
        }

        public RichTextMarked(RichText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return -1271999614;
        }
    }

    public static class RichTextSuperscript extends RichText {
        public RichText text;
        public static final int CONSTRUCTOR = -382241437;

        public RichTextSuperscript() {
        }

        public RichTextSuperscript(RichText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return -382241437;
        }
    }

    public static class RichTextSubscript extends RichText {
        public RichText text;
        public static final int CONSTRUCTOR = -868197812;

        public RichTextSubscript() {
        }

        public RichTextSubscript(RichText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return -868197812;
        }
    }

    public static class RichTextEmailAddress extends RichText {
        public RichText text;
        public String emailAddress;
        public static final int CONSTRUCTOR = 40018679;

        public RichTextEmailAddress() {
        }

        public RichTextEmailAddress(RichText var1, String var2) {
            this.text = var1;
            this.emailAddress = var2;
        }

        @Override
        public int getConstructor() {
            return 40018679;
        }
    }

    public static class RichTextUrl extends RichText {
        public RichText text;
        public String url;
        public boolean isCached;
        public static final int CONSTRUCTOR = 83939092;

        public RichTextUrl() {
        }

        public RichTextUrl(RichText var1, String var2, boolean var3) {
            this.text = var1;
            this.url = var2;
            this.isCached = var3;
        }

        @Override
        public int getConstructor() {
            return 83939092;
        }
    }

    public static class RichTextFixed extends RichText {
        public RichText text;
        public static final int CONSTRUCTOR = -1271496249;

        public RichTextFixed() {
        }

        public RichTextFixed(RichText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return -1271496249;
        }
    }

    public static class RichTextStrikethrough extends RichText {
        public RichText text;
        public static final int CONSTRUCTOR = 723413585;

        public RichTextStrikethrough() {
        }

        public RichTextStrikethrough(RichText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return 723413585;
        }
    }

    public static class RichTextUnderline extends RichText {
        public RichText text;
        public static final int CONSTRUCTOR = -536019572;

        public RichTextUnderline() {
        }

        public RichTextUnderline(RichText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return -536019572;
        }
    }

    public static class RichTextItalic extends RichText {
        public RichText text;
        public static final int CONSTRUCTOR = 1853354047;

        public RichTextItalic() {
        }

        public RichTextItalic(RichText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return 1853354047;
        }
    }

    public static class RichTextBold extends RichText {
        public RichText text;
        public static final int CONSTRUCTOR = 1670844268;

        public RichTextBold() {
        }

        public RichTextBold(RichText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return 1670844268;
        }
    }

    public static class RichTextPlain extends RichText {
        public String text;
        public static final int CONSTRUCTOR = 482617702;

        public RichTextPlain() {
        }

        public RichTextPlain(String var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return 482617702;
        }
    }

    public abstract static class RichText extends Object {
        public RichText() {
        }
    }

    public static class ResetPasswordResultDeclined extends ResetPasswordResult {
        public int retryDate;
        public static final int CONSTRUCTOR = -1202200373;

        public ResetPasswordResultDeclined() {
        }

        public ResetPasswordResultDeclined(int var1) {
            this.retryDate = var1;
        }

        @Override
        public int getConstructor() {
            return -1202200373;
        }
    }

    public static class ResetPasswordResultPending extends ResetPasswordResult {
        public int pendingResetDate;
        public static final int CONSTRUCTOR = 1193925721;

        public ResetPasswordResultPending() {
        }

        public ResetPasswordResultPending(int var1) {
            this.pendingResetDate = var1;
        }

        @Override
        public int getConstructor() {
            return 1193925721;
        }
    }

    public static class ResetPasswordResultOk extends ResetPasswordResult {
        public static final int CONSTRUCTOR = -1397267463;

        public ResetPasswordResultOk() {
        }

        @Override
        public int getConstructor() {
            return -1397267463;
        }
    }

    public abstract static class ResetPasswordResult extends Object {
        public ResetPasswordResult() {
        }
    }

    public static class ReplyMarkupInlineKeyboard extends ReplyMarkup {
        public InlineKeyboardButton[][] rows;
        public static final int CONSTRUCTOR = -619317658;

        public ReplyMarkupInlineKeyboard() {
        }

        public ReplyMarkupInlineKeyboard(InlineKeyboardButton[][] var1) {
            this.rows = var1;
        }

        @Override
        public int getConstructor() {
            return -619317658;
        }
    }

    public static class ReplyMarkupShowKeyboard extends ReplyMarkup {
        public KeyboardButton[][] rows;
        public boolean resizeKeyboard;
        public boolean oneTime;
        public boolean isPersonal;
        public String inputFieldPlaceholder;
        public static final int CONSTRUCTOR = -64985802;

        public ReplyMarkupShowKeyboard() {
        }

        public ReplyMarkupShowKeyboard(KeyboardButton[][] var1, boolean var2, boolean var3, boolean var4, String var5) {
            this.rows = var1;
            this.resizeKeyboard = var2;
            this.oneTime = var3;
            this.isPersonal = var4;
            this.inputFieldPlaceholder = var5;
        }

        @Override
        public int getConstructor() {
            return -64985802;
        }
    }

    public static class ReplyMarkupForceReply extends ReplyMarkup {
        public boolean isPersonal;
        public String inputFieldPlaceholder;
        public static final int CONSTRUCTOR = 1101461919;

        public ReplyMarkupForceReply() {
        }

        public ReplyMarkupForceReply(boolean var1, String var2) {
            this.isPersonal = var1;
            this.inputFieldPlaceholder = var2;
        }

        @Override
        public int getConstructor() {
            return 1101461919;
        }
    }

    public static class ReplyMarkupRemoveKeyboard extends ReplyMarkup {
        public boolean isPersonal;
        public static final int CONSTRUCTOR = -691252879;

        public ReplyMarkupRemoveKeyboard() {
        }

        public ReplyMarkupRemoveKeyboard(boolean var1) {
            this.isPersonal = var1;
        }

        @Override
        public int getConstructor() {
            return -691252879;
        }
    }

    public abstract static class ReplyMarkup extends Object {
        public ReplyMarkup() {
        }
    }

    public static class RemoteFile extends Object {
        public String id;
        public String uniqueId;
        public boolean isUploadingActive;
        public boolean isUploadingCompleted;
        public int uploadedSize;
        public static final int CONSTRUCTOR = -1822143022;

        public RemoteFile() {
        }

        public RemoteFile(String var1, String var2, boolean var3, boolean var4, int var5) {
            this.id = var1;
            this.uniqueId = var2;
            this.isUploadingActive = var3;
            this.isUploadingCompleted = var4;
            this.uploadedSize = var5;
        }

        @Override
        public int getConstructor() {
            return -1822143022;
        }
    }

    public static class RecoveryEmailAddress extends Object {
        public String recoveryEmailAddress;
        public static final int CONSTRUCTOR = 1290526187;

        public RecoveryEmailAddress() {
        }

        public RecoveryEmailAddress(String var1) {
            this.recoveryEmailAddress = var1;
        }

        @Override
        public int getConstructor() {
            return 1290526187;
        }
    }

    public static class RecommendedChatFilters extends Object {
        public RecommendedChatFilter[] chatFilters;
        public static final int CONSTRUCTOR = -263416880;

        public RecommendedChatFilters() {
        }

        public RecommendedChatFilters(RecommendedChatFilter[] var1) {
            this.chatFilters = var1;
        }

        @Override
        public int getConstructor() {
            return -263416880;
        }
    }

    public static class RecommendedChatFilter extends Object {
        public ChatFilter filter;
        public String description;
        public static final int CONSTRUCTOR = 36048610;

        public RecommendedChatFilter() {
        }

        public RecommendedChatFilter(ChatFilter var1, String var2) {
            this.filter = var1;
            this.description = var2;
        }

        @Override
        public int getConstructor() {
            return 36048610;
        }
    }

    public static class PushReceiverId extends Object {
        public long id;
        public static final int CONSTRUCTOR = 371056428;

        public PushReceiverId() {
        }

        public PushReceiverId(long var1) {
            this.id = var1;
        }

        @Override
        public int getConstructor() {
            return 371056428;
        }
    }

    public static class PushMessageContentMediaAlbum extends PushMessageContent {
        public int totalCount;
        public boolean hasPhotos;
        public boolean hasVideos;
        public boolean hasAudios;
        public boolean hasDocuments;
        public static final int CONSTRUCTOR = -748426897;

        public PushMessageContentMediaAlbum() {
        }

        public PushMessageContentMediaAlbum(int var1, boolean var2, boolean var3, boolean var4, boolean var5) {
            this.totalCount = var1;
            this.hasPhotos = var2;
            this.hasVideos = var3;
            this.hasAudios = var4;
            this.hasDocuments = var5;
        }

        @Override
        public int getConstructor() {
            return -748426897;
        }
    }

    public static class PushMessageContentMessageForwards extends PushMessageContent {
        public int totalCount;
        public static final int CONSTRUCTOR = -1913083876;

        public PushMessageContentMessageForwards() {
        }

        public PushMessageContentMessageForwards(int var1) {
            this.totalCount = var1;
        }

        @Override
        public int getConstructor() {
            return -1913083876;
        }
    }

    public static class PushMessageContentChatJoinByLink extends PushMessageContent {
        public static final int CONSTRUCTOR = 1553719113;

        public PushMessageContentChatJoinByLink() {
        }

        @Override
        public int getConstructor() {
            return 1553719113;
        }
    }

    public static class PushMessageContentChatDeleteMember extends PushMessageContent {
        public String memberName;
        public boolean isCurrentUser;
        public boolean isLeft;
        public static final int CONSTRUCTOR = 598714783;

        public PushMessageContentChatDeleteMember() {
        }

        public PushMessageContentChatDeleteMember(String var1, boolean var2, boolean var3) {
            this.memberName = var1;
            this.isCurrentUser = var2;
            this.isLeft = var3;
        }

        @Override
        public int getConstructor() {
            return 598714783;
        }
    }

    public static class PushMessageContentChatChangeTheme extends PushMessageContent {
        public String themeName;
        public static final int CONSTRUCTOR = -1442786097;

        public PushMessageContentChatChangeTheme() {
        }

        public PushMessageContentChatChangeTheme(String var1) {
            this.themeName = var1;
        }

        @Override
        public int getConstructor() {
            return -1442786097;
        }
    }

    public static class PushMessageContentChatChangeTitle extends PushMessageContent {
        public String title;
        public static final int CONSTRUCTOR = -1964902749;

        public PushMessageContentChatChangeTitle() {
        }

        public PushMessageContentChatChangeTitle(String var1) {
            this.title = var1;
        }

        @Override
        public int getConstructor() {
            return -1964902749;
        }
    }

    public static class PushMessageContentChatChangePhoto extends PushMessageContent {
        public static final int CONSTRUCTOR = -1114222051;

        public PushMessageContentChatChangePhoto() {
        }

        @Override
        public int getConstructor() {
            return -1114222051;
        }
    }

    public static class PushMessageContentChatAddMembers extends PushMessageContent {
        public String memberName;
        public boolean isCurrentUser;
        public boolean isReturned;
        public static final int CONSTRUCTOR = -1087145158;

        public PushMessageContentChatAddMembers() {
        }

        public PushMessageContentChatAddMembers(String var1, boolean var2, boolean var3) {
            this.memberName = var1;
            this.isCurrentUser = var2;
            this.isReturned = var3;
        }

        @Override
        public int getConstructor() {
            return -1087145158;
        }
    }

    public static class PushMessageContentBasicGroupChatCreate extends PushMessageContent {
        public static final int CONSTRUCTOR = -2114855172;

        public PushMessageContentBasicGroupChatCreate() {
        }

        @Override
        public int getConstructor() {
            return -2114855172;
        }
    }

    public static class PushMessageContentVoiceNote extends PushMessageContent {
        public VoiceNote voiceNote;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 88910987;

        public PushMessageContentVoiceNote() {
        }

        public PushMessageContentVoiceNote(VoiceNote var1, boolean var2) {
            this.voiceNote = var1;
            this.isPinned = var2;
        }

        @Override
        public int getConstructor() {
            return 88910987;
        }
    }

    public static class PushMessageContentVideoNote extends PushMessageContent {
        public VideoNote videoNote;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -1122764417;

        public PushMessageContentVideoNote() {
        }

        public PushMessageContentVideoNote(VideoNote var1, boolean var2) {
            this.videoNote = var1;
            this.isPinned = var2;
        }

        @Override
        public int getConstructor() {
            return -1122764417;
        }
    }

    public static class PushMessageContentVideo extends PushMessageContent {
        public Video video;
        public String caption;
        public boolean isSecret;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 310038831;

        public PushMessageContentVideo() {
        }

        public PushMessageContentVideo(Video var1, String var2, boolean var3, boolean var4) {
            this.video = var1;
            this.caption = var2;
            this.isSecret = var3;
            this.isPinned = var4;
        }

        @Override
        public int getConstructor() {
            return 310038831;
        }
    }

    public static class PushMessageContentText extends PushMessageContent {
        public String text;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 274587305;

        public PushMessageContentText() {
        }

        public PushMessageContentText(String var1, boolean var2) {
            this.text = var1;
            this.isPinned = var2;
        }

        @Override
        public int getConstructor() {
            return 274587305;
        }
    }

    public static class PushMessageContentSticker extends PushMessageContent {
        public Sticker sticker;
        public String emoji;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 1553513939;

        public PushMessageContentSticker() {
        }

        public PushMessageContentSticker(Sticker var1, String var2, boolean var3) {
            this.sticker = var1;
            this.emoji = var2;
            this.isPinned = var3;
        }

        @Override
        public int getConstructor() {
            return 1553513939;
        }
    }

    public static class PushMessageContentScreenshotTaken extends PushMessageContent {
        public static final int CONSTRUCTOR = 214245369;

        public PushMessageContentScreenshotTaken() {
        }

        @Override
        public int getConstructor() {
            return 214245369;
        }
    }

    public static class PushMessageContentPoll extends PushMessageContent {
        public String question;
        public boolean isRegular;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -44403654;

        public PushMessageContentPoll() {
        }

        public PushMessageContentPoll(String var1, boolean var2, boolean var3) {
            this.question = var1;
            this.isRegular = var2;
            this.isPinned = var3;
        }

        @Override
        public int getConstructor() {
            return -44403654;
        }
    }

    public static class PushMessageContentPhoto extends PushMessageContent {
        public Photo photo;
        public String caption;
        public boolean isSecret;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 140631122;

        public PushMessageContentPhoto() {
        }

        public PushMessageContentPhoto(Photo var1, String var2, boolean var3, boolean var4) {
            this.photo = var1;
            this.caption = var2;
            this.isSecret = var3;
            this.isPinned = var4;
        }

        @Override
        public int getConstructor() {
            return 140631122;
        }
    }

    public static class PushMessageContentLocation extends PushMessageContent {
        public boolean isLive;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -1288005709;

        public PushMessageContentLocation() {
        }

        public PushMessageContentLocation(boolean var1, boolean var2) {
            this.isLive = var1;
            this.isPinned = var2;
        }

        @Override
        public int getConstructor() {
            return -1288005709;
        }
    }

    public static class PushMessageContentInvoice extends PushMessageContent {
        public String price;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -1731687492;

        public PushMessageContentInvoice() {
        }

        public PushMessageContentInvoice(String var1, boolean var2) {
            this.price = var1;
            this.isPinned = var2;
        }

        @Override
        public int getConstructor() {
            return -1731687492;
        }
    }

    public static class PushMessageContentGameScore extends PushMessageContent {
        public String title;
        public int score;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 901303688;

        public PushMessageContentGameScore() {
        }

        public PushMessageContentGameScore(String var1, int var2, boolean var3) {
            this.title = var1;
            this.score = var2;
            this.isPinned = var3;
        }

        @Override
        public int getConstructor() {
            return 901303688;
        }
    }

    public static class PushMessageContentGame extends PushMessageContent {
        public String title;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -515131109;

        public PushMessageContentGame() {
        }

        public PushMessageContentGame(String var1, boolean var2) {
            this.title = var1;
            this.isPinned = var2;
        }

        @Override
        public int getConstructor() {
            return -515131109;
        }
    }

    public static class PushMessageContentDocument extends PushMessageContent {
        public Document document;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -458379775;

        public PushMessageContentDocument() {
        }

        public PushMessageContentDocument(Document var1, boolean var2) {
            this.document = var1;
            this.isPinned = var2;
        }

        @Override
        public int getConstructor() {
            return -458379775;
        }
    }

    public static class PushMessageContentContactRegistered extends PushMessageContent {
        public static final int CONSTRUCTOR = -303962720;

        public PushMessageContentContactRegistered() {
        }

        @Override
        public int getConstructor() {
            return -303962720;
        }
    }

    public static class PushMessageContentContact extends PushMessageContent {
        public String name;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -12219820;

        public PushMessageContentContact() {
        }

        public PushMessageContentContact(String var1, boolean var2) {
            this.name = var1;
            this.isPinned = var2;
        }

        @Override
        public int getConstructor() {
            return -12219820;
        }
    }

    public static class PushMessageContentAudio extends PushMessageContent {
        public Audio audio;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 381581426;

        public PushMessageContentAudio() {
        }

        public PushMessageContentAudio(Audio var1, boolean var2) {
            this.audio = var1;
            this.isPinned = var2;
        }

        @Override
        public int getConstructor() {
            return 381581426;
        }
    }

    public static class PushMessageContentAnimation extends PushMessageContent {
        public Animation animation;
        public String caption;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 1034215396;

        public PushMessageContentAnimation() {
        }

        public PushMessageContentAnimation(Animation var1, String var2, boolean var3) {
            this.animation = var1;
            this.caption = var2;
            this.isPinned = var3;
        }

        @Override
        public int getConstructor() {
            return 1034215396;
        }
    }

    public static class PushMessageContentHidden extends PushMessageContent {
        public boolean isPinned;
        public static final int CONSTRUCTOR = -316950436;

        public PushMessageContentHidden() {
        }

        public PushMessageContentHidden(boolean var1) {
            this.isPinned = var1;
        }

        @Override
        public int getConstructor() {
            return -316950436;
        }
    }

    public abstract static class PushMessageContent extends Object {
        public PushMessageContent() {
        }
    }

    public static class PublicChatTypeIsLocationBased extends PublicChatType {
        public static final int CONSTRUCTOR = 1183735952;

        public PublicChatTypeIsLocationBased() {
        }

        @Override
        public int getConstructor() {
            return 1183735952;
        }
    }

    public static class PublicChatTypeHasUsername extends PublicChatType {
        public static final int CONSTRUCTOR = 350789758;

        public PublicChatTypeHasUsername() {
        }

        @Override
        public int getConstructor() {
            return 350789758;
        }
    }

    public abstract static class PublicChatType extends Object {
        public PublicChatType() {
        }
    }

    public static class ProxyTypeMtproto extends ProxyType {
        public String secret;
        public static final int CONSTRUCTOR = -1964826627;

        public ProxyTypeMtproto() {
        }

        public ProxyTypeMtproto(String var1) {
            this.secret = var1;
        }

        @Override
        public int getConstructor() {
            return -1964826627;
        }
    }

    public static class ProxyTypeHttp extends ProxyType {
        public String username;
        public String password;
        public boolean httpOnly;
        public static final int CONSTRUCTOR = -1547188361;

        public ProxyTypeHttp() {
        }

        public ProxyTypeHttp(String var1, String var2, boolean var3) {
            this.username = var1;
            this.password = var2;
            this.httpOnly = var3;
        }

        @Override
        public int getConstructor() {
            return -1547188361;
        }
    }

    public static class ProxyTypeSocks5 extends ProxyType {
        public String username;
        public String password;
        public static final int CONSTRUCTOR = -890027341;

        public ProxyTypeSocks5() {
        }

        public ProxyTypeSocks5(String var1, String var2) {
            this.username = var1;
            this.password = var2;
        }

        @Override
        public int getConstructor() {
            return -890027341;
        }
    }

    public abstract static class ProxyType extends Object {
        public ProxyType() {
        }
    }

    public static class Proxy extends Object {
        public int id;
        public String server;
        public int port;
        public int lastUsedDate;
        public boolean isEnabled;
        public ProxyType type;
        public static final int CONSTRUCTOR = 196049779;

        public Proxy() {
        }

        public Proxy(int var1, String var2, int var3, int var4, boolean var5, ProxyType var6) {
            this.id = var1;
            this.server = var2;
            this.port = var3;
            this.lastUsedDate = var4;
            this.isEnabled = var5;
            this.type = var6;
        }

        @Override
        public int getConstructor() {
            return 196049779;
        }
    }

    public static class Proxies extends Object {
        public Proxy[] proxies;
        public static final int CONSTRUCTOR = 1200447205;

        public Proxies() {
        }

        public Proxies(Proxy[] var1) {
            this.proxies = var1;
        }

        @Override
        public int getConstructor() {
            return 1200447205;
        }
    }

    public static class ProfilePhoto extends Object {
        public long id;
        public File small;
        public File big;
        public Minithumbnail minithumbnail;
        public boolean hasAnimation;
        public static final int CONSTRUCTOR = -131097523;

        public ProfilePhoto() {
        }

        public ProfilePhoto(long var1, File var3, File var4, Minithumbnail var5, boolean var6) {
            this.id = var1;
            this.small = var3;
            this.big = var4;
            this.minithumbnail = var5;
            this.hasAnimation = var6;
        }

        @Override
        public int getConstructor() {
            return -131097523;
        }
    }

    public static class PollTypeQuiz extends PollType {
        public int correctOptionId;
        public FormattedText explanation;
        public static final int CONSTRUCTOR = 657013913;

        public PollTypeQuiz() {
        }

        public PollTypeQuiz(int var1, FormattedText var2) {
            this.correctOptionId = var1;
            this.explanation = var2;
        }

        @Override
        public int getConstructor() {
            return 657013913;
        }
    }

    public static class PollTypeRegular extends PollType {
        public boolean allowMultipleAnswers;
        public static final int CONSTRUCTOR = 641265698;

        public PollTypeRegular() {
        }

        public PollTypeRegular(boolean var1) {
            this.allowMultipleAnswers = var1;
        }

        @Override
        public int getConstructor() {
            return 641265698;
        }
    }

    public abstract static class PollType extends Object {
        public PollType() {
        }
    }

    public static class PollOption extends Object {
        public String text;
        public int voterCount;
        public int votePercentage;
        public boolean isChosen;
        public boolean isBeingChosen;
        public static final int CONSTRUCTOR = 1473893797;

        public PollOption() {
        }

        public PollOption(String var1, int var2, int var3, boolean var4, boolean var5) {
            this.text = var1;
            this.voterCount = var2;
            this.votePercentage = var3;
            this.isChosen = var4;
            this.isBeingChosen = var5;
        }

        @Override
        public int getConstructor() {
            return 1473893797;
        }
    }

    public static class Poll extends Object {
        public long id;
        public String question;
        public PollOption[] options;
        public int totalVoterCount;
        public int[] recentVoterUserIds;
        public boolean isAnonymous;
        public PollType type;
        public int openPeriod;
        public int closeDate;
        public boolean isClosed;
        public static final int CONSTRUCTOR = 163256789;

        public Poll() {
        }

        public Poll(long var1, String var3, PollOption[] var4, int var5, int[] var6, boolean var7, PollType var8, int var9, int var10, boolean var11) {
            this.id = var1;
            this.question = var3;
            this.options = var4;
            this.totalVoterCount = var5;
            this.recentVoterUserIds = var6;
            this.isAnonymous = var7;
            this.type = var8;
            this.openPeriod = var9;
            this.closeDate = var10;
            this.isClosed = var11;
        }

        @Override
        public int getConstructor() {
            return 163256789;
        }
    }

    public static class Point extends Object {
        public double x;
        public double y;
        public static final int CONSTRUCTOR = 437515705;

        public Point() {
        }

        public Point(double var1, double var3) {
            this.x = var1;
            this.y = var3;
        }

        @Override
        public int getConstructor() {
            return 437515705;
        }
    }

    public static class PhotoSize extends Object {
        public String type;
        public File photo;
        public int width;
        public int height;
        public int[] progressiveSizes;
        public static final int CONSTRUCTOR = 1609182352;

        public PhotoSize() {
        }

        public PhotoSize(String var1, File var2, int var3, int var4, int[] var5) {
            this.type = var1;
            this.photo = var2;
            this.width = var3;
            this.height = var4;
            this.progressiveSizes = var5;
        }

        @Override
        public int getConstructor() {
            return 1609182352;
        }
    }

    public static class Photo extends Object {
        public boolean hasStickers;
        public Minithumbnail minithumbnail;
        public PhotoSize[] sizes;
        public static final int CONSTRUCTOR = -2022871583;

        public Photo() {
        }

        public Photo(boolean var1, Minithumbnail var2, PhotoSize[] var3) {
            this.hasStickers = var1;
            this.minithumbnail = var2;
            this.sizes = var3;
        }

        @Override
        public int getConstructor() {
            return -2022871583;
        }
    }

    public static class PhoneNumberInfo extends Object {
        public CountryInfo country;
        public String countryCallingCode;
        public String formattedPhoneNumber;
        public static final int CONSTRUCTOR = 560180961;

        public PhoneNumberInfo() {
        }

        public PhoneNumberInfo(CountryInfo var1, String var2, String var3) {
            this.country = var1;
            this.countryCallingCode = var2;
            this.formattedPhoneNumber = var3;
        }

        @Override
        public int getConstructor() {
            return 560180961;
        }
    }

    public static class PhoneNumberAuthenticationSettings extends Object {
        public boolean allowFlashCall;
        public boolean isCurrentPhoneNumber;
        public boolean allowSmsRetrieverApi;
        public static final int CONSTRUCTOR = -859198743;

        public PhoneNumberAuthenticationSettings() {
        }

        public PhoneNumberAuthenticationSettings(boolean var1, boolean var2, boolean var3) {
            this.allowFlashCall = var1;
            this.isCurrentPhoneNumber = var2;
            this.allowSmsRetrieverApi = var3;
        }

        @Override
        public int getConstructor() {
            return -859198743;
        }
    }

    public static class PersonalDocument extends Object {
        public DatedFile[] files;
        public DatedFile[] translation;
        public static final int CONSTRUCTOR = -1011634661;

        public PersonalDocument() {
        }

        public PersonalDocument(DatedFile[] var1, DatedFile[] var2) {
            this.files = var1;
            this.translation = var2;
        }

        @Override
        public int getConstructor() {
            return -1011634661;
        }
    }

    public static class PersonalDetails extends Object {
        public String firstName;
        public String middleName;
        public String lastName;
        public String nativeFirstName;
        public String nativeMiddleName;
        public String nativeLastName;
        public Date birthdate;
        public String gender;
        public String countryCode;
        public String residenceCountryCode;
        public static final int CONSTRUCTOR = -1061656137;

        public PersonalDetails() {
        }

        public PersonalDetails(String var1, String var2, String var3, String var4, String var5, String var6, Date var7, String var8, String var9, String var10) {
            this.firstName = var1;
            this.middleName = var2;
            this.lastName = var3;
            this.nativeFirstName = var4;
            this.nativeMiddleName = var5;
            this.nativeLastName = var6;
            this.birthdate = var7;
            this.gender = var8;
            this.countryCode = var9;
            this.residenceCountryCode = var10;
        }

        @Override
        public int getConstructor() {
            return -1061656137;
        }
    }

    public static class PaymentsProviderStripe extends Object {
        public String publishableKey;
        public boolean needCountry;
        public boolean needPostalCode;
        public boolean needCardholderName;
        public static final int CONSTRUCTOR = 1090791032;

        public PaymentsProviderStripe() {
        }

        public PaymentsProviderStripe(String var1, boolean var2, boolean var3, boolean var4) {
            this.publishableKey = var1;
            this.needCountry = var2;
            this.needPostalCode = var3;
            this.needCardholderName = var4;
        }

        @Override
        public int getConstructor() {
            return 1090791032;
        }
    }

    public static class PaymentResult extends Object {
        public boolean success;
        public String verificationUrl;
        public static final int CONSTRUCTOR = -804263843;

        public PaymentResult() {
        }

        public PaymentResult(boolean var1, String var2) {
            this.success = var1;
            this.verificationUrl = var2;
        }

        @Override
        public int getConstructor() {
            return -804263843;
        }
    }

    public static class PaymentReceipt extends Object {
        public String title;
        public String description;
        public Photo photo;
        public int date;
        public int sellerBotUserId;
        public int paymentsProviderUserId;
        public Invoice invoice;
        public OrderInfo orderInfo;
        public ShippingOption shippingOption;
        public String credentialsTitle;
        public long tipAmount;
        public static final int CONSTRUCTOR = 2056924836;

        public PaymentReceipt() {
        }

        public PaymentReceipt(String var1, String var2, Photo var3, int var4, int var5, int var6, Invoice var7, OrderInfo var8, ShippingOption var9, String var10, long var11) {
            this.title = var1;
            this.description = var2;
            this.photo = var3;
            this.date = var4;
            this.sellerBotUserId = var5;
            this.paymentsProviderUserId = var6;
            this.invoice = var7;
            this.orderInfo = var8;
            this.shippingOption = var9;
            this.credentialsTitle = var10;
            this.tipAmount = var11;
        }

        @Override
        public int getConstructor() {
            return 2056924836;
        }
    }

    public static class PaymentFormTheme extends Object {
        public int backgroundColor;
        public int textColor;
        public int hintColor;
        public int linkColor;
        public int buttonColor;
        public int buttonTextColor;
        public static final int CONSTRUCTOR = -1760030833;

        public PaymentFormTheme() {
        }

        public PaymentFormTheme(int var1, int var2, int var3, int var4, int var5, int var6) {
            this.backgroundColor = var1;
            this.textColor = var2;
            this.hintColor = var3;
            this.linkColor = var4;
            this.buttonColor = var5;
            this.buttonTextColor = var6;
        }

        @Override
        public int getConstructor() {
            return -1760030833;
        }
    }

    public static class PaymentForm extends Object {
        public long id;
        public Invoice invoice;
        public String url;
        public int sellerBotUserId;
        public int paymentsProviderUserId;
        public PaymentsProviderStripe paymentsProvider;
        public OrderInfo savedOrderInfo;
        public SavedCredentials savedCredentials;
        public boolean canSaveCredentials;
        public boolean needPassword;
        public static final int CONSTRUCTOR = 1520077892;

        public PaymentForm() {
        }

        public PaymentForm(long var1, Invoice var3, String var4, int var5, int var6, PaymentsProviderStripe var7, OrderInfo var8, SavedCredentials var9, boolean var10, boolean var11) {
            this.id = var1;
            this.invoice = var3;
            this.url = var4;
            this.sellerBotUserId = var5;
            this.paymentsProviderUserId = var6;
            this.paymentsProvider = var7;
            this.savedOrderInfo = var8;
            this.savedCredentials = var9;
            this.canSaveCredentials = var10;
            this.needPassword = var11;
        }

        @Override
        public int getConstructor() {
            return 1520077892;
        }
    }

    public static class PasswordState extends Object {
        public boolean hasPassword;
        public String passwordHint;
        public boolean hasRecoveryEmailAddress;
        public boolean hasPassportData;
        public EmailAddressAuthenticationCodeInfo recoveryEmailAddressCodeInfo;
        public int pendingResetDate;
        public static final int CONSTRUCTOR = -2001619202;

        public PasswordState() {
        }

        public PasswordState(boolean var1, String var2, boolean var3, boolean var4, EmailAddressAuthenticationCodeInfo var5, int var6) {
            this.hasPassword = var1;
            this.passwordHint = var2;
            this.hasRecoveryEmailAddress = var3;
            this.hasPassportData = var4;
            this.recoveryEmailAddressCodeInfo = var5;
            this.pendingResetDate = var6;
        }

        @Override
        public int getConstructor() {
            return -2001619202;
        }
    }

    public static class PassportSuitableElement extends Object {
        public PassportElementType type;
        public boolean isSelfieRequired;
        public boolean isTranslationRequired;
        public boolean isNativeNameRequired;
        public static final int CONSTRUCTOR = -789019876;

        public PassportSuitableElement() {
        }

        public PassportSuitableElement(PassportElementType var1, boolean var2, boolean var3, boolean var4) {
            this.type = var1;
            this.isSelfieRequired = var2;
            this.isTranslationRequired = var3;
            this.isNativeNameRequired = var4;
        }

        @Override
        public int getConstructor() {
            return -789019876;
        }
    }

    public static class PassportRequiredElement extends Object {
        public PassportSuitableElement[] suitableElements;
        public static final int CONSTRUCTOR = -1983641651;

        public PassportRequiredElement() {
        }

        public PassportRequiredElement(PassportSuitableElement[] var1) {
            this.suitableElements = var1;
        }

        @Override
        public int getConstructor() {
            return -1983641651;
        }
    }

    public static class PassportElementsWithErrors extends Object {
        public PassportElement[] elements;
        public PassportElementError[] errors;
        public static final int CONSTRUCTOR = 1308923044;

        public PassportElementsWithErrors() {
        }

        public PassportElementsWithErrors(PassportElement[] var1, PassportElementError[] var2) {
            this.elements = var1;
            this.errors = var2;
        }

        @Override
        public int getConstructor() {
            return 1308923044;
        }
    }

    public static class PassportElements extends Object {
        public PassportElement[] elements;
        public static final int CONSTRUCTOR = 1264617556;

        public PassportElements() {
        }

        public PassportElements(PassportElement[] var1) {
            this.elements = var1;
        }

        @Override
        public int getConstructor() {
            return 1264617556;
        }
    }

    public static class PassportElementTypeEmailAddress extends PassportElementType {
        public static final int CONSTRUCTOR = -79321405;

        public PassportElementTypeEmailAddress() {
        }

        @Override
        public int getConstructor() {
            return -79321405;
        }
    }

    public static class PassportElementTypePhoneNumber extends PassportElementType {
        public static final int CONSTRUCTOR = -995361172;

        public PassportElementTypePhoneNumber() {
        }

        @Override
        public int getConstructor() {
            return -995361172;
        }
    }

    public static class PassportElementTypeTemporaryRegistration extends PassportElementType {
        public static final int CONSTRUCTOR = 1092498527;

        public PassportElementTypeTemporaryRegistration() {
        }

        @Override
        public int getConstructor() {
            return 1092498527;
        }
    }

    public static class PassportElementTypePassportRegistration extends PassportElementType {
        public static final int CONSTRUCTOR = -159478209;

        public PassportElementTypePassportRegistration() {
        }

        @Override
        public int getConstructor() {
            return -159478209;
        }
    }

    public static class PassportElementTypeRentalAgreement extends PassportElementType {
        public static final int CONSTRUCTOR = -2060583280;

        public PassportElementTypeRentalAgreement() {
        }

        @Override
        public int getConstructor() {
            return -2060583280;
        }
    }

    public static class PassportElementTypeBankStatement extends PassportElementType {
        public static final int CONSTRUCTOR = 574095667;

        public PassportElementTypeBankStatement() {
        }

        @Override
        public int getConstructor() {
            return 574095667;
        }
    }

    public static class PassportElementTypeUtilityBill extends PassportElementType {
        public static final int CONSTRUCTOR = 627084906;

        public PassportElementTypeUtilityBill() {
        }

        @Override
        public int getConstructor() {
            return 627084906;
        }
    }

    public static class PassportElementTypeAddress extends PassportElementType {
        public static final int CONSTRUCTOR = 496327874;

        public PassportElementTypeAddress() {
        }

        @Override
        public int getConstructor() {
            return 496327874;
        }
    }

    public static class PassportElementTypeInternalPassport extends PassportElementType {
        public static final int CONSTRUCTOR = -793781959;

        public PassportElementTypeInternalPassport() {
        }

        @Override
        public int getConstructor() {
            return -793781959;
        }
    }

    public static class PassportElementTypeIdentityCard extends PassportElementType {
        public static final int CONSTRUCTOR = -502356132;

        public PassportElementTypeIdentityCard() {
        }

        @Override
        public int getConstructor() {
            return -502356132;
        }
    }

    public static class PassportElementTypeDriverLicense extends PassportElementType {
        public static final int CONSTRUCTOR = 1827298379;

        public PassportElementTypeDriverLicense() {
        }

        @Override
        public int getConstructor() {
            return 1827298379;
        }
    }

    public static class PassportElementTypePassport extends PassportElementType {
        public static final int CONSTRUCTOR = -436360376;

        public PassportElementTypePassport() {
        }

        @Override
        public int getConstructor() {
            return -436360376;
        }
    }

    public static class PassportElementTypePersonalDetails extends PassportElementType {
        public static final int CONSTRUCTOR = -1032136365;

        public PassportElementTypePersonalDetails() {
        }

        @Override
        public int getConstructor() {
            return -1032136365;
        }
    }

    public abstract static class PassportElementType extends Object {
        public PassportElementType() {
        }
    }

    public static class PassportElementErrorSourceFiles extends PassportElementErrorSource {
        public static final int CONSTRUCTOR = 1894164178;

        public PassportElementErrorSourceFiles() {
        }

        @Override
        public int getConstructor() {
            return 1894164178;
        }
    }

    public static class PassportElementErrorSourceFile extends PassportElementErrorSource {
        public int fileIndex;
        public static final int CONSTRUCTOR = 2020358960;

        public PassportElementErrorSourceFile() {
        }

        public PassportElementErrorSourceFile(int var1) {
            this.fileIndex = var1;
        }

        @Override
        public int getConstructor() {
            return 2020358960;
        }
    }

    public static class PassportElementErrorSourceTranslationFiles extends PassportElementErrorSource {
        public static final int CONSTRUCTOR = 581280796;

        public PassportElementErrorSourceTranslationFiles() {
        }

        @Override
        public int getConstructor() {
            return 581280796;
        }
    }

    public static class PassportElementErrorSourceTranslationFile extends PassportElementErrorSource {
        public int fileIndex;
        public static final int CONSTRUCTOR = -689621228;

        public PassportElementErrorSourceTranslationFile() {
        }

        public PassportElementErrorSourceTranslationFile(int var1) {
            this.fileIndex = var1;
        }

        @Override
        public int getConstructor() {
            return -689621228;
        }
    }

    public static class PassportElementErrorSourceSelfie extends PassportElementErrorSource {
        public static final int CONSTRUCTOR = -797043672;

        public PassportElementErrorSourceSelfie() {
        }

        @Override
        public int getConstructor() {
            return -797043672;
        }
    }

    public static class PassportElementErrorSourceReverseSide extends PassportElementErrorSource {
        public static final int CONSTRUCTOR = 1918630391;

        public PassportElementErrorSourceReverseSide() {
        }

        @Override
        public int getConstructor() {
            return 1918630391;
        }
    }

    public static class PassportElementErrorSourceFrontSide extends PassportElementErrorSource {
        public static final int CONSTRUCTOR = 1895658292;

        public PassportElementErrorSourceFrontSide() {
        }

        @Override
        public int getConstructor() {
            return 1895658292;
        }
    }

    public static class PassportElementErrorSourceDataField extends PassportElementErrorSource {
        public String fieldName;
        public static final int CONSTRUCTOR = -308650776;

        public PassportElementErrorSourceDataField() {
        }

        public PassportElementErrorSourceDataField(String var1) {
            this.fieldName = var1;
        }

        @Override
        public int getConstructor() {
            return -308650776;
        }
    }

    public static class PassportElementErrorSourceUnspecified extends PassportElementErrorSource {
        public static final int CONSTRUCTOR = -378320830;

        public PassportElementErrorSourceUnspecified() {
        }

        @Override
        public int getConstructor() {
            return -378320830;
        }
    }

    public abstract static class PassportElementErrorSource extends Object {
        public PassportElementErrorSource() {
        }
    }

    public static class PassportElementError extends Object {
        public PassportElementType type;
        public String message;
        public PassportElementErrorSource source;
        public static final int CONSTRUCTOR = -1861902395;

        public PassportElementError() {
        }

        public PassportElementError(PassportElementType var1, String var2, PassportElementErrorSource var3) {
            this.type = var1;
            this.message = var2;
            this.source = var3;
        }

        @Override
        public int getConstructor() {
            return -1861902395;
        }
    }

    public static class PassportElementEmailAddress extends PassportElement {
        public String emailAddress;
        public static final int CONSTRUCTOR = -1528129531;

        public PassportElementEmailAddress() {
        }

        public PassportElementEmailAddress(String var1) {
            this.emailAddress = var1;
        }

        @Override
        public int getConstructor() {
            return -1528129531;
        }
    }

    public static class PassportElementPhoneNumber extends PassportElement {
        public String phoneNumber;
        public static final int CONSTRUCTOR = -1320118375;

        public PassportElementPhoneNumber() {
        }

        public PassportElementPhoneNumber(String var1) {
            this.phoneNumber = var1;
        }

        @Override
        public int getConstructor() {
            return -1320118375;
        }
    }

    public static class PassportElementTemporaryRegistration extends PassportElement {
        public PersonalDocument temporaryRegistration;
        public static final int CONSTRUCTOR = 1237626864;

        public PassportElementTemporaryRegistration() {
        }

        public PassportElementTemporaryRegistration(PersonalDocument var1) {
            this.temporaryRegistration = var1;
        }

        @Override
        public int getConstructor() {
            return 1237626864;
        }
    }

    public static class PassportElementPassportRegistration extends PassportElement {
        public PersonalDocument passportRegistration;
        public static final int CONSTRUCTOR = 618323071;

        public PassportElementPassportRegistration() {
        }

        public PassportElementPassportRegistration(PersonalDocument var1) {
            this.passportRegistration = var1;
        }

        @Override
        public int getConstructor() {
            return 618323071;
        }
    }

    public static class PassportElementRentalAgreement extends PassportElement {
        public PersonalDocument rentalAgreement;
        public static final int CONSTRUCTOR = -290141400;

        public PassportElementRentalAgreement() {
        }

        public PassportElementRentalAgreement(PersonalDocument var1) {
            this.rentalAgreement = var1;
        }

        @Override
        public int getConstructor() {
            return -290141400;
        }
    }

    public static class PassportElementBankStatement extends PassportElement {
        public PersonalDocument bankStatement;
        public static final int CONSTRUCTOR = -366464408;

        public PassportElementBankStatement() {
        }

        public PassportElementBankStatement(PersonalDocument var1) {
            this.bankStatement = var1;
        }

        @Override
        public int getConstructor() {
            return -366464408;
        }
    }

    public static class PassportElementUtilityBill extends PassportElement {
        public PersonalDocument utilityBill;
        public static final int CONSTRUCTOR = -234611246;

        public PassportElementUtilityBill() {
        }

        public PassportElementUtilityBill(PersonalDocument var1) {
            this.utilityBill = var1;
        }

        @Override
        public int getConstructor() {
            return -234611246;
        }
    }

    public static class PassportElementAddress extends PassportElement {
        public Address address;
        public static final int CONSTRUCTOR = -782625232;

        public PassportElementAddress() {
        }

        public PassportElementAddress(Address var1) {
            this.address = var1;
        }

        @Override
        public int getConstructor() {
            return -782625232;
        }
    }

    public static class PassportElementInternalPassport extends PassportElement {
        public IdentityDocument internalPassport;
        public static final int CONSTRUCTOR = 36220295;

        public PassportElementInternalPassport() {
        }

        public PassportElementInternalPassport(IdentityDocument var1) {
            this.internalPassport = var1;
        }

        @Override
        public int getConstructor() {
            return 36220295;
        }
    }

    public static class PassportElementIdentityCard extends PassportElement {
        public IdentityDocument identityCard;
        public static final int CONSTRUCTOR = 2083775797;

        public PassportElementIdentityCard() {
        }

        public PassportElementIdentityCard(IdentityDocument var1) {
            this.identityCard = var1;
        }

        @Override
        public int getConstructor() {
            return 2083775797;
        }
    }

    public static class PassportElementDriverLicense extends PassportElement {
        public IdentityDocument driverLicense;
        public static final int CONSTRUCTOR = 1643580589;

        public PassportElementDriverLicense() {
        }

        public PassportElementDriverLicense(IdentityDocument var1) {
            this.driverLicense = var1;
        }

        @Override
        public int getConstructor() {
            return 1643580589;
        }
    }

    public static class PassportElementPassport extends PassportElement {
        public IdentityDocument passport;
        public static final int CONSTRUCTOR = -263985373;

        public PassportElementPassport() {
        }

        public PassportElementPassport(IdentityDocument var1) {
            this.passport = var1;
        }

        @Override
        public int getConstructor() {
            return -263985373;
        }
    }

    public static class PassportElementPersonalDetails extends PassportElement {
        public PersonalDetails personalDetails;
        public static final int CONSTRUCTOR = 1217724035;

        public PassportElementPersonalDetails() {
        }

        public PassportElementPersonalDetails(PersonalDetails var1) {
            this.personalDetails = var1;
        }

        @Override
        public int getConstructor() {
            return 1217724035;
        }
    }

    public abstract static class PassportElement extends Object {
        public PassportElement() {
        }
    }

    public static class PassportAuthorizationForm extends Object {
        public int id;
        public PassportRequiredElement[] requiredElements;
        public String privacyPolicyUrl;
        public static final int CONSTRUCTOR = -1070673218;

        public PassportAuthorizationForm() {
        }

        public PassportAuthorizationForm(int var1, PassportRequiredElement[] var2, String var3) {
            this.id = var1;
            this.requiredElements = var2;
            this.privacyPolicyUrl = var3;
        }

        @Override
        public int getConstructor() {
            return -1070673218;
        }
    }

    public static class PageBlockVerticalAlignmentBottom extends PageBlockVerticalAlignment {
        public static final int CONSTRUCTOR = 2092531158;

        public PageBlockVerticalAlignmentBottom() {
        }

        @Override
        public int getConstructor() {
            return 2092531158;
        }
    }

    public static class PageBlockVerticalAlignmentMiddle extends PageBlockVerticalAlignment {
        public static final int CONSTRUCTOR = -2123096587;

        public PageBlockVerticalAlignmentMiddle() {
        }

        @Override
        public int getConstructor() {
            return -2123096587;
        }
    }

    public static class PageBlockVerticalAlignmentTop extends PageBlockVerticalAlignment {
        public static final int CONSTRUCTOR = 195500454;

        public PageBlockVerticalAlignmentTop() {
        }

        @Override
        public int getConstructor() {
            return 195500454;
        }
    }

    public abstract static class PageBlockVerticalAlignment extends Object {
        public PageBlockVerticalAlignment() {
        }
    }

    public static class PageBlockTableCell extends Object {
        public RichText text;
        public boolean isHeader;
        public int colspan;
        public int rowspan;
        public PageBlockHorizontalAlignment align;
        public PageBlockVerticalAlignment valign;
        public static final int CONSTRUCTOR = 1417658214;

        public PageBlockTableCell() {
        }

        public PageBlockTableCell(RichText var1, boolean var2, int var3, int var4, PageBlockHorizontalAlignment var5, PageBlockVerticalAlignment var6) {
            this.text = var1;
            this.isHeader = var2;
            this.colspan = var3;
            this.rowspan = var4;
            this.align = var5;
            this.valign = var6;
        }

        @Override
        public int getConstructor() {
            return 1417658214;
        }
    }

    public static class PageBlockRelatedArticle extends Object {
        public String url;
        public String title;
        public String description;
        public Photo photo;
        public String author;
        public int publishDate;
        public static final int CONSTRUCTOR = 481199251;

        public PageBlockRelatedArticle() {
        }

        public PageBlockRelatedArticle(String var1, String var2, String var3, Photo var4, String var5, int var6) {
            this.url = var1;
            this.title = var2;
            this.description = var3;
            this.photo = var4;
            this.author = var5;
            this.publishDate = var6;
        }

        @Override
        public int getConstructor() {
            return 481199251;
        }
    }

    public static class PageBlockListItem extends Object {
        public String label;
        public PageBlock[] pageBlocks;
        public static final int CONSTRUCTOR = 323186259;

        public PageBlockListItem() {
        }

        public PageBlockListItem(String var1, PageBlock[] var2) {
            this.label = var1;
            this.pageBlocks = var2;
        }

        @Override
        public int getConstructor() {
            return 323186259;
        }
    }

    public static class PageBlockHorizontalAlignmentRight extends PageBlockHorizontalAlignment {
        public static final int CONSTRUCTOR = 1371369214;

        public PageBlockHorizontalAlignmentRight() {
        }

        @Override
        public int getConstructor() {
            return 1371369214;
        }
    }

    public static class PageBlockHorizontalAlignmentCenter extends PageBlockHorizontalAlignment {
        public static final int CONSTRUCTOR = -1009203990;

        public PageBlockHorizontalAlignmentCenter() {
        }

        @Override
        public int getConstructor() {
            return -1009203990;
        }
    }

    public static class PageBlockHorizontalAlignmentLeft extends PageBlockHorizontalAlignment {
        public static final int CONSTRUCTOR = 848701417;

        public PageBlockHorizontalAlignmentLeft() {
        }

        @Override
        public int getConstructor() {
            return 848701417;
        }
    }

    public abstract static class PageBlockHorizontalAlignment extends Object {
        public PageBlockHorizontalAlignment() {
        }
    }

    public static class PageBlockCaption extends Object {
        public RichText text;
        public RichText credit;
        public static final int CONSTRUCTOR = -1180064650;

        public PageBlockCaption() {
        }

        public PageBlockCaption(RichText var1, RichText var2) {
            this.text = var1;
            this.credit = var2;
        }

        @Override
        public int getConstructor() {
            return -1180064650;
        }
    }

    public static class PageBlockMap extends PageBlock {
        public Location location;
        public int zoom;
        public int width;
        public int height;
        public PageBlockCaption caption;
        public static final int CONSTRUCTOR = 1510961171;

        public PageBlockMap() {
        }

        public PageBlockMap(Location var1, int var2, int var3, int var4, PageBlockCaption var5) {
            this.location = var1;
            this.zoom = var2;
            this.width = var3;
            this.height = var4;
            this.caption = var5;
        }

        @Override
        public int getConstructor() {
            return 1510961171;
        }
    }

    public static class PageBlockRelatedArticles extends PageBlock {
        public RichText header;
        public PageBlockRelatedArticle[] articles;
        public static final int CONSTRUCTOR = -1807324374;

        public PageBlockRelatedArticles() {
        }

        public PageBlockRelatedArticles(RichText var1, PageBlockRelatedArticle[] var2) {
            this.header = var1;
            this.articles = var2;
        }

        @Override
        public int getConstructor() {
            return -1807324374;
        }
    }

    public static class PageBlockDetails extends PageBlock {
        public RichText header;
        public PageBlock[] pageBlocks;
        public boolean isOpen;
        public static final int CONSTRUCTOR = -1599869809;

        public PageBlockDetails() {
        }

        public PageBlockDetails(RichText var1, PageBlock[] var2, boolean var3) {
            this.header = var1;
            this.pageBlocks = var2;
            this.isOpen = var3;
        }

        @Override
        public int getConstructor() {
            return -1599869809;
        }
    }

    public static class PageBlockTable extends PageBlock {
        public RichText caption;
        public PageBlockTableCell[][] cells;
        public boolean isBordered;
        public boolean isStriped;
        public static final int CONSTRUCTOR = -942649288;

        public PageBlockTable() {
        }

        public PageBlockTable(RichText var1, PageBlockTableCell[][] var2, boolean var3, boolean var4) {
            this.caption = var1;
            this.cells = var2;
            this.isBordered = var3;
            this.isStriped = var4;
        }

        @Override
        public int getConstructor() {
            return -942649288;
        }
    }

    public static class PageBlockChatLink extends PageBlock {
        public String title;
        public ChatPhotoInfo photo;
        public String username;
        public static final int CONSTRUCTOR = -202091253;

        public PageBlockChatLink() {
        }

        public PageBlockChatLink(String var1, ChatPhotoInfo var2, String var3) {
            this.title = var1;
            this.photo = var2;
            this.username = var3;
        }

        @Override
        public int getConstructor() {
            return -202091253;
        }
    }

    public static class PageBlockSlideshow extends PageBlock {
        public PageBlock[] pageBlocks;
        public PageBlockCaption caption;
        public static final int CONSTRUCTOR = 539217375;

        public PageBlockSlideshow() {
        }

        public PageBlockSlideshow(PageBlock[] var1, PageBlockCaption var2) {
            this.pageBlocks = var1;
            this.caption = var2;
        }

        @Override
        public int getConstructor() {
            return 539217375;
        }
    }

    public static class PageBlockCollage extends PageBlock {
        public PageBlock[] pageBlocks;
        public PageBlockCaption caption;
        public static final int CONSTRUCTOR = 1163760110;

        public PageBlockCollage() {
        }

        public PageBlockCollage(PageBlock[] var1, PageBlockCaption var2) {
            this.pageBlocks = var1;
            this.caption = var2;
        }

        @Override
        public int getConstructor() {
            return 1163760110;
        }
    }

    public static class PageBlockEmbeddedPost extends PageBlock {
        public String url;
        public String author;
        public Photo authorPhoto;
        public int date;
        public PageBlock[] pageBlocks;
        public PageBlockCaption caption;
        public static final int CONSTRUCTOR = 397600949;

        public PageBlockEmbeddedPost() {
        }

        public PageBlockEmbeddedPost(String var1, String var2, Photo var3, int var4, PageBlock[] var5, PageBlockCaption var6) {
            this.url = var1;
            this.author = var2;
            this.authorPhoto = var3;
            this.date = var4;
            this.pageBlocks = var5;
            this.caption = var6;
        }

        @Override
        public int getConstructor() {
            return 397600949;
        }
    }

    public static class PageBlockEmbedded extends PageBlock {
        public String url;
        public String html;
        public Photo posterPhoto;
        public int width;
        public int height;
        public PageBlockCaption caption;
        public boolean isFullWidth;
        public boolean allowScrolling;
        public static final int CONSTRUCTOR = -1942577763;

        public PageBlockEmbedded() {
        }

        public PageBlockEmbedded(String var1, String var2, Photo var3, int var4, int var5, PageBlockCaption var6, boolean var7, boolean var8) {
            this.url = var1;
            this.html = var2;
            this.posterPhoto = var3;
            this.width = var4;
            this.height = var5;
            this.caption = var6;
            this.isFullWidth = var7;
            this.allowScrolling = var8;
        }

        @Override
        public int getConstructor() {
            return -1942577763;
        }
    }

    public static class PageBlockCover extends PageBlock {
        public PageBlock cover;
        public static final int CONSTRUCTOR = 972174080;

        public PageBlockCover() {
        }

        public PageBlockCover(PageBlock var1) {
            this.cover = var1;
        }

        @Override
        public int getConstructor() {
            return 972174080;
        }
    }

    public static class PageBlockVoiceNote extends PageBlock {
        public VoiceNote voiceNote;
        public PageBlockCaption caption;
        public static final int CONSTRUCTOR = 1823310463;

        public PageBlockVoiceNote() {
        }

        public PageBlockVoiceNote(VoiceNote var1, PageBlockCaption var2) {
            this.voiceNote = var1;
            this.caption = var2;
        }

        @Override
        public int getConstructor() {
            return 1823310463;
        }
    }

    public static class PageBlockVideo extends PageBlock {
        public Video video;
        public PageBlockCaption caption;
        public boolean needAutoplay;
        public boolean isLooped;
        public static final int CONSTRUCTOR = 510041394;

        public PageBlockVideo() {
        }

        public PageBlockVideo(Video var1, PageBlockCaption var2, boolean var3, boolean var4) {
            this.video = var1;
            this.caption = var2;
            this.needAutoplay = var3;
            this.isLooped = var4;
        }

        @Override
        public int getConstructor() {
            return 510041394;
        }
    }

    public static class PageBlockPhoto extends PageBlock {
        public Photo photo;
        public PageBlockCaption caption;
        public String url;
        public static final int CONSTRUCTOR = 417601156;

        public PageBlockPhoto() {
        }

        public PageBlockPhoto(Photo var1, PageBlockCaption var2, String var3) {
            this.photo = var1;
            this.caption = var2;
            this.url = var3;
        }

        @Override
        public int getConstructor() {
            return 417601156;
        }
    }

    public static class PageBlockAudio extends PageBlock {
        public Audio audio;
        public PageBlockCaption caption;
        public static final int CONSTRUCTOR = -63371245;

        public PageBlockAudio() {
        }

        public PageBlockAudio(Audio var1, PageBlockCaption var2) {
            this.audio = var1;
            this.caption = var2;
        }

        @Override
        public int getConstructor() {
            return -63371245;
        }
    }

    public static class PageBlockAnimation extends PageBlock {
        public Animation animation;
        public PageBlockCaption caption;
        public boolean needAutoplay;
        public static final int CONSTRUCTOR = 1355669513;

        public PageBlockAnimation() {
        }

        public PageBlockAnimation(Animation var1, PageBlockCaption var2, boolean var3) {
            this.animation = var1;
            this.caption = var2;
            this.needAutoplay = var3;
        }

        @Override
        public int getConstructor() {
            return 1355669513;
        }
    }

    public static class PageBlockPullQuote extends PageBlock {
        public RichText text;
        public RichText credit;
        public static final int CONSTRUCTOR = 490242317;

        public PageBlockPullQuote() {
        }

        public PageBlockPullQuote(RichText var1, RichText var2) {
            this.text = var1;
            this.credit = var2;
        }

        @Override
        public int getConstructor() {
            return 490242317;
        }
    }

    public static class PageBlockBlockQuote extends PageBlock {
        public RichText text;
        public RichText credit;
        public static final int CONSTRUCTOR = 1657834142;

        public PageBlockBlockQuote() {
        }

        public PageBlockBlockQuote(RichText var1, RichText var2) {
            this.text = var1;
            this.credit = var2;
        }

        @Override
        public int getConstructor() {
            return 1657834142;
        }
    }

    public static class PageBlockList extends PageBlock {
        public PageBlockListItem[] items;
        public static final int CONSTRUCTOR = -1037074852;

        public PageBlockList() {
        }

        public PageBlockList(PageBlockListItem[] var1) {
            this.items = var1;
        }

        @Override
        public int getConstructor() {
            return -1037074852;
        }
    }

    public static class PageBlockAnchor extends PageBlock {
        public String name;
        public static final int CONSTRUCTOR = -837994576;

        public PageBlockAnchor() {
        }

        public PageBlockAnchor(String var1) {
            this.name = var1;
        }

        @Override
        public int getConstructor() {
            return -837994576;
        }
    }

    public static class PageBlockDivider extends PageBlock {
        public static final int CONSTRUCTOR = -618614392;

        public PageBlockDivider() {
        }

        @Override
        public int getConstructor() {
            return -618614392;
        }
    }

    public static class PageBlockFooter extends PageBlock {
        public RichText footer;
        public static final int CONSTRUCTOR = 886429480;

        public PageBlockFooter() {
        }

        public PageBlockFooter(RichText var1) {
            this.footer = var1;
        }

        @Override
        public int getConstructor() {
            return 886429480;
        }
    }

    public static class PageBlockPreformatted extends PageBlock {
        public RichText text;
        public String language;
        public static final int CONSTRUCTOR = -1066346178;

        public PageBlockPreformatted() {
        }

        public PageBlockPreformatted(RichText var1, String var2) {
            this.text = var1;
            this.language = var2;
        }

        @Override
        public int getConstructor() {
            return -1066346178;
        }
    }

    public static class PageBlockParagraph extends PageBlock {
        public RichText text;
        public static final int CONSTRUCTOR = 1182402406;

        public PageBlockParagraph() {
        }

        public PageBlockParagraph(RichText var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return 1182402406;
        }
    }

    public static class PageBlockKicker extends PageBlock {
        public RichText kicker;
        public static final int CONSTRUCTOR = 1361282635;

        public PageBlockKicker() {
        }

        public PageBlockKicker(RichText var1) {
            this.kicker = var1;
        }

        @Override
        public int getConstructor() {
            return 1361282635;
        }
    }

    public static class PageBlockSubheader extends PageBlock {
        public RichText subheader;
        public static final int CONSTRUCTOR = 1263956774;

        public PageBlockSubheader() {
        }

        public PageBlockSubheader(RichText var1) {
            this.subheader = var1;
        }

        @Override
        public int getConstructor() {
            return 1263956774;
        }
    }

    public static class PageBlockHeader extends PageBlock {
        public RichText header;
        public static final int CONSTRUCTOR = 1402854811;

        public PageBlockHeader() {
        }

        public PageBlockHeader(RichText var1) {
            this.header = var1;
        }

        @Override
        public int getConstructor() {
            return 1402854811;
        }
    }

    public static class PageBlockAuthorDate extends PageBlock {
        public RichText author;
        public int publishDate;
        public static final int CONSTRUCTOR = 1300231184;

        public PageBlockAuthorDate() {
        }

        public PageBlockAuthorDate(RichText var1, int var2) {
            this.author = var1;
            this.publishDate = var2;
        }

        @Override
        public int getConstructor() {
            return 1300231184;
        }
    }

    public static class PageBlockSubtitle extends PageBlock {
        public RichText subtitle;
        public static final int CONSTRUCTOR = 264524263;

        public PageBlockSubtitle() {
        }

        public PageBlockSubtitle(RichText var1) {
            this.subtitle = var1;
        }

        @Override
        public int getConstructor() {
            return 264524263;
        }
    }

    public static class PageBlockTitle extends PageBlock {
        public RichText title;
        public static final int CONSTRUCTOR = 1629664784;

        public PageBlockTitle() {
        }

        public PageBlockTitle(RichText var1) {
            this.title = var1;
        }

        @Override
        public int getConstructor() {
            return 1629664784;
        }
    }

    public abstract static class PageBlock extends Object {
        public PageBlock() {
        }
    }

    public static class OrderInfo extends Object {
        public String name;
        public String phoneNumber;
        public String emailAddress;
        public Address shippingAddress;
        public static final int CONSTRUCTOR = 783997294;

        public OrderInfo() {
        }

        public OrderInfo(String var1, String var2, String var3, Address var4) {
            this.name = var1;
            this.phoneNumber = var2;
            this.emailAddress = var3;
            this.shippingAddress = var4;
        }

        @Override
        public int getConstructor() {
            return 783997294;
        }
    }

    public static class OptionValueString extends OptionValue {
        public String value;
        public static final int CONSTRUCTOR = 756248212;

        public OptionValueString() {
        }

        public OptionValueString(String var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return 756248212;
        }
    }

    public static class OptionValueInteger extends OptionValue {
        public long value;
        public static final int CONSTRUCTOR = -186858780;

        public OptionValueInteger() {
        }

        public OptionValueInteger(long var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return -186858780;
        }
    }

    public static class OptionValueEmpty extends OptionValue {
        public static final int CONSTRUCTOR = 918955155;

        public OptionValueEmpty() {
        }

        @Override
        public int getConstructor() {
            return 918955155;
        }
    }

    public static class OptionValueBoolean extends OptionValue {
        public boolean value;
        public static final int CONSTRUCTOR = 63135518;

        public OptionValueBoolean() {
        }

        public OptionValueBoolean(boolean var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return 63135518;
        }
    }

    public abstract static class OptionValue extends Object {
        public OptionValue() {
        }
    }

    public static class Ok extends Object {
        public static final int CONSTRUCTOR = -722616727;

        public Ok() {
        }

        @Override
        public int getConstructor() {
            return -722616727;
        }
    }

    public static class NotificationTypeNewPushMessage extends NotificationType {
        public long messageId;
        public MessageSender sender;
        public String senderName;
        public boolean isOutgoing;
        public PushMessageContent content;
        public static final int CONSTRUCTOR = -1999850882;

        public NotificationTypeNewPushMessage() {
        }

        public NotificationTypeNewPushMessage(long var1, MessageSender var3, String var4, boolean var5, PushMessageContent var6) {
            this.messageId = var1;
            this.sender = var3;
            this.senderName = var4;
            this.isOutgoing = var5;
            this.content = var6;
        }

        @Override
        public int getConstructor() {
            return -1999850882;
        }
    }

    public static class NotificationTypeNewCall extends NotificationType {
        public int callId;
        public static final int CONSTRUCTOR = 1712734585;

        public NotificationTypeNewCall() {
        }

        public NotificationTypeNewCall(int var1) {
            this.callId = var1;
        }

        @Override
        public int getConstructor() {
            return 1712734585;
        }
    }

    public static class NotificationTypeNewSecretChat extends NotificationType {
        public static final int CONSTRUCTOR = 1198638768;

        public NotificationTypeNewSecretChat() {
        }

        @Override
        public int getConstructor() {
            return 1198638768;
        }
    }

    public static class NotificationTypeNewMessage extends NotificationType {
        public Message message;
        public static final int CONSTRUCTOR = 1885935159;

        public NotificationTypeNewMessage() {
        }

        public NotificationTypeNewMessage(Message var1) {
            this.message = var1;
        }

        @Override
        public int getConstructor() {
            return 1885935159;
        }
    }

    public abstract static class NotificationType extends Object {
        public NotificationType() {
        }
    }

    public static class NotificationSettingsScopeChannelChats extends NotificationSettingsScope {
        public static final int CONSTRUCTOR = 548013448;

        public NotificationSettingsScopeChannelChats() {
        }

        @Override
        public int getConstructor() {
            return 548013448;
        }
    }

    public static class NotificationSettingsScopeGroupChats extends NotificationSettingsScope {
        public static final int CONSTRUCTOR = 1212142067;

        public NotificationSettingsScopeGroupChats() {
        }

        @Override
        public int getConstructor() {
            return 1212142067;
        }
    }

    public static class NotificationSettingsScopePrivateChats extends NotificationSettingsScope {
        public static final int CONSTRUCTOR = 937446759;

        public NotificationSettingsScopePrivateChats() {
        }

        @Override
        public int getConstructor() {
            return 937446759;
        }
    }

    public abstract static class NotificationSettingsScope extends Object {
        public NotificationSettingsScope() {
        }
    }

    public static class NotificationGroupTypeCalls extends NotificationGroupType {
        public static final int CONSTRUCTOR = 1379123538;

        public NotificationGroupTypeCalls() {
        }

        @Override
        public int getConstructor() {
            return 1379123538;
        }
    }

    public static class NotificationGroupTypeSecretChat extends NotificationGroupType {
        public static final int CONSTRUCTOR = 1390759476;

        public NotificationGroupTypeSecretChat() {
        }

        @Override
        public int getConstructor() {
            return 1390759476;
        }
    }

    public static class NotificationGroupTypeMentions extends NotificationGroupType {
        public static final int CONSTRUCTOR = -2050324051;

        public NotificationGroupTypeMentions() {
        }

        @Override
        public int getConstructor() {
            return -2050324051;
        }
    }

    public static class NotificationGroupTypeMessages extends NotificationGroupType {
        public static final int CONSTRUCTOR = -1702481123;

        public NotificationGroupTypeMessages() {
        }

        @Override
        public int getConstructor() {
            return -1702481123;
        }
    }

    public abstract static class NotificationGroupType extends Object {
        public NotificationGroupType() {
        }
    }

    public static class NotificationGroup extends Object {
        public int id;
        public NotificationGroupType type;
        public long chatId;
        public int totalCount;
        public Notification[] notifications;
        public static final int CONSTRUCTOR = 780691541;

        public NotificationGroup() {
        }

        public NotificationGroup(int var1, NotificationGroupType var2, long var3, int var5, Notification[] var6) {
            this.id = var1;
            this.type = var2;
            this.chatId = var3;
            this.totalCount = var5;
            this.notifications = var6;
        }

        @Override
        public int getConstructor() {
            return 780691541;
        }
    }

    public static class Notification extends Object {
        public int id;
        public int date;
        public boolean isSilent;
        public NotificationType type;
        public static final int CONSTRUCTOR = 788743120;

        public Notification() {
        }

        public Notification(int var1, int var2, boolean var3, NotificationType var4) {
            this.id = var1;
            this.date = var2;
            this.isSilent = var3;
            this.type = var4;
        }

        @Override
        public int getConstructor() {
            return 788743120;
        }
    }

    public static class NetworkTypeOther extends NetworkType {
        public static final int CONSTRUCTOR = 1942128539;

        public NetworkTypeOther() {
        }

        @Override
        public int getConstructor() {
            return 1942128539;
        }
    }

    public static class NetworkTypeWiFi extends NetworkType {
        public static final int CONSTRUCTOR = -633872070;

        public NetworkTypeWiFi() {
        }

        @Override
        public int getConstructor() {
            return -633872070;
        }
    }

    public static class NetworkTypeMobileRoaming extends NetworkType {
        public static final int CONSTRUCTOR = -1435199760;

        public NetworkTypeMobileRoaming() {
        }

        @Override
        public int getConstructor() {
            return -1435199760;
        }
    }

    public static class NetworkTypeMobile extends NetworkType {
        public static final int CONSTRUCTOR = 819228239;

        public NetworkTypeMobile() {
        }

        @Override
        public int getConstructor() {
            return 819228239;
        }
    }

    public static class NetworkTypeNone extends NetworkType {
        public static final int CONSTRUCTOR = -1971691759;

        public NetworkTypeNone() {
        }

        @Override
        public int getConstructor() {
            return -1971691759;
        }
    }

    public abstract static class NetworkType extends Object {
        public NetworkType() {
        }
    }

    public static class NetworkStatisticsEntryCall extends NetworkStatisticsEntry {
        public NetworkType networkType;
        public long sentBytes;
        public long receivedBytes;
        public double duration;
        public static final int CONSTRUCTOR = 737000365;

        public NetworkStatisticsEntryCall() {
        }

        public NetworkStatisticsEntryCall(NetworkType var1, long var2, long var4, double var6) {
            this.networkType = var1;
            this.sentBytes = var2;
            this.receivedBytes = var4;
            this.duration = var6;
        }

        @Override
        public int getConstructor() {
            return 737000365;
        }
    }

    public static class NetworkStatisticsEntryFile extends NetworkStatisticsEntry {
        public FileType fileType;
        public NetworkType networkType;
        public long sentBytes;
        public long receivedBytes;
        public static final int CONSTRUCTOR = 188452706;

        public NetworkStatisticsEntryFile() {
        }

        public NetworkStatisticsEntryFile(FileType var1, NetworkType var2, long var3, long var5) {
            this.fileType = var1;
            this.networkType = var2;
            this.sentBytes = var3;
            this.receivedBytes = var5;
        }

        @Override
        public int getConstructor() {
            return 188452706;
        }
    }

    public abstract static class NetworkStatisticsEntry extends Object {
        public NetworkStatisticsEntry() {
        }
    }

    public static class NetworkStatistics extends Object {
        public int sinceDate;
        public NetworkStatisticsEntry[] entries;
        public static final int CONSTRUCTOR = 1615554212;

        public NetworkStatistics() {
        }

        public NetworkStatistics(int var1, NetworkStatisticsEntry[] var2) {
            this.sinceDate = var1;
            this.entries = var2;
        }

        @Override
        public int getConstructor() {
            return 1615554212;
        }
    }

    public static class Minithumbnail extends Object {
        public int width;
        public int height;
        public byte[] data;
        public static final int CONSTRUCTOR = -328540758;

        public Minithumbnail() {
        }

        public Minithumbnail(int var1, int var2, byte[] var3) {
            this.width = var1;
            this.height = var2;
            this.data = var3;
        }

        @Override
        public int getConstructor() {
            return -328540758;
        }
    }

    public static class Messages extends Object {
        public int totalCount;
        public Message[] messages;
        public static final int CONSTRUCTOR = -16498159;

        public Messages() {
        }

        public Messages(int var1, Message[] var2) {
            this.totalCount = var1;
            this.messages = var2;
        }

        @Override
        public int getConstructor() {
            return -16498159;
        }
    }

    public static class MessageThreadInfo extends Object {
        public long chatId;
        public long messageThreadId;
        public MessageReplyInfo replyInfo;
        public int unreadMessageCount;
        public Message[] messages;
        public DraftMessage draftMessage;
        public static final int CONSTRUCTOR = -248536056;

        public MessageThreadInfo() {
        }

        public MessageThreadInfo(long var1, long var3, MessageReplyInfo var5, int var6, Message[] var7, DraftMessage var8) {
            this.chatId = var1;
            this.messageThreadId = var3;
            this.replyInfo = var5;
            this.unreadMessageCount = var6;
            this.messages = var7;
            this.draftMessage = var8;
        }

        @Override
        public int getConstructor() {
            return -248536056;
        }
    }

    public static class MessageStatistics extends Object {
        public StatisticalGraph messageInteractionGraph;
        public static final int CONSTRUCTOR = -1011383888;

        public MessageStatistics() {
        }

        public MessageStatistics(StatisticalGraph var1) {
            this.messageInteractionGraph = var1;
        }

        @Override
        public int getConstructor() {
            return -1011383888;
        }
    }

    public static class MessageSendingStateFailed extends MessageSendingState {
        public int errorCode;
        public String errorMessage;
        public boolean canRetry;
        public double retryAfter;
        public static final int CONSTRUCTOR = 2054476087;

        public MessageSendingStateFailed() {
        }

        public MessageSendingStateFailed(int var1, String var2, boolean var3, double var4) {
            this.errorCode = var1;
            this.errorMessage = var2;
            this.canRetry = var3;
            this.retryAfter = var4;
        }

        @Override
        public int getConstructor() {
            return 2054476087;
        }
    }

    public static class MessageSendingStatePending extends MessageSendingState {
        public static final int CONSTRUCTOR = -1381803582;

        public MessageSendingStatePending() {
        }

        @Override
        public int getConstructor() {
            return -1381803582;
        }
    }

    public abstract static class MessageSendingState extends Object {
        public MessageSendingState() {
        }
    }

    public static class MessageSenders extends Object {
        public int totalCount;
        public MessageSender[] senders;
        public static final int CONSTRUCTOR = -690158467;

        public MessageSenders() {
        }

        public MessageSenders(int var1, MessageSender[] var2) {
            this.totalCount = var1;
            this.senders = var2;
        }

        @Override
        public int getConstructor() {
            return -690158467;
        }
    }

    public static class MessageSenderChat extends MessageSender {
        public long chatId;
        public static final int CONSTRUCTOR = -239660751;

        public MessageSenderChat() {
        }

        public MessageSenderChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return -239660751;
        }
    }

    public static class MessageSenderUser extends MessageSender {
        public int userId;
        public static final int CONSTRUCTOR = 1647122213;

        public MessageSenderUser() {
        }

        public MessageSenderUser(int var1) {
            this.userId = var1;
        }

        @Override
        public int getConstructor() {
            return 1647122213;
        }
    }

    public abstract static class MessageSender extends Object {
        public MessageSender() {
        }
    }

    public static class MessageSendOptions extends Object {
        public boolean disableNotification;
        public boolean fromBackground;
        public MessageSchedulingState schedulingState;
        public static final int CONSTRUCTOR = 914544314;

        public MessageSendOptions() {
        }

        public MessageSendOptions(boolean var1, boolean var2, MessageSchedulingState var3) {
            this.disableNotification = var1;
            this.fromBackground = var2;
            this.schedulingState = var3;
        }

        @Override
        public int getConstructor() {
            return 914544314;
        }
    }

    public static class MessageSchedulingStateSendWhenOnline extends MessageSchedulingState {
        public static final int CONSTRUCTOR = 2092947464;

        public MessageSchedulingStateSendWhenOnline() {
        }

        @Override
        public int getConstructor() {
            return 2092947464;
        }
    }

    public static class MessageSchedulingStateSendAtDate extends MessageSchedulingState {
        public int sendDate;
        public static final int CONSTRUCTOR = -1485570073;

        public MessageSchedulingStateSendAtDate() {
        }

        public MessageSchedulingStateSendAtDate(int var1) {
            this.sendDate = var1;
        }

        @Override
        public int getConstructor() {
            return -1485570073;
        }
    }

    public abstract static class MessageSchedulingState extends Object {
        public MessageSchedulingState() {
        }
    }

    public static class MessageReplyInfo extends Object {
        public int replyCount;
        public MessageSender[] recentRepliers;
        public long lastReadInboxMessageId;
        public long lastReadOutboxMessageId;
        public long lastMessageId;
        public static final int CONSTRUCTOR = -1443221826;

        public MessageReplyInfo() {
        }

        public MessageReplyInfo(int var1, MessageSender[] var2, long var3, long var5, long var7) {
            this.replyCount = var1;
            this.recentRepliers = var2;
            this.lastReadInboxMessageId = var3;
            this.lastReadOutboxMessageId = var5;
            this.lastMessageId = var7;
        }

        @Override
        public int getConstructor() {
            return -1443221826;
        }
    }

    public static class MessageLinkInfo extends Object {
        public boolean isPublic;
        public long chatId;
        public Message message;
        public int mediaTimestamp;
        public boolean forAlbum;
        public boolean forComment;
        public static final int CONSTRUCTOR = -981646294;

        public MessageLinkInfo() {
        }

        public MessageLinkInfo(boolean var1, long var2, Message var4, int var5, boolean var6, boolean var7) {
            this.isPublic = var1;
            this.chatId = var2;
            this.message = var4;
            this.mediaTimestamp = var5;
            this.forAlbum = var6;
            this.forComment = var7;
        }

        @Override
        public int getConstructor() {
            return -981646294;
        }
    }

    public static class MessageLink extends Object {
        public String link;
        public boolean isPublic;
        public static final int CONSTRUCTOR = -1354089818;

        public MessageLink() {
        }

        public MessageLink(String var1, boolean var2) {
            this.link = var1;
            this.isPublic = var2;
        }

        @Override
        public int getConstructor() {
            return -1354089818;
        }
    }

    public static class MessageInteractionInfo extends Object {
        public int viewCount;
        public int forwardCount;
        public MessageReplyInfo replyInfo;
        public static final int CONSTRUCTOR = -620714966;

        public MessageInteractionInfo() {
        }

        public MessageInteractionInfo(int var1, int var2, MessageReplyInfo var3) {
            this.viewCount = var1;
            this.forwardCount = var2;
            this.replyInfo = var3;
        }

        @Override
        public int getConstructor() {
            return -620714966;
        }
    }

    public static class MessageForwardOriginMessageImport extends MessageForwardOrigin {
        public String senderName;
        public static final int CONSTRUCTOR = -739561951;

        public MessageForwardOriginMessageImport() {
        }

        public MessageForwardOriginMessageImport(String var1) {
            this.senderName = var1;
        }

        @Override
        public int getConstructor() {
            return -739561951;
        }
    }

    public static class MessageForwardOriginChannel extends MessageForwardOrigin {
        public long chatId;
        public long messageId;
        public String authorSignature;
        public static final int CONSTRUCTOR = 1490730723;

        public MessageForwardOriginChannel() {
        }

        public MessageForwardOriginChannel(long var1, long var3, String var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.authorSignature = var5;
        }

        @Override
        public int getConstructor() {
            return 1490730723;
        }
    }

    public static class MessageForwardOriginHiddenUser extends MessageForwardOrigin {
        public String senderName;
        public static final int CONSTRUCTOR = -271257885;

        public MessageForwardOriginHiddenUser() {
        }

        public MessageForwardOriginHiddenUser(String var1) {
            this.senderName = var1;
        }

        @Override
        public int getConstructor() {
            return -271257885;
        }
    }

    public static class MessageForwardOriginChat extends MessageForwardOrigin {
        public long senderChatId;
        public String authorSignature;
        public static final int CONSTRUCTOR = 1526010724;

        public MessageForwardOriginChat() {
        }

        public MessageForwardOriginChat(long var1, String var3) {
            this.senderChatId = var1;
            this.authorSignature = var3;
        }

        @Override
        public int getConstructor() {
            return 1526010724;
        }
    }

    public static class MessageForwardOriginUser extends MessageForwardOrigin {
        public int senderUserId;
        public static final int CONSTRUCTOR = 2781520;

        public MessageForwardOriginUser() {
        }

        public MessageForwardOriginUser(int var1) {
            this.senderUserId = var1;
        }

        @Override
        public int getConstructor() {
            return 2781520;
        }
    }

    public abstract static class MessageForwardOrigin extends Object {
        public MessageForwardOrigin() {
        }
    }

    public static class MessageForwardInfo extends Object {
        public MessageForwardOrigin origin;
        public int date;
        public String publicServiceAnnouncementType;
        public long fromChatId;
        public long fromMessageId;
        public static final int CONSTRUCTOR = -327300408;

        public MessageForwardInfo() {
        }

        public MessageForwardInfo(MessageForwardOrigin var1, int var2, String var3, long var4, long var6) {
            this.origin = var1;
            this.date = var2;
            this.publicServiceAnnouncementType = var3;
            this.fromChatId = var4;
            this.fromMessageId = var6;
        }

        @Override
        public int getConstructor() {
            return -327300408;
        }
    }

    public static class MessageFileTypeUnknown extends MessageFileType {
        public static final int CONSTRUCTOR = 1176353458;

        public MessageFileTypeUnknown() {
        }

        @Override
        public int getConstructor() {
            return 1176353458;
        }
    }

    public static class MessageFileTypeGroup extends MessageFileType {
        public String title;
        public static final int CONSTRUCTOR = -219836568;

        public MessageFileTypeGroup() {
        }

        public MessageFileTypeGroup(String var1) {
            this.title = var1;
        }

        @Override
        public int getConstructor() {
            return -219836568;
        }
    }

    public static class MessageFileTypePrivate extends MessageFileType {
        public String name;
        public static final int CONSTRUCTOR = -521908524;

        public MessageFileTypePrivate() {
        }

        public MessageFileTypePrivate(String var1) {
            this.name = var1;
        }

        @Override
        public int getConstructor() {
            return -521908524;
        }
    }

    public abstract static class MessageFileType extends Object {
        public MessageFileType() {
        }
    }

    public static class MessageCopyOptions extends Object {
        public boolean sendCopy;
        public boolean replaceCaption;
        public FormattedText newCaption;
        public static final int CONSTRUCTOR = 1208442937;

        public MessageCopyOptions() {
        }

        public MessageCopyOptions(boolean var1, boolean var2, FormattedText var3) {
            this.sendCopy = var1;
            this.replaceCaption = var2;
            this.newCaption = var3;
        }

        @Override
        public int getConstructor() {
            return 1208442937;
        }
    }

    public static class MessageUnsupported extends MessageContent {
        public static final int CONSTRUCTOR = -1816726139;

        public MessageUnsupported() {
        }

        @Override
        public int getConstructor() {
            return -1816726139;
        }
    }

    public static class MessageProximityAlertTriggered extends MessageContent {
        public MessageSender traveler;
        public MessageSender watcher;
        public int distance;
        public static final int CONSTRUCTOR = -1311617562;

        public MessageProximityAlertTriggered() {
        }

        public MessageProximityAlertTriggered(MessageSender var1, MessageSender var2, int var3) {
            this.traveler = var1;
            this.watcher = var2;
            this.distance = var3;
        }

        @Override
        public int getConstructor() {
            return -1311617562;
        }
    }

    public static class MessagePassportDataReceived extends MessageContent {
        public EncryptedPassportElement[] elements;
        public EncryptedCredentials credentials;
        public static final int CONSTRUCTOR = -1367863624;

        public MessagePassportDataReceived() {
        }

        public MessagePassportDataReceived(EncryptedPassportElement[] var1, EncryptedCredentials var2) {
            this.elements = var1;
            this.credentials = var2;
        }

        @Override
        public int getConstructor() {
            return -1367863624;
        }
    }

    public static class MessagePassportDataSent extends MessageContent {
        public PassportElementType[] types;
        public static final int CONSTRUCTOR = 1017405171;

        public MessagePassportDataSent() {
        }

        public MessagePassportDataSent(PassportElementType[] var1) {
            this.types = var1;
        }

        @Override
        public int getConstructor() {
            return 1017405171;
        }
    }

    public static class MessageWebsiteConnected extends MessageContent {
        public String domainName;
        public static final int CONSTRUCTOR = -1074551800;

        public MessageWebsiteConnected() {
        }

        public MessageWebsiteConnected(String var1) {
            this.domainName = var1;
        }

        @Override
        public int getConstructor() {
            return -1074551800;
        }
    }

    public static class MessageContactRegistered extends MessageContent {
        public static final int CONSTRUCTOR = -1502020353;

        public MessageContactRegistered() {
        }

        @Override
        public int getConstructor() {
            return -1502020353;
        }
    }

    public static class MessagePaymentSuccessfulBot extends MessageContent {
        public String currency;
        public long totalAmount;
        public byte[] invoicePayload;
        public String shippingOptionId;
        public OrderInfo orderInfo;
        public String telegramPaymentChargeId;
        public String providerPaymentChargeId;
        public static final int CONSTRUCTOR = -438430050;

        public MessagePaymentSuccessfulBot() {
        }

        public MessagePaymentSuccessfulBot(String var1, long var2, byte[] var4, String var5, OrderInfo var6, String var7, String var8) {
            this.currency = var1;
            this.totalAmount = var2;
            this.invoicePayload = var4;
            this.shippingOptionId = var5;
            this.orderInfo = var6;
            this.telegramPaymentChargeId = var7;
            this.providerPaymentChargeId = var8;
        }

        @Override
        public int getConstructor() {
            return -438430050;
        }
    }

    public static class MessagePaymentSuccessful extends MessageContent {
        public long invoiceChatId;
        public long invoiceMessageId;
        public String currency;
        public long totalAmount;
        public static final int CONSTRUCTOR = 1442934098;

        public MessagePaymentSuccessful() {
        }

        public MessagePaymentSuccessful(long var1, long var3, String var5, long var6) {
            this.invoiceChatId = var1;
            this.invoiceMessageId = var3;
            this.currency = var5;
            this.totalAmount = var6;
        }

        @Override
        public int getConstructor() {
            return 1442934098;
        }
    }

    public static class MessageGameScore extends MessageContent {
        public long gameMessageId;
        public long gameId;
        public int score;
        public static final int CONSTRUCTOR = 1344904575;

        public MessageGameScore() {
        }

        public MessageGameScore(long var1, long var3, int var5) {
            this.gameMessageId = var1;
            this.gameId = var3;
            this.score = var5;
        }

        @Override
        public int getConstructor() {
            return 1344904575;
        }
    }

    public static class MessageCustomServiceAction extends MessageContent {
        public String text;
        public static final int CONSTRUCTOR = 1435879282;

        public MessageCustomServiceAction() {
        }

        public MessageCustomServiceAction(String var1) {
            this.text = var1;
        }

        @Override
        public int getConstructor() {
            return 1435879282;
        }
    }

    public static class MessageChatSetTtl extends MessageContent {
        public int ttl;
        public static final int CONSTRUCTOR = 1810060209;

        public MessageChatSetTtl() {
        }

        public MessageChatSetTtl(int var1) {
            this.ttl = var1;
        }

        @Override
        public int getConstructor() {
            return 1810060209;
        }
    }

    public static class MessageChatSetTheme extends MessageContent {
        public String themeName;
        public static final int CONSTRUCTOR = -1716612088;

        public MessageChatSetTheme() {
        }

        public MessageChatSetTheme(String var1) {
            this.themeName = var1;
        }

        @Override
        public int getConstructor() {
            return -1716612088;
        }
    }

    public static class MessageScreenshotTaken extends MessageContent {
        public static final int CONSTRUCTOR = -1564971605;

        public MessageScreenshotTaken() {
        }

        @Override
        public int getConstructor() {
            return -1564971605;
        }
    }

    public static class MessagePinMessage extends MessageContent {
        public long messageId;
        public static final int CONSTRUCTOR = 953503801;

        public MessagePinMessage() {
        }

        public MessagePinMessage(long var1) {
            this.messageId = var1;
        }

        @Override
        public int getConstructor() {
            return 953503801;
        }
    }

    public static class MessageChatUpgradeFrom extends MessageContent {
        public String title;
        public int basicGroupId;
        public static final int CONSTRUCTOR = 1642272558;

        public MessageChatUpgradeFrom() {
        }

        public MessageChatUpgradeFrom(String var1, int var2) {
            this.title = var1;
            this.basicGroupId = var2;
        }

        @Override
        public int getConstructor() {
            return 1642272558;
        }
    }

    public static class MessageChatUpgradeTo extends MessageContent {
        public int supergroupId;
        public static final int CONSTRUCTOR = 1957816681;

        public MessageChatUpgradeTo() {
        }

        public MessageChatUpgradeTo(int var1) {
            this.supergroupId = var1;
        }

        @Override
        public int getConstructor() {
            return 1957816681;
        }
    }

    public static class MessageChatDeleteMember extends MessageContent {
        public int userId;
        public static final int CONSTRUCTOR = 1164414043;

        public MessageChatDeleteMember() {
        }

        public MessageChatDeleteMember(int var1) {
            this.userId = var1;
        }

        @Override
        public int getConstructor() {
            return 1164414043;
        }
    }

    public static class MessageChatJoinByLink extends MessageContent {
        public static final int CONSTRUCTOR = 1846493311;

        public MessageChatJoinByLink() {
        }

        @Override
        public int getConstructor() {
            return 1846493311;
        }
    }

    public static class MessageChatAddMembers extends MessageContent {
        public int[] memberUserIds;
        public static final int CONSTRUCTOR = 401228326;

        public MessageChatAddMembers() {
        }

        public MessageChatAddMembers(int[] var1) {
            this.memberUserIds = var1;
        }

        @Override
        public int getConstructor() {
            return 401228326;
        }
    }

    public static class MessageChatDeletePhoto extends MessageContent {
        public static final int CONSTRUCTOR = -184374809;

        public MessageChatDeletePhoto() {
        }

        @Override
        public int getConstructor() {
            return -184374809;
        }
    }

    public static class MessageChatChangePhoto extends MessageContent {
        public ChatPhoto photo;
        public static final int CONSTRUCTOR = -813415093;

        public MessageChatChangePhoto() {
        }

        public MessageChatChangePhoto(ChatPhoto var1) {
            this.photo = var1;
        }

        @Override
        public int getConstructor() {
            return -813415093;
        }
    }

    public static class MessageChatChangeTitle extends MessageContent {
        public String title;
        public static final int CONSTRUCTOR = 748272449;

        public MessageChatChangeTitle() {
        }

        public MessageChatChangeTitle(String var1) {
            this.title = var1;
        }

        @Override
        public int getConstructor() {
            return 748272449;
        }
    }

    public static class MessageSupergroupChatCreate extends MessageContent {
        public String title;
        public static final int CONSTRUCTOR = -434325733;

        public MessageSupergroupChatCreate() {
        }

        public MessageSupergroupChatCreate(String var1) {
            this.title = var1;
        }

        @Override
        public int getConstructor() {
            return -434325733;
        }
    }

    public static class MessageBasicGroupChatCreate extends MessageContent {
        public String title;
        public int[] memberUserIds;
        public static final int CONSTRUCTOR = 1575377646;

        public MessageBasicGroupChatCreate() {
        }

        public MessageBasicGroupChatCreate(String var1, int[] var2) {
            this.title = var1;
            this.memberUserIds = var2;
        }

        @Override
        public int getConstructor() {
            return 1575377646;
        }
    }

    public static class MessageInviteVoiceChatParticipants extends MessageContent {
        public int groupCallId;
        public int[] userIds;
        public static final int CONSTRUCTOR = 46546833;

        public MessageInviteVoiceChatParticipants() {
        }

        public MessageInviteVoiceChatParticipants(int var1, int[] var2) {
            this.groupCallId = var1;
            this.userIds = var2;
        }

        @Override
        public int getConstructor() {
            return 46546833;
        }
    }

    public static class MessageVoiceChatEnded extends MessageContent {
        public int duration;
        public static final int CONSTRUCTOR = -678902089;

        public MessageVoiceChatEnded() {
        }

        public MessageVoiceChatEnded(int var1) {
            this.duration = var1;
        }

        @Override
        public int getConstructor() {
            return -678902089;
        }
    }

    public static class MessageVoiceChatStarted extends MessageContent {
        public int groupCallId;
        public static final int CONSTRUCTOR = -909274005;

        public MessageVoiceChatStarted() {
        }

        public MessageVoiceChatStarted(int var1) {
            this.groupCallId = var1;
        }

        @Override
        public int getConstructor() {
            return -909274005;
        }
    }

    public static class MessageVoiceChatScheduled extends MessageContent {
        public int groupCallId;
        public int startDate;
        public static final int CONSTRUCTOR = -1480640252;

        public MessageVoiceChatScheduled() {
        }

        public MessageVoiceChatScheduled(int var1, int var2) {
            this.groupCallId = var1;
            this.startDate = var2;
        }

        @Override
        public int getConstructor() {
            return -1480640252;
        }
    }

    public static class MessageCall extends MessageContent {
        public boolean isVideo;
        public CallDiscardReason discardReason;
        public int duration;
        public static final int CONSTRUCTOR = 538893824;

        public MessageCall() {
        }

        public MessageCall(boolean var1, CallDiscardReason var2, int var3) {
            this.isVideo = var1;
            this.discardReason = var2;
            this.duration = var3;
        }

        @Override
        public int getConstructor() {
            return 538893824;
        }
    }

    public static class MessageInvoice extends MessageContent {
        public String title;
        public String description;
        public Photo photo;
        public String currency;
        public long totalAmount;
        public String startParameter;
        public boolean isTest;
        public boolean needShippingAddress;
        public long receiptMessageId;
        public static final int CONSTRUCTOR = -1916671476;

        public MessageInvoice() {
        }

        public MessageInvoice(String var1, String var2, Photo var3, String var4, long var5, String var7, boolean var8, boolean var9, long var10) {
            this.title = var1;
            this.description = var2;
            this.photo = var3;
            this.currency = var4;
            this.totalAmount = var5;
            this.startParameter = var7;
            this.isTest = var8;
            this.needShippingAddress = var9;
            this.receiptMessageId = var10;
        }

        @Override
        public int getConstructor() {
            return -1916671476;
        }
    }

    public static class MessagePoll extends MessageContent {
        public Poll poll;
        public static final int CONSTRUCTOR = -662130099;

        public MessagePoll() {
        }

        public MessagePoll(Poll var1) {
            this.poll = var1;
        }

        @Override
        public int getConstructor() {
            return -662130099;
        }
    }

    public static class MessageGame extends MessageContent {
        public Game game;
        public static final int CONSTRUCTOR = -69441162;

        public MessageGame() {
        }

        public MessageGame(Game var1) {
            this.game = var1;
        }

        @Override
        public int getConstructor() {
            return -69441162;
        }
    }

    public static class MessageDice extends MessageContent {
        public DiceStickers initialState;
        public DiceStickers finalState;
        public String emoji;
        public int value;
        public int successAnimationFrameNumber;
        public static final int CONSTRUCTOR = 1115779641;

        public MessageDice() {
        }

        public MessageDice(DiceStickers var1, DiceStickers var2, String var3, int var4, int var5) {
            this.initialState = var1;
            this.finalState = var2;
            this.emoji = var3;
            this.value = var4;
            this.successAnimationFrameNumber = var5;
        }

        @Override
        public int getConstructor() {
            return 1115779641;
        }
    }

    public static class MessageContact extends MessageContent {
        public Contact contact;
        public static final int CONSTRUCTOR = -512684966;

        public MessageContact() {
        }

        public MessageContact(Contact var1) {
            this.contact = var1;
        }

        @Override
        public int getConstructor() {
            return -512684966;
        }
    }

    public static class MessageVenue extends MessageContent {
        public Venue venue;
        public static final int CONSTRUCTOR = -2146492043;

        public MessageVenue() {
        }

        public MessageVenue(Venue var1) {
            this.venue = var1;
        }

        @Override
        public int getConstructor() {
            return -2146492043;
        }
    }

    public static class MessageLocation extends MessageContent {
        public Location location;
        public int livePeriod;
        public int expiresIn;
        public int heading;
        public int proximityAlertRadius;
        public static final int CONSTRUCTOR = 303973492;

        public MessageLocation() {
        }

        public MessageLocation(Location var1, int var2, int var3, int var4, int var5) {
            this.location = var1;
            this.livePeriod = var2;
            this.expiresIn = var3;
            this.heading = var4;
            this.proximityAlertRadius = var5;
        }

        @Override
        public int getConstructor() {
            return 303973492;
        }
    }

    public static class MessageVoiceNote extends MessageContent {
        public VoiceNote voiceNote;
        public FormattedText caption;
        public boolean isListened;
        public static final int CONSTRUCTOR = 527777781;

        public MessageVoiceNote() {
        }

        public MessageVoiceNote(VoiceNote var1, FormattedText var2, boolean var3) {
            this.voiceNote = var1;
            this.caption = var2;
            this.isListened = var3;
        }

        @Override
        public int getConstructor() {
            return 527777781;
        }
    }

    public static class MessageVideoNote extends MessageContent {
        public VideoNote videoNote;
        public boolean isViewed;
        public boolean isSecret;
        public static final int CONSTRUCTOR = 963323014;

        public MessageVideoNote() {
        }

        public MessageVideoNote(VideoNote var1, boolean var2, boolean var3) {
            this.videoNote = var1;
            this.isViewed = var2;
            this.isSecret = var3;
        }

        @Override
        public int getConstructor() {
            return 963323014;
        }
    }

    public static class MessageExpiredVideo extends MessageContent {
        public static final int CONSTRUCTOR = -1212209981;

        public MessageExpiredVideo() {
        }

        @Override
        public int getConstructor() {
            return -1212209981;
        }
    }

    public static class MessageVideo extends MessageContent {
        public Video video;
        public FormattedText caption;
        public boolean isSecret;
        public static final int CONSTRUCTOR = 2021281344;

        public MessageVideo() {
        }

        public MessageVideo(Video var1, FormattedText var2, boolean var3) {
            this.video = var1;
            this.caption = var2;
            this.isSecret = var3;
        }

        @Override
        public int getConstructor() {
            return 2021281344;
        }
    }

    public static class MessageSticker extends MessageContent {
        public Sticker sticker;
        public static final int CONSTRUCTOR = 1779022878;

        public MessageSticker() {
        }

        public MessageSticker(Sticker var1) {
            this.sticker = var1;
        }

        @Override
        public int getConstructor() {
            return 1779022878;
        }
    }

    public static class MessageExpiredPhoto extends MessageContent {
        public static final int CONSTRUCTOR = -1404641801;

        public MessageExpiredPhoto() {
        }

        @Override
        public int getConstructor() {
            return -1404641801;
        }
    }

    public static class MessagePhoto extends MessageContent {
        public Photo photo;
        public FormattedText caption;
        public boolean isSecret;
        public static final int CONSTRUCTOR = -1851395174;

        public MessagePhoto() {
        }

        public MessagePhoto(Photo var1, FormattedText var2, boolean var3) {
            this.photo = var1;
            this.caption = var2;
            this.isSecret = var3;
        }

        @Override
        public int getConstructor() {
            return -1851395174;
        }
    }

    public static class MessageDocument extends MessageContent {
        public Document document;
        public FormattedText caption;
        public static final int CONSTRUCTOR = 596945783;

        public MessageDocument() {
        }

        public MessageDocument(Document var1, FormattedText var2) {
            this.document = var1;
            this.caption = var2;
        }

        @Override
        public int getConstructor() {
            return 596945783;
        }
    }

    public static class MessageAudio extends MessageContent {
        public Audio audio;
        public FormattedText caption;
        public static final int CONSTRUCTOR = 276722716;

        public MessageAudio() {
        }

        public MessageAudio(Audio var1, FormattedText var2) {
            this.audio = var1;
            this.caption = var2;
        }

        @Override
        public int getConstructor() {
            return 276722716;
        }
    }

    public static class MessageAnimation extends MessageContent {
        public Animation animation;
        public FormattedText caption;
        public boolean isSecret;
        public static final int CONSTRUCTOR = 1306939396;

        public MessageAnimation() {
        }

        public MessageAnimation(Animation var1, FormattedText var2, boolean var3) {
            this.animation = var1;
            this.caption = var2;
            this.isSecret = var3;
        }

        @Override
        public int getConstructor() {
            return 1306939396;
        }
    }

    public static class MessageText extends MessageContent {
        public FormattedText text;
        public WebPage webPage;
        public static final int CONSTRUCTOR = 1989037971;

        public MessageText() {
        }

        public MessageText(FormattedText var1, WebPage var2) {
            this.text = var1;
            this.webPage = var2;
        }

        @Override
        public int getConstructor() {
            return 1989037971;
        }
    }

    public abstract static class MessageContent extends Object {
        public MessageContent() {
        }
    }

    public static class Message extends Object {
        public long id;
        public MessageSender sender;
        public long chatId;
        public MessageSendingState sendingState;
        public MessageSchedulingState schedulingState;
        public boolean isOutgoing;
        public boolean isPinned;
        public boolean canBeEdited;
        public boolean canBeForwarded;
        public boolean canBeDeletedOnlyForSelf;
        public boolean canBeDeletedForAllUsers;
        public boolean canGetStatistics;
        public boolean canGetMessageThread;
        public boolean canGetMediaTimestampLinks;
        public boolean hasTimestampedMedia;
        public boolean isChannelPost;
        public boolean containsUnreadMention;
        public int date;
        public int editDate;
        public MessageForwardInfo forwardInfo;
        public MessageInteractionInfo interactionInfo;
        public long replyInChatId;
        public long replyToMessageId;
        public long messageThreadId;
        public int ttl;
        public double ttlExpiresIn;
        public int viaBotUserId;
        public String authorSignature;
        public long mediaAlbumId;
        public String restrictionReason;
        public MessageContent content;
        public ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = -1212312080;

        public Message() {
        }

        public Message(long var1, MessageSender var3, long var4, MessageSendingState var6, MessageSchedulingState var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12, boolean var13, boolean var14, boolean var15, boolean var16, boolean var17, boolean var18, boolean var19, int var20, int var21, MessageForwardInfo var22, MessageInteractionInfo var23, long var24, long var26, long var28, int var30, double var31, int var33, String var34, long var35, String var37, MessageContent var38, ReplyMarkup var39) {
            this.id = var1;
            this.sender = var3;
            this.chatId = var4;
            this.sendingState = var6;
            this.schedulingState = var7;
            this.isOutgoing = var8;
            this.isPinned = var9;
            this.canBeEdited = var10;
            this.canBeForwarded = var11;
            this.canBeDeletedOnlyForSelf = var12;
            this.canBeDeletedForAllUsers = var13;
            this.canGetStatistics = var14;
            this.canGetMessageThread = var15;
            this.canGetMediaTimestampLinks = var16;
            this.hasTimestampedMedia = var17;
            this.isChannelPost = var18;
            this.containsUnreadMention = var19;
            this.date = var20;
            this.editDate = var21;
            this.forwardInfo = var22;
            this.interactionInfo = var23;
            this.replyInChatId = var24;
            this.replyToMessageId = var26;
            this.messageThreadId = var28;
            this.ttl = var30;
            this.ttlExpiresIn = var31;
            this.viaBotUserId = var33;
            this.authorSignature = var34;
            this.mediaAlbumId = var35;
            this.restrictionReason = var37;
            this.content = var38;
            this.replyMarkup = var39;
        }

        @Override
        public int getConstructor() {
            return -1212312080;
        }
    }

    public static class MaskPosition extends Object {
        public MaskPoint point;
        public double xShift;
        public double yShift;
        public double scale;
        public static final int CONSTRUCTOR = -2097433026;

        public MaskPosition() {
        }

        public MaskPosition(MaskPoint var1, double var2, double var4, double var6) {
            this.point = var1;
            this.xShift = var2;
            this.yShift = var4;
            this.scale = var6;
        }

        @Override
        public int getConstructor() {
            return -2097433026;
        }
    }

    public static class MaskPointChin extends MaskPoint {
        public static final int CONSTRUCTOR = 534995335;

        public MaskPointChin() {
        }

        @Override
        public int getConstructor() {
            return 534995335;
        }
    }

    public static class MaskPointMouth extends MaskPoint {
        public static final int CONSTRUCTOR = 411773406;

        public MaskPointMouth() {
        }

        @Override
        public int getConstructor() {
            return 411773406;
        }
    }

    public static class MaskPointEyes extends MaskPoint {
        public static final int CONSTRUCTOR = 1748310861;

        public MaskPointEyes() {
        }

        @Override
        public int getConstructor() {
            return 1748310861;
        }
    }

    public static class MaskPointForehead extends MaskPoint {
        public static final int CONSTRUCTOR = 1027512005;

        public MaskPointForehead() {
        }

        @Override
        public int getConstructor() {
            return 1027512005;
        }
    }

    public abstract static class MaskPoint extends Object {
        public MaskPoint() {
        }
    }

    public static class LoginUrlInfoRequestConfirmation extends LoginUrlInfo {
        public String url;
        public String domain;
        public int botUserId;
        public boolean requestWriteAccess;
        public static final int CONSTRUCTOR = -1761898342;

        public LoginUrlInfoRequestConfirmation() {
        }

        public LoginUrlInfoRequestConfirmation(String var1, String var2, int var3, boolean var4) {
            this.url = var1;
            this.domain = var2;
            this.botUserId = var3;
            this.requestWriteAccess = var4;
        }

        @Override
        public int getConstructor() {
            return -1761898342;
        }
    }

    public static class LoginUrlInfoOpen extends LoginUrlInfo {
        public String url;
        public boolean skipConfirm;
        public static final int CONSTRUCTOR = -1079045420;

        public LoginUrlInfoOpen() {
        }

        public LoginUrlInfoOpen(String var1, boolean var2) {
            this.url = var1;
            this.skipConfirm = var2;
        }

        @Override
        public int getConstructor() {
            return -1079045420;
        }
    }

    public abstract static class LoginUrlInfo extends Object {
        public LoginUrlInfo() {
        }
    }

    public static class LogVerbosityLevel extends Object {
        public int verbosityLevel;
        public static final int CONSTRUCTOR = 1734624234;

        public LogVerbosityLevel() {
        }

        public LogVerbosityLevel(int var1) {
            this.verbosityLevel = var1;
        }

        @Override
        public int getConstructor() {
            return 1734624234;
        }
    }

    public static class LogTags extends Object {
        public String[] tags;
        public static final int CONSTRUCTOR = -1604930601;

        public LogTags() {
        }

        public LogTags(String[] var1) {
            this.tags = var1;
        }

        @Override
        public int getConstructor() {
            return -1604930601;
        }
    }

    public static class LogStreamEmpty extends LogStream {
        public static final int CONSTRUCTOR = -499912244;

        public LogStreamEmpty() {
        }

        @Override
        public int getConstructor() {
            return -499912244;
        }
    }

    public static class LogStreamFile extends LogStream {
        public String path;
        public long maxFileSize;
        public boolean redirectStderr;
        public static final int CONSTRUCTOR = 1532136933;

        public LogStreamFile() {
        }

        public LogStreamFile(String var1, long var2, boolean var4) {
            this.path = var1;
            this.maxFileSize = var2;
            this.redirectStderr = var4;
        }

        @Override
        public int getConstructor() {
            return 1532136933;
        }
    }

    public static class LogStreamDefault extends LogStream {
        public static final int CONSTRUCTOR = 1390581436;

        public LogStreamDefault() {
        }

        @Override
        public int getConstructor() {
            return 1390581436;
        }
    }

    public abstract static class LogStream extends Object {
        public LogStream() {
        }
    }

    public static class Location extends Object {
        public double latitude;
        public double longitude;
        public double horizontalAccuracy;
        public static final int CONSTRUCTOR = -443392141;

        public Location() {
        }

        public Location(double var1, double var3, double var5) {
            this.latitude = var1;
            this.longitude = var3;
            this.horizontalAccuracy = var5;
        }

        @Override
        public int getConstructor() {
            return -443392141;
        }
    }

    public static class LocalizationTargetInfo extends Object {
        public LanguagePackInfo[] languagePacks;
        public static final int CONSTRUCTOR = -2048670809;

        public LocalizationTargetInfo() {
        }

        public LocalizationTargetInfo(LanguagePackInfo[] var1) {
            this.languagePacks = var1;
        }

        @Override
        public int getConstructor() {
            return -2048670809;
        }
    }

    public static class LocalFile extends Object {
        public String path;
        public boolean canBeDownloaded;
        public boolean canBeDeleted;
        public boolean isDownloadingActive;
        public boolean isDownloadingCompleted;
        public int downloadOffset;
        public int downloadedPrefixSize;
        public int downloadedSize;
        public static final int CONSTRUCTOR = -1166400317;

        public LocalFile() {
        }

        public LocalFile(String var1, boolean var2, boolean var3, boolean var4, boolean var5, int var6, int var7, int var8) {
            this.path = var1;
            this.canBeDownloaded = var2;
            this.canBeDeleted = var3;
            this.isDownloadingActive = var4;
            this.isDownloadingCompleted = var5;
            this.downloadOffset = var6;
            this.downloadedPrefixSize = var7;
            this.downloadedSize = var8;
        }

        @Override
        public int getConstructor() {
            return -1166400317;
        }
    }

    public static class LanguagePackStrings extends Object {
        public LanguagePackString[] strings;
        public static final int CONSTRUCTOR = 1172082922;

        public LanguagePackStrings() {
        }

        public LanguagePackStrings(LanguagePackString[] var1) {
            this.strings = var1;
        }

        @Override
        public int getConstructor() {
            return 1172082922;
        }
    }

    public static class LanguagePackStringValueDeleted extends LanguagePackStringValue {
        public static final int CONSTRUCTOR = 1834792698;

        public LanguagePackStringValueDeleted() {
        }

        @Override
        public int getConstructor() {
            return 1834792698;
        }
    }

    public static class LanguagePackStringValuePluralized extends LanguagePackStringValue {
        public String zeroValue;
        public String oneValue;
        public String twoValue;
        public String fewValue;
        public String manyValue;
        public String otherValue;
        public static final int CONSTRUCTOR = 1906840261;

        public LanguagePackStringValuePluralized() {
        }

        public LanguagePackStringValuePluralized(String var1, String var2, String var3, String var4, String var5, String var6) {
            this.zeroValue = var1;
            this.oneValue = var2;
            this.twoValue = var3;
            this.fewValue = var4;
            this.manyValue = var5;
            this.otherValue = var6;
        }

        @Override
        public int getConstructor() {
            return 1906840261;
        }
    }

    public static class LanguagePackStringValueOrdinary extends LanguagePackStringValue {
        public String value;
        public static final int CONSTRUCTOR = -249256352;

        public LanguagePackStringValueOrdinary() {
        }

        public LanguagePackStringValueOrdinary(String var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return -249256352;
        }
    }

    public abstract static class LanguagePackStringValue extends Object {
        public LanguagePackStringValue() {
        }
    }

    public static class LanguagePackString extends Object {
        public String key;
        public LanguagePackStringValue value;
        public static final int CONSTRUCTOR = 1307632736;

        public LanguagePackString() {
        }

        public LanguagePackString(String var1, LanguagePackStringValue var2) {
            this.key = var1;
            this.value = var2;
        }

        @Override
        public int getConstructor() {
            return 1307632736;
        }
    }

    public static class LanguagePackInfo extends Object {
        public String id;
        public String baseLanguagePackId;
        public String name;
        public String nativeName;
        public String pluralCode;
        public boolean isOfficial;
        public boolean isRtl;
        public boolean isBeta;
        public boolean isInstalled;
        public int totalStringCount;
        public int translatedStringCount;
        public int localStringCount;
        public String translationUrl;
        public static final int CONSTRUCTOR = 542199642;

        public LanguagePackInfo() {
        }

        public LanguagePackInfo(String var1, String var2, String var3, String var4, String var5, boolean var6, boolean var7, boolean var8, boolean var9, int var10, int var11, int var12, String var13) {
            this.id = var1;
            this.baseLanguagePackId = var2;
            this.name = var3;
            this.nativeName = var4;
            this.pluralCode = var5;
            this.isOfficial = var6;
            this.isRtl = var7;
            this.isBeta = var8;
            this.isInstalled = var9;
            this.totalStringCount = var10;
            this.translatedStringCount = var11;
            this.localStringCount = var12;
            this.translationUrl = var13;
        }

        @Override
        public int getConstructor() {
            return 542199642;
        }
    }

    public static class LabeledPricePart extends Object {
        public String label;
        public long amount;
        public static final int CONSTRUCTOR = 552789798;

        public LabeledPricePart() {
        }

        public LabeledPricePart(String var1, long var2) {
            this.label = var1;
            this.amount = var2;
        }

        @Override
        public int getConstructor() {
            return 552789798;
        }
    }

    public static class KeyboardButtonTypeRequestPoll extends KeyboardButtonType {
        public boolean forceRegular;
        public boolean forceQuiz;
        public static final int CONSTRUCTOR = 1902435512;

        public KeyboardButtonTypeRequestPoll() {
        }

        public KeyboardButtonTypeRequestPoll(boolean var1, boolean var2) {
            this.forceRegular = var1;
            this.forceQuiz = var2;
        }

        @Override
        public int getConstructor() {
            return 1902435512;
        }
    }

    public static class KeyboardButtonTypeRequestLocation extends KeyboardButtonType {
        public static final int CONSTRUCTOR = -125661955;

        public KeyboardButtonTypeRequestLocation() {
        }

        @Override
        public int getConstructor() {
            return -125661955;
        }
    }

    public static class KeyboardButtonTypeRequestPhoneNumber extends KeyboardButtonType {
        public static final int CONSTRUCTOR = -1529235527;

        public KeyboardButtonTypeRequestPhoneNumber() {
        }

        @Override
        public int getConstructor() {
            return -1529235527;
        }
    }

    public static class KeyboardButtonTypeText extends KeyboardButtonType {
        public static final int CONSTRUCTOR = -1773037256;

        public KeyboardButtonTypeText() {
        }

        @Override
        public int getConstructor() {
            return -1773037256;
        }
    }

    public abstract static class KeyboardButtonType extends Object {
        public KeyboardButtonType() {
        }
    }

    public static class KeyboardButton extends Object {
        public String text;
        public KeyboardButtonType type;
        public static final int CONSTRUCTOR = -2069836172;

        public KeyboardButton() {
        }

        public KeyboardButton(String var1, KeyboardButtonType var2) {
            this.text = var1;
            this.type = var2;
        }

        @Override
        public int getConstructor() {
            return -2069836172;
        }
    }

    public static class JsonValueObject extends JsonValue {
        public JsonObjectMember[] members;
        public static final int CONSTRUCTOR = 520252026;

        public JsonValueObject() {
        }

        public JsonValueObject(JsonObjectMember[] var1) {
            this.members = var1;
        }

        @Override
        public int getConstructor() {
            return 520252026;
        }
    }

    public static class JsonValueArray extends JsonValue {
        public JsonValue[] values;
        public static final int CONSTRUCTOR = -183913546;

        public JsonValueArray() {
        }

        public JsonValueArray(JsonValue[] var1) {
            this.values = var1;
        }

        @Override
        public int getConstructor() {
            return -183913546;
        }
    }

    public static class JsonValueString extends JsonValue {
        public String value;
        public static final int CONSTRUCTOR = 1597947313;

        public JsonValueString() {
        }

        public JsonValueString(String var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return 1597947313;
        }
    }

    public static class JsonValueNumber extends JsonValue {
        public double value;
        public static final int CONSTRUCTOR = -1010822033;

        public JsonValueNumber() {
        }

        public JsonValueNumber(double var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return -1010822033;
        }
    }

    public static class JsonValueBoolean extends JsonValue {
        public boolean value;
        public static final int CONSTRUCTOR = -2142186576;

        public JsonValueBoolean() {
        }

        public JsonValueBoolean(boolean var1) {
            this.value = var1;
        }

        @Override
        public int getConstructor() {
            return -2142186576;
        }
    }

    public static class JsonValueNull extends JsonValue {
        public static final int CONSTRUCTOR = -92872499;

        public JsonValueNull() {
        }

        @Override
        public int getConstructor() {
            return -92872499;
        }
    }

    public abstract static class JsonValue extends Object {
        public JsonValue() {
        }
    }

    public static class JsonObjectMember extends Object {
        public String key;
        public JsonValue value;
        public static final int CONSTRUCTOR = -1803309418;

        public JsonObjectMember() {
        }

        public JsonObjectMember(String var1, JsonValue var2) {
            this.key = var1;
            this.value = var2;
        }

        @Override
        public int getConstructor() {
            return -1803309418;
        }
    }

    public static class Invoice extends Object {
        public String currency;
        public LabeledPricePart[] priceParts;
        public long maxTipAmount;
        public long[] suggestedTipAmounts;
        public boolean isTest;
        public boolean needName;
        public boolean needPhoneNumber;
        public boolean needEmailAddress;
        public boolean needShippingAddress;
        public boolean sendPhoneNumberToProvider;
        public boolean sendEmailAddressToProvider;
        public boolean isFlexible;
        public static final int CONSTRUCTOR = 1479250728;

        public Invoice() {
        }

        public Invoice(String var1, LabeledPricePart[] var2, long var3, long[] var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12, boolean var13) {
            this.currency = var1;
            this.priceParts = var2;
            this.maxTipAmount = var3;
            this.suggestedTipAmounts = var5;
            this.isTest = var6;
            this.needName = var7;
            this.needPhoneNumber = var8;
            this.needEmailAddress = var9;
            this.needShippingAddress = var10;
            this.sendPhoneNumberToProvider = var11;
            this.sendEmailAddressToProvider = var12;
            this.isFlexible = var13;
        }

        @Override
        public int getConstructor() {
            return 1479250728;
        }
    }

    public static class InternalLinkTypeVoiceChat extends InternalLinkType {
        public String chatUsername;
        public String inviteHash;
        public boolean isLiveStream;
        public static final int CONSTRUCTOR = 2122812666;

        public InternalLinkTypeVoiceChat() {
        }

        public InternalLinkTypeVoiceChat(String var1, String var2, boolean var3) {
            this.chatUsername = var1;
            this.inviteHash = var2;
            this.isLiveStream = var3;
        }

        @Override
        public int getConstructor() {
            return 2122812666;
        }
    }

    public static class InternalLinkTypeUnknownDeepLink extends InternalLinkType {
        public String link;
        public static final int CONSTRUCTOR = 625596379;

        public InternalLinkTypeUnknownDeepLink() {
        }

        public InternalLinkTypeUnknownDeepLink(String var1) {
            this.link = var1;
        }

        @Override
        public int getConstructor() {
            return 625596379;
        }
    }

    public static class InternalLinkTypeThemeSettings extends InternalLinkType {
        public static final int CONSTRUCTOR = -1051903722;

        public InternalLinkTypeThemeSettings() {
        }

        @Override
        public int getConstructor() {
            return -1051903722;
        }
    }

    public static class InternalLinkTypeTheme extends InternalLinkType {
        public String themeName;
        public static final int CONSTRUCTOR = -200935417;

        public InternalLinkTypeTheme() {
        }

        public InternalLinkTypeTheme(String var1) {
            this.themeName = var1;
        }

        @Override
        public int getConstructor() {
            return -200935417;
        }
    }

    public static class InternalLinkTypeStickerSet extends InternalLinkType {
        public String stickerSetName;
        public static final int CONSTRUCTOR = -529639751;

        public InternalLinkTypeStickerSet() {
        }

        public InternalLinkTypeStickerSet(String var1) {
            this.stickerSetName = var1;
        }

        @Override
        public int getConstructor() {
            return -529639751;
        }
    }

    public static class InternalLinkTypeSettings extends InternalLinkType {
        public static final int CONSTRUCTOR = 393561524;

        public InternalLinkTypeSettings() {
        }

        @Override
        public int getConstructor() {
            return 393561524;
        }
    }

    public static class InternalLinkTypeQrCodeAuthentication extends InternalLinkType {
        public static final int CONSTRUCTOR = -1089332956;

        public InternalLinkTypeQrCodeAuthentication() {
        }

        @Override
        public int getConstructor() {
            return -1089332956;
        }
    }

    public static class InternalLinkTypePublicChat extends InternalLinkType {
        public String chatUsername;
        public static final int CONSTRUCTOR = -1485547717;

        public InternalLinkTypePublicChat() {
        }

        public InternalLinkTypePublicChat(String var1) {
            this.chatUsername = var1;
        }

        @Override
        public int getConstructor() {
            return -1485547717;
        }
    }

    public static class InternalLinkTypeProxy extends InternalLinkType {
        public String server;
        public int port;
        public ProxyType type;
        public static final int CONSTRUCTOR = -1313788694;

        public InternalLinkTypeProxy() {
        }

        public InternalLinkTypeProxy(String var1, int var2, ProxyType var3) {
            this.server = var1;
            this.port = var2;
            this.type = var3;
        }

        @Override
        public int getConstructor() {
            return -1313788694;
        }
    }

    public static class InternalLinkTypePhoneNumberConfirmation extends InternalLinkType {
        public String hash;
        public String phoneNumber;
        public static final int CONSTRUCTOR = 1757375254;

        public InternalLinkTypePhoneNumberConfirmation() {
        }

        public InternalLinkTypePhoneNumberConfirmation(String var1, String var2) {
            this.hash = var1;
            this.phoneNumber = var2;
        }

        @Override
        public int getConstructor() {
            return 1757375254;
        }
    }

    public static class InternalLinkTypePassportDataRequest extends InternalLinkType {
        public int botUserId;
        public String scope;
        public String publicKey;
        public String nonce;
        public String callbackUrl;
        public static final int CONSTRUCTOR = -1509382840;

        public InternalLinkTypePassportDataRequest() {
        }

        public InternalLinkTypePassportDataRequest(int var1, String var2, String var3, String var4, String var5) {
            this.botUserId = var1;
            this.scope = var2;
            this.publicKey = var3;
            this.nonce = var4;
            this.callbackUrl = var5;
        }

        @Override
        public int getConstructor() {
            return -1509382840;
        }
    }

    public static class InternalLinkTypeMessageDraft extends InternalLinkType {
        public FormattedText text;
        public boolean containsLink;
        public static final int CONSTRUCTOR = 661633749;

        public InternalLinkTypeMessageDraft() {
        }

        public InternalLinkTypeMessageDraft(FormattedText var1, boolean var2) {
            this.text = var1;
            this.containsLink = var2;
        }

        @Override
        public int getConstructor() {
            return 661633749;
        }
    }

    public static class InternalLinkTypeMessage extends InternalLinkType {
        public String url;
        public static final int CONSTRUCTOR = 978541650;

        public InternalLinkTypeMessage() {
        }

        public InternalLinkTypeMessage(String var1) {
            this.url = var1;
        }

        @Override
        public int getConstructor() {
            return 978541650;
        }
    }

    public static class InternalLinkTypeLanguagePack extends InternalLinkType {
        public String languagePackId;
        public static final int CONSTRUCTOR = -1450766996;

        public InternalLinkTypeLanguagePack() {
        }

        public InternalLinkTypeLanguagePack(String var1) {
            this.languagePackId = var1;
        }

        @Override
        public int getConstructor() {
            return -1450766996;
        }
    }

    public static class InternalLinkTypeGame extends InternalLinkType {
        public String botUsername;
        public String gameShortName;
        public static final int CONSTRUCTOR = -260788787;

        public InternalLinkTypeGame() {
        }

        public InternalLinkTypeGame(String var1, String var2) {
            this.botUsername = var1;
            this.gameShortName = var2;
        }

        @Override
        public int getConstructor() {
            return -260788787;
        }
    }

    public static class InternalLinkTypeFilterSettings extends InternalLinkType {
        public static final int CONSTRUCTOR = 1501632411;

        public InternalLinkTypeFilterSettings() {
        }

        @Override
        public int getConstructor() {
            return 1501632411;
        }
    }

    public static class InternalLinkTypeChatInvite extends InternalLinkType {
        public String inviteLink;
        public static final int CONSTRUCTOR = 428621017;

        public InternalLinkTypeChatInvite() {
        }

        public InternalLinkTypeChatInvite(String var1) {
            this.inviteLink = var1;
        }

        @Override
        public int getConstructor() {
            return 428621017;
        }
    }

    public static class InternalLinkTypeChangePhoneNumber extends InternalLinkType {
        public static final int CONSTRUCTOR = -265856255;

        public InternalLinkTypeChangePhoneNumber() {
        }

        @Override
        public int getConstructor() {
            return -265856255;
        }
    }

    public static class InternalLinkTypeBotStartInGroup extends InternalLinkType {
        public String botUsername;
        public String startParameter;
        public static final int CONSTRUCTOR = -1040096100;

        public InternalLinkTypeBotStartInGroup() {
        }

        public InternalLinkTypeBotStartInGroup(String var1, String var2) {
            this.botUsername = var1;
            this.startParameter = var2;
        }

        @Override
        public int getConstructor() {
            return -1040096100;
        }
    }

    public static class InternalLinkTypeBotStart extends InternalLinkType {
        public String botUsername;
        public String startParameter;
        public static final int CONSTRUCTOR = -1206724291;

        public InternalLinkTypeBotStart() {
        }

        public InternalLinkTypeBotStart(String var1, String var2) {
            this.botUsername = var1;
            this.startParameter = var2;
        }

        @Override
        public int getConstructor() {
            return -1206724291;
        }
    }

    public static class InternalLinkTypeBackground extends InternalLinkType {
        public String backgroundName;
        public static final int CONSTRUCTOR = 185411848;

        public InternalLinkTypeBackground() {
        }

        public InternalLinkTypeBackground(String var1) {
            this.backgroundName = var1;
        }

        @Override
        public int getConstructor() {
            return 185411848;
        }
    }

    public static class InternalLinkTypeAuthenticationCode extends InternalLinkType {
        public String code;
        public static final int CONSTRUCTOR = -209235982;

        public InternalLinkTypeAuthenticationCode() {
        }

        public InternalLinkTypeAuthenticationCode(String var1) {
            this.code = var1;
        }

        @Override
        public int getConstructor() {
            return -209235982;
        }
    }

    public static class InternalLinkTypeActiveSessions extends InternalLinkType {
        public static final int CONSTRUCTOR = 1886108589;

        public InternalLinkTypeActiveSessions() {
        }

        @Override
        public int getConstructor() {
            return 1886108589;
        }
    }

    public abstract static class InternalLinkType extends Object {
        public InternalLinkType() {
        }
    }

    public static class InputThumbnail extends Object {
        public InputFile thumbnail;
        public int width;
        public int height;
        public static final int CONSTRUCTOR = 1582387236;

        public InputThumbnail() {
        }

        public InputThumbnail(InputFile var1, int var2, int var3) {
            this.thumbnail = var1;
            this.width = var2;
            this.height = var3;
        }

        @Override
        public int getConstructor() {
            return 1582387236;
        }
    }

    public static class InputStickerAnimated extends InputSticker {
        public InputFile sticker;
        public String emojis;
        public static final int CONSTRUCTOR = -1127265952;

        public InputStickerAnimated() {
        }

        public InputStickerAnimated(InputFile var1, String var2) {
            this.sticker = var1;
            this.emojis = var2;
        }

        @Override
        public int getConstructor() {
            return -1127265952;
        }
    }

    public static class InputStickerStatic extends InputSticker {
        public InputFile sticker;
        public String emojis;
        public MaskPosition maskPosition;
        public static final int CONSTRUCTOR = 1409680603;

        public InputStickerStatic() {
        }

        public InputStickerStatic(InputFile var1, String var2, MaskPosition var3) {
            this.sticker = var1;
            this.emojis = var2;
            this.maskPosition = var3;
        }

        @Override
        public int getConstructor() {
            return 1409680603;
        }
    }

    public abstract static class InputSticker extends Object {
        public InputSticker() {
        }
    }

    public static class InputPersonalDocument extends Object {
        public InputFile[] files;
        public InputFile[] translation;
        public static final int CONSTRUCTOR = 1676966826;

        public InputPersonalDocument() {
        }

        public InputPersonalDocument(InputFile[] var1, InputFile[] var2) {
            this.files = var1;
            this.translation = var2;
        }

        @Override
        public int getConstructor() {
            return 1676966826;
        }
    }

    public static class InputPassportElementErrorSourceFiles extends InputPassportElementErrorSource {
        public byte[][] fileHashes;
        public static final int CONSTRUCTOR = -2008541640;

        public InputPassportElementErrorSourceFiles() {
        }

        public InputPassportElementErrorSourceFiles(byte[][] var1) {
            this.fileHashes = var1;
        }

        @Override
        public int getConstructor() {
            return -2008541640;
        }
    }

    public static class InputPassportElementErrorSourceFile extends InputPassportElementErrorSource {
        public byte[] fileHash;
        public static final int CONSTRUCTOR = -298492469;

        public InputPassportElementErrorSourceFile() {
        }

        public InputPassportElementErrorSourceFile(byte[] var1) {
            this.fileHash = var1;
        }

        @Override
        public int getConstructor() {
            return -298492469;
        }
    }

    public static class InputPassportElementErrorSourceTranslationFiles extends InputPassportElementErrorSource {
        public byte[][] fileHashes;
        public static final int CONSTRUCTOR = -527254048;

        public InputPassportElementErrorSourceTranslationFiles() {
        }

        public InputPassportElementErrorSourceTranslationFiles(byte[][] var1) {
            this.fileHashes = var1;
        }

        @Override
        public int getConstructor() {
            return -527254048;
        }
    }

    public static class InputPassportElementErrorSourceTranslationFile extends InputPassportElementErrorSource {
        public byte[] fileHash;
        public static final int CONSTRUCTOR = 505842299;

        public InputPassportElementErrorSourceTranslationFile() {
        }

        public InputPassportElementErrorSourceTranslationFile(byte[] var1) {
            this.fileHash = var1;
        }

        @Override
        public int getConstructor() {
            return 505842299;
        }
    }

    public static class InputPassportElementErrorSourceSelfie extends InputPassportElementErrorSource {
        public byte[] fileHash;
        public static final int CONSTRUCTOR = -773575528;

        public InputPassportElementErrorSourceSelfie() {
        }

        public InputPassportElementErrorSourceSelfie(byte[] var1) {
            this.fileHash = var1;
        }

        @Override
        public int getConstructor() {
            return -773575528;
        }
    }

    public static class InputPassportElementErrorSourceReverseSide extends InputPassportElementErrorSource {
        public byte[] fileHash;
        public static final int CONSTRUCTOR = 413072891;

        public InputPassportElementErrorSourceReverseSide() {
        }

        public InputPassportElementErrorSourceReverseSide(byte[] var1) {
            this.fileHash = var1;
        }

        @Override
        public int getConstructor() {
            return 413072891;
        }
    }

    public static class InputPassportElementErrorSourceFrontSide extends InputPassportElementErrorSource {
        public byte[] fileHash;
        public static final int CONSTRUCTOR = 588023741;

        public InputPassportElementErrorSourceFrontSide() {
        }

        public InputPassportElementErrorSourceFrontSide(byte[] var1) {
            this.fileHash = var1;
        }

        @Override
        public int getConstructor() {
            return 588023741;
        }
    }

    public static class InputPassportElementErrorSourceDataField extends InputPassportElementErrorSource {
        public String fieldName;
        public byte[] dataHash;
        public static final int CONSTRUCTOR = -426795002;

        public InputPassportElementErrorSourceDataField() {
        }

        public InputPassportElementErrorSourceDataField(String var1, byte[] var2) {
            this.fieldName = var1;
            this.dataHash = var2;
        }

        @Override
        public int getConstructor() {
            return -426795002;
        }
    }

    public static class InputPassportElementErrorSourceUnspecified extends InputPassportElementErrorSource {
        public byte[] elementHash;
        public static final int CONSTRUCTOR = 267230319;

        public InputPassportElementErrorSourceUnspecified() {
        }

        public InputPassportElementErrorSourceUnspecified(byte[] var1) {
            this.elementHash = var1;
        }

        @Override
        public int getConstructor() {
            return 267230319;
        }
    }

    public abstract static class InputPassportElementErrorSource extends Object {
        public InputPassportElementErrorSource() {
        }
    }

    public static class InputPassportElementError extends Object {
        public PassportElementType type;
        public String message;
        public InputPassportElementErrorSource source;
        public static final int CONSTRUCTOR = 285756898;

        public InputPassportElementError() {
        }

        public InputPassportElementError(PassportElementType var1, String var2, InputPassportElementErrorSource var3) {
            this.type = var1;
            this.message = var2;
            this.source = var3;
        }

        @Override
        public int getConstructor() {
            return 285756898;
        }
    }

    public static class InputPassportElementEmailAddress extends InputPassportElement {
        public String emailAddress;
        public static final int CONSTRUCTOR = -248605659;

        public InputPassportElementEmailAddress() {
        }

        public InputPassportElementEmailAddress(String var1) {
            this.emailAddress = var1;
        }

        @Override
        public int getConstructor() {
            return -248605659;
        }
    }

    public static class InputPassportElementPhoneNumber extends InputPassportElement {
        public String phoneNumber;
        public static final int CONSTRUCTOR = 1319357497;

        public InputPassportElementPhoneNumber() {
        }

        public InputPassportElementPhoneNumber(String var1) {
            this.phoneNumber = var1;
        }

        @Override
        public int getConstructor() {
            return 1319357497;
        }
    }

    public static class InputPassportElementTemporaryRegistration extends InputPassportElement {
        public InputPersonalDocument temporaryRegistration;
        public static final int CONSTRUCTOR = -1913238047;

        public InputPassportElementTemporaryRegistration() {
        }

        public InputPassportElementTemporaryRegistration(InputPersonalDocument var1) {
            this.temporaryRegistration = var1;
        }

        @Override
        public int getConstructor() {
            return -1913238047;
        }
    }

    public static class InputPassportElementPassportRegistration extends InputPassportElement {
        public InputPersonalDocument passportRegistration;
        public static final int CONSTRUCTOR = 1314562128;

        public InputPassportElementPassportRegistration() {
        }

        public InputPassportElementPassportRegistration(InputPersonalDocument var1) {
            this.passportRegistration = var1;
        }

        @Override
        public int getConstructor() {
            return 1314562128;
        }
    }

    public static class InputPassportElementRentalAgreement extends InputPassportElement {
        public InputPersonalDocument rentalAgreement;
        public static final int CONSTRUCTOR = 1736154155;

        public InputPassportElementRentalAgreement() {
        }

        public InputPassportElementRentalAgreement(InputPersonalDocument var1) {
            this.rentalAgreement = var1;
        }

        @Override
        public int getConstructor() {
            return 1736154155;
        }
    }

    public static class InputPassportElementBankStatement extends InputPassportElement {
        public InputPersonalDocument bankStatement;
        public static final int CONSTRUCTOR = -26585208;

        public InputPassportElementBankStatement() {
        }

        public InputPassportElementBankStatement(InputPersonalDocument var1) {
            this.bankStatement = var1;
        }

        @Override
        public int getConstructor() {
            return -26585208;
        }
    }

    public static class InputPassportElementUtilityBill extends InputPassportElement {
        public InputPersonalDocument utilityBill;
        public static final int CONSTRUCTOR = 1389203841;

        public InputPassportElementUtilityBill() {
        }

        public InputPassportElementUtilityBill(InputPersonalDocument var1) {
            this.utilityBill = var1;
        }

        @Override
        public int getConstructor() {
            return 1389203841;
        }
    }

    public static class InputPassportElementAddress extends InputPassportElement {
        public Address address;
        public static final int CONSTRUCTOR = 461630480;

        public InputPassportElementAddress() {
        }

        public InputPassportElementAddress(Address var1) {
            this.address = var1;
        }

        @Override
        public int getConstructor() {
            return 461630480;
        }
    }

    public static class InputPassportElementInternalPassport extends InputPassportElement {
        public InputIdentityDocument internalPassport;
        public static final int CONSTRUCTOR = 715360043;

        public InputPassportElementInternalPassport() {
        }

        public InputPassportElementInternalPassport(InputIdentityDocument var1) {
            this.internalPassport = var1;
        }

        @Override
        public int getConstructor() {
            return 715360043;
        }
    }

    public static class InputPassportElementIdentityCard extends InputPassportElement {
        public InputIdentityDocument identityCard;
        public static final int CONSTRUCTOR = -9963390;

        public InputPassportElementIdentityCard() {
        }

        public InputPassportElementIdentityCard(InputIdentityDocument var1) {
            this.identityCard = var1;
        }

        @Override
        public int getConstructor() {
            return -9963390;
        }
    }

    public static class InputPassportElementDriverLicense extends InputPassportElement {
        public InputIdentityDocument driverLicense;
        public static final int CONSTRUCTOR = 304813264;

        public InputPassportElementDriverLicense() {
        }

        public InputPassportElementDriverLicense(InputIdentityDocument var1) {
            this.driverLicense = var1;
        }

        @Override
        public int getConstructor() {
            return 304813264;
        }
    }

    public static class InputPassportElementPassport extends InputPassportElement {
        public InputIdentityDocument passport;
        public static final int CONSTRUCTOR = -497011356;

        public InputPassportElementPassport() {
        }

        public InputPassportElementPassport(InputIdentityDocument var1) {
            this.passport = var1;
        }

        @Override
        public int getConstructor() {
            return -497011356;
        }
    }

    public static class InputPassportElementPersonalDetails extends InputPassportElement {
        public PersonalDetails personalDetails;
        public static final int CONSTRUCTOR = 164791359;

        public InputPassportElementPersonalDetails() {
        }

        public InputPassportElementPersonalDetails(PersonalDetails var1) {
            this.personalDetails = var1;
        }

        @Override
        public int getConstructor() {
            return 164791359;
        }
    }

    public abstract static class InputPassportElement extends Object {
        public InputPassportElement() {
        }
    }

    public static class InputMessageForwarded extends InputMessageContent {
        public long fromChatId;
        public long messageId;
        public boolean inGameShare;
        public MessageCopyOptions copyOptions;
        public static final int CONSTRUCTOR = 1696232440;

        public InputMessageForwarded() {
        }

        public InputMessageForwarded(long var1, long var3, boolean var5, MessageCopyOptions var6) {
            this.fromChatId = var1;
            this.messageId = var3;
            this.inGameShare = var5;
            this.copyOptions = var6;
        }

        @Override
        public int getConstructor() {
            return 1696232440;
        }
    }

    public static class InputMessagePoll extends InputMessageContent {
        public String question;
        public String[] options;
        public boolean isAnonymous;
        public PollType type;
        public int openPeriod;
        public int closeDate;
        public boolean isClosed;
        public static final int CONSTRUCTOR = 2054629900;

        public InputMessagePoll() {
        }

        public InputMessagePoll(String var1, String[] var2, boolean var3, PollType var4, int var5, int var6, boolean var7) {
            this.question = var1;
            this.options = var2;
            this.isAnonymous = var3;
            this.type = var4;
            this.openPeriod = var5;
            this.closeDate = var6;
            this.isClosed = var7;
        }

        @Override
        public int getConstructor() {
            return 2054629900;
        }
    }

    public static class InputMessageInvoice extends InputMessageContent {
        public Invoice invoice;
        public String title;
        public String description;
        public String photoUrl;
        public int photoSize;
        public int photoWidth;
        public int photoHeight;
        public byte[] payload;
        public String providerToken;
        public String providerData;
        public String startParameter;
        public static final int CONSTRUCTOR = 1038812175;

        public InputMessageInvoice() {
        }

        public InputMessageInvoice(Invoice var1, String var2, String var3, String var4, int var5, int var6, int var7, byte[] var8, String var9, String var10, String var11) {
            this.invoice = var1;
            this.title = var2;
            this.description = var3;
            this.photoUrl = var4;
            this.photoSize = var5;
            this.photoWidth = var6;
            this.photoHeight = var7;
            this.payload = var8;
            this.providerToken = var9;
            this.providerData = var10;
            this.startParameter = var11;
        }

        @Override
        public int getConstructor() {
            return 1038812175;
        }
    }

    public static class InputMessageGame extends InputMessageContent {
        public int botUserId;
        public String gameShortName;
        public static final int CONSTRUCTOR = -1728000914;

        public InputMessageGame() {
        }

        public InputMessageGame(int var1, String var2) {
            this.botUserId = var1;
            this.gameShortName = var2;
        }

        @Override
        public int getConstructor() {
            return -1728000914;
        }
    }

    public static class InputMessageDice extends InputMessageContent {
        public String emoji;
        public boolean clearDraft;
        public static final int CONSTRUCTOR = 841574313;

        public InputMessageDice() {
        }

        public InputMessageDice(String var1, boolean var2) {
            this.emoji = var1;
            this.clearDraft = var2;
        }

        @Override
        public int getConstructor() {
            return 841574313;
        }
    }

    public static class InputMessageContact extends InputMessageContent {
        public Contact contact;
        public static final int CONSTRUCTOR = -982446849;

        public InputMessageContact() {
        }

        public InputMessageContact(Contact var1) {
            this.contact = var1;
        }

        @Override
        public int getConstructor() {
            return -982446849;
        }
    }

    public static class InputMessageVenue extends InputMessageContent {
        public Venue venue;
        public static final int CONSTRUCTOR = 1447926269;

        public InputMessageVenue() {
        }

        public InputMessageVenue(Venue var1) {
            this.venue = var1;
        }

        @Override
        public int getConstructor() {
            return 1447926269;
        }
    }

    public static class InputMessageLocation extends InputMessageContent {
        public Location location;
        public int livePeriod;
        public int heading;
        public int proximityAlertRadius;
        public static final int CONSTRUCTOR = 648735088;

        public InputMessageLocation() {
        }

        public InputMessageLocation(Location var1, int var2, int var3, int var4) {
            this.location = var1;
            this.livePeriod = var2;
            this.heading = var3;
            this.proximityAlertRadius = var4;
        }

        @Override
        public int getConstructor() {
            return 648735088;
        }
    }

    public static class InputMessageVoiceNote extends InputMessageContent {
        public InputFile voiceNote;
        public int duration;
        public byte[] waveform;
        public FormattedText caption;
        public static final int CONSTRUCTOR = 2136519657;

        public InputMessageVoiceNote() {
        }

        public InputMessageVoiceNote(InputFile var1, int var2, byte[] var3, FormattedText var4) {
            this.voiceNote = var1;
            this.duration = var2;
            this.waveform = var3;
            this.caption = var4;
        }

        @Override
        public int getConstructor() {
            return 2136519657;
        }
    }

    public static class InputMessageVideoNote extends InputMessageContent {
        public InputFile videoNote;
        public InputThumbnail thumbnail;
        public int duration;
        public int length;
        public static final int CONSTRUCTOR = 279108859;

        public InputMessageVideoNote() {
        }

        public InputMessageVideoNote(InputFile var1, InputThumbnail var2, int var3, int var4) {
            this.videoNote = var1;
            this.thumbnail = var2;
            this.duration = var3;
            this.length = var4;
        }

        @Override
        public int getConstructor() {
            return 279108859;
        }
    }

    public static class InputMessageVideo extends InputMessageContent {
        public InputFile video;
        public InputThumbnail thumbnail;
        public int[] addedStickerFileIds;
        public int duration;
        public int width;
        public int height;
        public boolean supportsStreaming;
        public FormattedText caption;
        public int ttl;
        public static final int CONSTRUCTOR = -2108486755;

        public InputMessageVideo() {
        }

        public InputMessageVideo(InputFile var1, InputThumbnail var2, int[] var3, int var4, int var5, int var6, boolean var7, FormattedText var8, int var9) {
            this.video = var1;
            this.thumbnail = var2;
            this.addedStickerFileIds = var3;
            this.duration = var4;
            this.width = var5;
            this.height = var6;
            this.supportsStreaming = var7;
            this.caption = var8;
            this.ttl = var9;
        }

        @Override
        public int getConstructor() {
            return -2108486755;
        }
    }

    public static class InputMessageSticker extends InputMessageContent {
        public InputFile sticker;
        public InputThumbnail thumbnail;
        public int width;
        public int height;
        public String emoji;
        public static final int CONSTRUCTOR = 1072805625;

        public InputMessageSticker() {
        }

        public InputMessageSticker(InputFile var1, InputThumbnail var2, int var3, int var4, String var5) {
            this.sticker = var1;
            this.thumbnail = var2;
            this.width = var3;
            this.height = var4;
            this.emoji = var5;
        }

        @Override
        public int getConstructor() {
            return 1072805625;
        }
    }

    public static class InputMessagePhoto extends InputMessageContent {
        public InputFile photo;
        public InputThumbnail thumbnail;
        public int[] addedStickerFileIds;
        public int width;
        public int height;
        public FormattedText caption;
        public int ttl;
        public static final int CONSTRUCTOR = 1648801584;

        public InputMessagePhoto() {
        }

        public InputMessagePhoto(InputFile var1, InputThumbnail var2, int[] var3, int var4, int var5, FormattedText var6, int var7) {
            this.photo = var1;
            this.thumbnail = var2;
            this.addedStickerFileIds = var3;
            this.width = var4;
            this.height = var5;
            this.caption = var6;
            this.ttl = var7;
        }

        @Override
        public int getConstructor() {
            return 1648801584;
        }
    }

    public static class InputMessageDocument extends InputMessageContent {
        public InputFile document;
        public InputThumbnail thumbnail;
        public boolean disableContentTypeDetection;
        public FormattedText caption;
        public static final int CONSTRUCTOR = 1633383097;

        public InputMessageDocument() {
        }

        public InputMessageDocument(InputFile var1, InputThumbnail var2, boolean var3, FormattedText var4) {
            this.document = var1;
            this.thumbnail = var2;
            this.disableContentTypeDetection = var3;
            this.caption = var4;
        }

        @Override
        public int getConstructor() {
            return 1633383097;
        }
    }

    public static class InputMessageAudio extends InputMessageContent {
        public InputFile audio;
        public InputThumbnail albumCoverThumbnail;
        public int duration;
        public String title;
        public String performer;
        public FormattedText caption;
        public static final int CONSTRUCTOR = -626786126;

        public InputMessageAudio() {
        }

        public InputMessageAudio(InputFile var1, InputThumbnail var2, int var3, String var4, String var5, FormattedText var6) {
            this.audio = var1;
            this.albumCoverThumbnail = var2;
            this.duration = var3;
            this.title = var4;
            this.performer = var5;
            this.caption = var6;
        }

        @Override
        public int getConstructor() {
            return -626786126;
        }
    }

    public static class InputMessageAnimation extends InputMessageContent {
        public InputFile animation;
        public InputThumbnail thumbnail;
        public int[] addedStickerFileIds;
        public int duration;
        public int width;
        public int height;
        public FormattedText caption;
        public static final int CONSTRUCTOR = 1208433535;

        public InputMessageAnimation() {
        }

        public InputMessageAnimation(InputFile var1, InputThumbnail var2, int[] var3, int var4, int var5, int var6, FormattedText var7) {
            this.animation = var1;
            this.thumbnail = var2;
            this.addedStickerFileIds = var3;
            this.duration = var4;
            this.width = var5;
            this.height = var6;
            this.caption = var7;
        }

        @Override
        public int getConstructor() {
            return 1208433535;
        }
    }

    public static class InputMessageText extends InputMessageContent {
        public FormattedText text;
        public boolean disableWebPagePreview;
        public boolean clearDraft;
        public static final int CONSTRUCTOR = 247050392;

        public InputMessageText() {
        }

        public InputMessageText(FormattedText var1, boolean var2, boolean var3) {
            this.text = var1;
            this.disableWebPagePreview = var2;
            this.clearDraft = var3;
        }

        @Override
        public int getConstructor() {
            return 247050392;
        }
    }

    public abstract static class InputMessageContent extends Object {
        public InputMessageContent() {
        }
    }

    public static class InputInlineQueryResultVoiceNote extends InputInlineQueryResult {
        public String id;
        public String title;
        public String voiceNoteUrl;
        public int voiceNoteDuration;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -1790072503;

        public InputInlineQueryResultVoiceNote() {
        }

        public InputInlineQueryResultVoiceNote(String var1, String var2, String var3, int var4, ReplyMarkup var5, InputMessageContent var6) {
            this.id = var1;
            this.title = var2;
            this.voiceNoteUrl = var3;
            this.voiceNoteDuration = var4;
            this.replyMarkup = var5;
            this.inputMessageContent = var6;
        }

        @Override
        public int getConstructor() {
            return -1790072503;
        }
    }

    public static class InputInlineQueryResultVideo extends InputInlineQueryResult {
        public String id;
        public String title;
        public String description;
        public String thumbnailUrl;
        public String videoUrl;
        public String mimeType;
        public int videoWidth;
        public int videoHeight;
        public int videoDuration;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 1724073191;

        public InputInlineQueryResultVideo() {
        }

        public InputInlineQueryResultVideo(String var1, String var2, String var3, String var4, String var5, String var6, int var7, int var8, int var9, ReplyMarkup var10, InputMessageContent var11) {
            this.id = var1;
            this.title = var2;
            this.description = var3;
            this.thumbnailUrl = var4;
            this.videoUrl = var5;
            this.mimeType = var6;
            this.videoWidth = var7;
            this.videoHeight = var8;
            this.videoDuration = var9;
            this.replyMarkup = var10;
            this.inputMessageContent = var11;
        }

        @Override
        public int getConstructor() {
            return 1724073191;
        }
    }

    public static class InputInlineQueryResultVenue extends InputInlineQueryResult {
        public String id;
        public Venue venue;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 541704509;

        public InputInlineQueryResultVenue() {
        }

        public InputInlineQueryResultVenue(String var1, Venue var2, String var3, int var4, int var5, ReplyMarkup var6, InputMessageContent var7) {
            this.id = var1;
            this.venue = var2;
            this.thumbnailUrl = var3;
            this.thumbnailWidth = var4;
            this.thumbnailHeight = var5;
            this.replyMarkup = var6;
            this.inputMessageContent = var7;
        }

        @Override
        public int getConstructor() {
            return 541704509;
        }
    }

    public static class InputInlineQueryResultSticker extends InputInlineQueryResult {
        public String id;
        public String thumbnailUrl;
        public String stickerUrl;
        public int stickerWidth;
        public int stickerHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 274007129;

        public InputInlineQueryResultSticker() {
        }

        public InputInlineQueryResultSticker(String var1, String var2, String var3, int var4, int var5, ReplyMarkup var6, InputMessageContent var7) {
            this.id = var1;
            this.thumbnailUrl = var2;
            this.stickerUrl = var3;
            this.stickerWidth = var4;
            this.stickerHeight = var5;
            this.replyMarkup = var6;
            this.inputMessageContent = var7;
        }

        @Override
        public int getConstructor() {
            return 274007129;
        }
    }

    public static class InputInlineQueryResultPhoto extends InputInlineQueryResult {
        public String id;
        public String title;
        public String description;
        public String thumbnailUrl;
        public String photoUrl;
        public int photoWidth;
        public int photoHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -1123338721;

        public InputInlineQueryResultPhoto() {
        }

        public InputInlineQueryResultPhoto(String var1, String var2, String var3, String var4, String var5, int var6, int var7, ReplyMarkup var8, InputMessageContent var9) {
            this.id = var1;
            this.title = var2;
            this.description = var3;
            this.thumbnailUrl = var4;
            this.photoUrl = var5;
            this.photoWidth = var6;
            this.photoHeight = var7;
            this.replyMarkup = var8;
            this.inputMessageContent = var9;
        }

        @Override
        public int getConstructor() {
            return -1123338721;
        }
    }

    public static class InputInlineQueryResultLocation extends InputInlineQueryResult {
        public String id;
        public Location location;
        public int livePeriod;
        public String title;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -1887650218;

        public InputInlineQueryResultLocation() {
        }

        public InputInlineQueryResultLocation(String var1, Location var2, int var3, String var4, String var5, int var6, int var7, ReplyMarkup var8, InputMessageContent var9) {
            this.id = var1;
            this.location = var2;
            this.livePeriod = var3;
            this.title = var4;
            this.thumbnailUrl = var5;
            this.thumbnailWidth = var6;
            this.thumbnailHeight = var7;
            this.replyMarkup = var8;
            this.inputMessageContent = var9;
        }

        @Override
        public int getConstructor() {
            return -1887650218;
        }
    }

    public static class InputInlineQueryResultGame extends InputInlineQueryResult {
        public String id;
        public String gameShortName;
        public ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = 966074327;

        public InputInlineQueryResultGame() {
        }

        public InputInlineQueryResultGame(String var1, String var2, ReplyMarkup var3) {
            this.id = var1;
            this.gameShortName = var2;
            this.replyMarkup = var3;
        }

        @Override
        public int getConstructor() {
            return 966074327;
        }
    }

    public static class InputInlineQueryResultDocument extends InputInlineQueryResult {
        public String id;
        public String title;
        public String description;
        public String documentUrl;
        public String mimeType;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 578801869;

        public InputInlineQueryResultDocument() {
        }

        public InputInlineQueryResultDocument(String var1, String var2, String var3, String var4, String var5, String var6, int var7, int var8, ReplyMarkup var9, InputMessageContent var10) {
            this.id = var1;
            this.title = var2;
            this.description = var3;
            this.documentUrl = var4;
            this.mimeType = var5;
            this.thumbnailUrl = var6;
            this.thumbnailWidth = var7;
            this.thumbnailHeight = var8;
            this.replyMarkup = var9;
            this.inputMessageContent = var10;
        }

        @Override
        public int getConstructor() {
            return 578801869;
        }
    }

    public static class InputInlineQueryResultContact extends InputInlineQueryResult {
        public String id;
        public Contact contact;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 1846064594;

        public InputInlineQueryResultContact() {
        }

        public InputInlineQueryResultContact(String var1, Contact var2, String var3, int var4, int var5, ReplyMarkup var6, InputMessageContent var7) {
            this.id = var1;
            this.contact = var2;
            this.thumbnailUrl = var3;
            this.thumbnailWidth = var4;
            this.thumbnailHeight = var5;
            this.replyMarkup = var6;
            this.inputMessageContent = var7;
        }

        @Override
        public int getConstructor() {
            return 1846064594;
        }
    }

    public static class InputInlineQueryResultAudio extends InputInlineQueryResult {
        public String id;
        public String title;
        public String performer;
        public String audioUrl;
        public int audioDuration;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 1260139988;

        public InputInlineQueryResultAudio() {
        }

        public InputInlineQueryResultAudio(String var1, String var2, String var3, String var4, int var5, ReplyMarkup var6, InputMessageContent var7) {
            this.id = var1;
            this.title = var2;
            this.performer = var3;
            this.audioUrl = var4;
            this.audioDuration = var5;
            this.replyMarkup = var6;
            this.inputMessageContent = var7;
        }

        @Override
        public int getConstructor() {
            return 1260139988;
        }
    }

    public static class InputInlineQueryResultArticle extends InputInlineQueryResult {
        public String id;
        public String url;
        public boolean hideUrl;
        public String title;
        public String description;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 1973670156;

        public InputInlineQueryResultArticle() {
        }

        public InputInlineQueryResultArticle(String var1, String var2, boolean var3, String var4, String var5, String var6, int var7, int var8, ReplyMarkup var9, InputMessageContent var10) {
            this.id = var1;
            this.url = var2;
            this.hideUrl = var3;
            this.title = var4;
            this.description = var5;
            this.thumbnailUrl = var6;
            this.thumbnailWidth = var7;
            this.thumbnailHeight = var8;
            this.replyMarkup = var9;
            this.inputMessageContent = var10;
        }

        @Override
        public int getConstructor() {
            return 1973670156;
        }
    }

    public static class InputInlineQueryResultAnimation extends InputInlineQueryResult {
        public String id;
        public String title;
        public String thumbnailUrl;
        public String thumbnailMimeType;
        public String videoUrl;
        public String videoMimeType;
        public int videoDuration;
        public int videoWidth;
        public int videoHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -1489808874;

        public InputInlineQueryResultAnimation() {
        }

        public InputInlineQueryResultAnimation(String var1, String var2, String var3, String var4, String var5, String var6, int var7, int var8, int var9, ReplyMarkup var10, InputMessageContent var11) {
            this.id = var1;
            this.title = var2;
            this.thumbnailUrl = var3;
            this.thumbnailMimeType = var4;
            this.videoUrl = var5;
            this.videoMimeType = var6;
            this.videoDuration = var7;
            this.videoWidth = var8;
            this.videoHeight = var9;
            this.replyMarkup = var10;
            this.inputMessageContent = var11;
        }

        @Override
        public int getConstructor() {
            return -1489808874;
        }
    }

    public abstract static class InputInlineQueryResult extends Object {
        public InputInlineQueryResult() {
        }
    }

    public static class InputIdentityDocument extends Object {
        public String number;
        public Date expiryDate;
        public InputFile frontSide;
        public InputFile reverseSide;
        public InputFile selfie;
        public InputFile[] translation;
        public static final int CONSTRUCTOR = -381776063;

        public InputIdentityDocument() {
        }

        public InputIdentityDocument(String var1, Date var2, InputFile var3, InputFile var4, InputFile var5, InputFile[] var6) {
            this.number = var1;
            this.expiryDate = var2;
            this.frontSide = var3;
            this.reverseSide = var4;
            this.selfie = var5;
            this.translation = var6;
        }

        @Override
        public int getConstructor() {
            return -381776063;
        }
    }

    public static class InputFileGenerated extends InputFile {
        public String originalPath;
        public String conversion;
        public int expectedSize;
        public static final int CONSTRUCTOR = -1781351885;

        public InputFileGenerated() {
        }

        public InputFileGenerated(String var1, String var2, int var3) {
            this.originalPath = var1;
            this.conversion = var2;
            this.expectedSize = var3;
        }

        @Override
        public int getConstructor() {
            return -1781351885;
        }
    }

    public static class InputFileLocal extends InputFile {
        public String path;
        public static final int CONSTRUCTOR = 2056030919;

        public InputFileLocal() {
        }

        public InputFileLocal(String var1) {
            this.path = var1;
        }

        @Override
        public int getConstructor() {
            return 2056030919;
        }
    }

    public static class InputFileRemote extends InputFile {
        public String id;
        public static final int CONSTRUCTOR = -107574466;

        public InputFileRemote() {
        }

        public InputFileRemote(String var1) {
            this.id = var1;
        }

        @Override
        public int getConstructor() {
            return -107574466;
        }
    }

    public static class InputFileId extends InputFile {
        public int id;
        public static final int CONSTRUCTOR = 1788906253;

        public InputFileId() {
        }

        public InputFileId(int var1) {
            this.id = var1;
        }

        @Override
        public int getConstructor() {
            return 1788906253;
        }
    }

    public abstract static class InputFile extends Object {
        public InputFile() {
        }
    }

    public static class InputCredentialsGooglePay extends InputCredentials {
        public String data;
        public static final int CONSTRUCTOR = 844384100;

        public InputCredentialsGooglePay() {
        }

        public InputCredentialsGooglePay(String var1) {
            this.data = var1;
        }

        @Override
        public int getConstructor() {
            return 844384100;
        }
    }

    public static class InputCredentialsApplePay extends InputCredentials {
        public String data;
        public static final int CONSTRUCTOR = -1246570799;

        public InputCredentialsApplePay() {
        }

        public InputCredentialsApplePay(String var1) {
            this.data = var1;
        }

        @Override
        public int getConstructor() {
            return -1246570799;
        }
    }

    public static class InputCredentialsNew extends InputCredentials {
        public String data;
        public boolean allowSave;
        public static final int CONSTRUCTOR = -829689558;

        public InputCredentialsNew() {
        }

        public InputCredentialsNew(String var1, boolean var2) {
            this.data = var1;
            this.allowSave = var2;
        }

        @Override
        public int getConstructor() {
            return -829689558;
        }
    }

    public static class InputCredentialsSaved extends InputCredentials {
        public String savedCredentialsId;
        public static final int CONSTRUCTOR = -2034385364;

        public InputCredentialsSaved() {
        }

        public InputCredentialsSaved(String var1) {
            this.savedCredentialsId = var1;
        }

        @Override
        public int getConstructor() {
            return -2034385364;
        }
    }

    public abstract static class InputCredentials extends Object {
        public InputCredentials() {
        }
    }

    public static class InputChatPhotoAnimation extends InputChatPhoto {
        public InputFile animation;
        public double mainFrameTimestamp;
        public static final int CONSTRUCTOR = 90846242;

        public InputChatPhotoAnimation() {
        }

        public InputChatPhotoAnimation(InputFile var1, double var2) {
            this.animation = var1;
            this.mainFrameTimestamp = var2;
        }

        @Override
        public int getConstructor() {
            return 90846242;
        }
    }

    public static class InputChatPhotoStatic extends InputChatPhoto {
        public InputFile photo;
        public static final int CONSTRUCTOR = 1979179699;

        public InputChatPhotoStatic() {
        }

        public InputChatPhotoStatic(InputFile var1) {
            this.photo = var1;
        }

        @Override
        public int getConstructor() {
            return 1979179699;
        }
    }

    public static class InputChatPhotoPrevious extends InputChatPhoto {
        public long chatPhotoId;
        public static final int CONSTRUCTOR = 23128529;

        public InputChatPhotoPrevious() {
        }

        public InputChatPhotoPrevious(long var1) {
            this.chatPhotoId = var1;
        }

        @Override
        public int getConstructor() {
            return 23128529;
        }
    }

    public abstract static class InputChatPhoto extends Object {
        public InputChatPhoto() {
        }
    }

    public static class InputBackgroundRemote extends InputBackground {
        public long backgroundId;
        public static final int CONSTRUCTOR = -274976231;

        public InputBackgroundRemote() {
        }

        public InputBackgroundRemote(long var1) {
            this.backgroundId = var1;
        }

        @Override
        public int getConstructor() {
            return -274976231;
        }
    }

    public static class InputBackgroundLocal extends InputBackground {
        public InputFile background;
        public static final int CONSTRUCTOR = -1747094364;

        public InputBackgroundLocal() {
        }

        public InputBackgroundLocal(InputFile var1) {
            this.background = var1;
        }

        @Override
        public int getConstructor() {
            return -1747094364;
        }
    }

    public abstract static class InputBackground extends Object {
        public InputBackground() {
        }
    }

    public static class InlineQueryResults extends Object {
        public long inlineQueryId;
        public String nextOffset;
        public InlineQueryResult[] results;
        public String switchPmText;
        public String switchPmParameter;
        public static final int CONSTRUCTOR = 1000709656;

        public InlineQueryResults() {
        }

        public InlineQueryResults(long var1, String var3, InlineQueryResult[] var4, String var5, String var6) {
            this.inlineQueryId = var1;
            this.nextOffset = var3;
            this.results = var4;
            this.switchPmText = var5;
            this.switchPmParameter = var6;
        }

        @Override
        public int getConstructor() {
            return 1000709656;
        }
    }

    public static class InlineQueryResultVoiceNote extends InlineQueryResult {
        public String id;
        public VoiceNote voiceNote;
        public String title;
        public static final int CONSTRUCTOR = -1897393105;

        public InlineQueryResultVoiceNote() {
        }

        public InlineQueryResultVoiceNote(String var1, VoiceNote var2, String var3) {
            this.id = var1;
            this.voiceNote = var2;
            this.title = var3;
        }

        @Override
        public int getConstructor() {
            return -1897393105;
        }
    }

    public static class InlineQueryResultVideo extends InlineQueryResult {
        public String id;
        public Video video;
        public String title;
        public String description;
        public static final int CONSTRUCTOR = -1373158683;

        public InlineQueryResultVideo() {
        }

        public InlineQueryResultVideo(String var1, Video var2, String var3, String var4) {
            this.id = var1;
            this.video = var2;
            this.title = var3;
            this.description = var4;
        }

        @Override
        public int getConstructor() {
            return -1373158683;
        }
    }

    public static class InlineQueryResultSticker extends InlineQueryResult {
        public String id;
        public Sticker sticker;
        public static final int CONSTRUCTOR = -1848224245;

        public InlineQueryResultSticker() {
        }

        public InlineQueryResultSticker(String var1, Sticker var2) {
            this.id = var1;
            this.sticker = var2;
        }

        @Override
        public int getConstructor() {
            return -1848224245;
        }
    }

    public static class InlineQueryResultPhoto extends InlineQueryResult {
        public String id;
        public Photo photo;
        public String title;
        public String description;
        public static final int CONSTRUCTOR = 1848319440;

        public InlineQueryResultPhoto() {
        }

        public InlineQueryResultPhoto(String var1, Photo var2, String var3, String var4) {
            this.id = var1;
            this.photo = var2;
            this.title = var3;
            this.description = var4;
        }

        @Override
        public int getConstructor() {
            return 1848319440;
        }
    }

    public static class InlineQueryResultDocument extends InlineQueryResult {
        public String id;
        public Document document;
        public String title;
        public String description;
        public static final int CONSTRUCTOR = -1491268539;

        public InlineQueryResultDocument() {
        }

        public InlineQueryResultDocument(String var1, Document var2, String var3, String var4) {
            this.id = var1;
            this.document = var2;
            this.title = var3;
            this.description = var4;
        }

        @Override
        public int getConstructor() {
            return -1491268539;
        }
    }

    public static class InlineQueryResultAudio extends InlineQueryResult {
        public String id;
        public Audio audio;
        public static final int CONSTRUCTOR = 842650360;

        public InlineQueryResultAudio() {
        }

        public InlineQueryResultAudio(String var1, Audio var2) {
            this.id = var1;
            this.audio = var2;
        }

        @Override
        public int getConstructor() {
            return 842650360;
        }
    }

    public static class InlineQueryResultAnimation extends InlineQueryResult {
        public String id;
        public Animation animation;
        public String title;
        public static final int CONSTRUCTOR = 2009984267;

        public InlineQueryResultAnimation() {
        }

        public InlineQueryResultAnimation(String var1, Animation var2, String var3) {
            this.id = var1;
            this.animation = var2;
            this.title = var3;
        }

        @Override
        public int getConstructor() {
            return 2009984267;
        }
    }

    public static class InlineQueryResultGame extends InlineQueryResult {
        public String id;
        public Game game;
        public static final int CONSTRUCTOR = 1706916987;

        public InlineQueryResultGame() {
        }

        public InlineQueryResultGame(String var1, Game var2) {
            this.id = var1;
            this.game = var2;
        }

        @Override
        public int getConstructor() {
            return 1706916987;
        }
    }

    public static class InlineQueryResultVenue extends InlineQueryResult {
        public String id;
        public Venue venue;
        public Thumbnail thumbnail;
        public static final int CONSTRUCTOR = 1281036382;

        public InlineQueryResultVenue() {
        }

        public InlineQueryResultVenue(String var1, Venue var2, Thumbnail var3) {
            this.id = var1;
            this.venue = var2;
            this.thumbnail = var3;
        }

        @Override
        public int getConstructor() {
            return 1281036382;
        }
    }

    public static class InlineQueryResultLocation extends InlineQueryResult {
        public String id;
        public Location location;
        public String title;
        public Thumbnail thumbnail;
        public static final int CONSTRUCTOR = 466004752;

        public InlineQueryResultLocation() {
        }

        public InlineQueryResultLocation(String var1, Location var2, String var3, Thumbnail var4) {
            this.id = var1;
            this.location = var2;
            this.title = var3;
            this.thumbnail = var4;
        }

        @Override
        public int getConstructor() {
            return 466004752;
        }
    }

    public static class InlineQueryResultContact extends InlineQueryResult {
        public String id;
        public Contact contact;
        public Thumbnail thumbnail;
        public static final int CONSTRUCTOR = -181960174;

        public InlineQueryResultContact() {
        }

        public InlineQueryResultContact(String var1, Contact var2, Thumbnail var3) {
            this.id = var1;
            this.contact = var2;
            this.thumbnail = var3;
        }

        @Override
        public int getConstructor() {
            return -181960174;
        }
    }

    public static class InlineQueryResultArticle extends InlineQueryResult {
        public String id;
        public String url;
        public boolean hideUrl;
        public String title;
        public String description;
        public Thumbnail thumbnail;
        public static final int CONSTRUCTOR = 206340825;

        public InlineQueryResultArticle() {
        }

        public InlineQueryResultArticle(String var1, String var2, boolean var3, String var4, String var5, Thumbnail var6) {
            this.id = var1;
            this.url = var2;
            this.hideUrl = var3;
            this.title = var4;
            this.description = var5;
            this.thumbnail = var6;
        }

        @Override
        public int getConstructor() {
            return 206340825;
        }
    }

    public abstract static class InlineQueryResult extends Object {
        public InlineQueryResult() {
        }
    }

    public static class InlineKeyboardButtonTypeBuy extends InlineKeyboardButtonType {
        public static final int CONSTRUCTOR = 1360739440;

        public InlineKeyboardButtonTypeBuy() {
        }

        @Override
        public int getConstructor() {
            return 1360739440;
        }
    }

    public static class InlineKeyboardButtonTypeSwitchInline extends InlineKeyboardButtonType {
        public String query;
        public boolean inCurrentChat;
        public static final int CONSTRUCTOR = -2035563307;

        public InlineKeyboardButtonTypeSwitchInline() {
        }

        public InlineKeyboardButtonTypeSwitchInline(String var1, boolean var2) {
            this.query = var1;
            this.inCurrentChat = var2;
        }

        @Override
        public int getConstructor() {
            return -2035563307;
        }
    }

    public static class InlineKeyboardButtonTypeCallbackGame extends InlineKeyboardButtonType {
        public static final int CONSTRUCTOR = -383429528;

        public InlineKeyboardButtonTypeCallbackGame() {
        }

        @Override
        public int getConstructor() {
            return -383429528;
        }
    }

    public static class InlineKeyboardButtonTypeCallbackWithPassword extends InlineKeyboardButtonType {
        public byte[] data;
        public static final int CONSTRUCTOR = 908018248;

        public InlineKeyboardButtonTypeCallbackWithPassword() {
        }

        public InlineKeyboardButtonTypeCallbackWithPassword(byte[] var1) {
            this.data = var1;
        }

        @Override
        public int getConstructor() {
            return 908018248;
        }
    }

    public static class InlineKeyboardButtonTypeCallback extends InlineKeyboardButtonType {
        public byte[] data;
        public static final int CONSTRUCTOR = -1127515139;

        public InlineKeyboardButtonTypeCallback() {
        }

        public InlineKeyboardButtonTypeCallback(byte[] var1) {
            this.data = var1;
        }

        @Override
        public int getConstructor() {
            return -1127515139;
        }
    }

    public static class InlineKeyboardButtonTypeLoginUrl extends InlineKeyboardButtonType {
        public String url;
        public int id;
        public String forwardText;
        public static final int CONSTRUCTOR = 281435539;

        public InlineKeyboardButtonTypeLoginUrl() {
        }

        public InlineKeyboardButtonTypeLoginUrl(String var1, int var2, String var3) {
            this.url = var1;
            this.id = var2;
            this.forwardText = var3;
        }

        @Override
        public int getConstructor() {
            return 281435539;
        }
    }

    public static class InlineKeyboardButtonTypeUrl extends InlineKeyboardButtonType {
        public String url;
        public static final int CONSTRUCTOR = 1130741420;

        public InlineKeyboardButtonTypeUrl() {
        }

        public InlineKeyboardButtonTypeUrl(String var1) {
            this.url = var1;
        }

        @Override
        public int getConstructor() {
            return 1130741420;
        }
    }

    public abstract static class InlineKeyboardButtonType extends Object {
        public InlineKeyboardButtonType() {
        }
    }

    public static class InlineKeyboardButton extends Object {
        public String text;
        public InlineKeyboardButtonType type;
        public static final int CONSTRUCTOR = -372105704;

        public InlineKeyboardButton() {
        }

        public InlineKeyboardButton(String var1, InlineKeyboardButtonType var2) {
            this.text = var1;
            this.type = var2;
        }

        @Override
        public int getConstructor() {
            return -372105704;
        }
    }

    public static class ImportedContacts extends Object {
        public int[] userIds;
        public int[] importerCount;
        public static final int CONSTRUCTOR = -741685354;

        public ImportedContacts() {
        }

        public ImportedContacts(int[] var1, int[] var2) {
            this.userIds = var1;
            this.importerCount = var2;
        }

        @Override
        public int getConstructor() {
            return -741685354;
        }
    }

    public static class IdentityDocument extends Object {
        public String number;
        public Date expiryDate;
        public DatedFile frontSide;
        public DatedFile reverseSide;
        public DatedFile selfie;
        public DatedFile[] translation;
        public static final int CONSTRUCTOR = 445952972;

        public IdentityDocument() {
        }

        public IdentityDocument(String var1, Date var2, DatedFile var3, DatedFile var4, DatedFile var5, DatedFile[] var6) {
            this.number = var1;
            this.expiryDate = var2;
            this.frontSide = var3;
            this.reverseSide = var4;
            this.selfie = var5;
            this.translation = var6;
        }

        @Override
        public int getConstructor() {
            return 445952972;
        }
    }

    public static class HttpUrl extends Object {
        public String url;
        public static final int CONSTRUCTOR = -2018019930;

        public HttpUrl() {
        }

        public HttpUrl(String var1) {
            this.url = var1;
        }

        @Override
        public int getConstructor() {
            return -2018019930;
        }
    }

    public static class Hashtags extends Object {
        public String[] hashtags;
        public static final int CONSTRUCTOR = 676798885;

        public Hashtags() {
        }

        public Hashtags(String[] var1) {
            this.hashtags = var1;
        }

        @Override
        public int getConstructor() {
            return 676798885;
        }
    }

    public static class GroupCallVideoSourceGroup extends Object {
        public String semantics;
        public int[] sourceIds;
        public static final int CONSTRUCTOR = -1190900785;

        public GroupCallVideoSourceGroup() {
        }

        public GroupCallVideoSourceGroup(String var1, int[] var2) {
            this.semantics = var1;
            this.sourceIds = var2;
        }

        @Override
        public int getConstructor() {
            return -1190900785;
        }
    }

    public static class GroupCallVideoQualityFull extends GroupCallVideoQuality {
        public static final int CONSTRUCTOR = -2125916617;

        public GroupCallVideoQualityFull() {
        }

        @Override
        public int getConstructor() {
            return -2125916617;
        }
    }

    public static class GroupCallVideoQualityMedium extends GroupCallVideoQuality {
        public static final int CONSTRUCTOR = 394968234;

        public GroupCallVideoQualityMedium() {
        }

        @Override
        public int getConstructor() {
            return 394968234;
        }
    }

    public static class GroupCallVideoQualityThumbnail extends GroupCallVideoQuality {
        public static final int CONSTRUCTOR = -379186304;

        public GroupCallVideoQualityThumbnail() {
        }

        @Override
        public int getConstructor() {
            return -379186304;
        }
    }

    public abstract static class GroupCallVideoQuality extends Object {
        public GroupCallVideoQuality() {
        }
    }

    public static class GroupCallRecentSpeaker extends Object {
        public MessageSender participantId;
        public boolean isSpeaking;
        public static final int CONSTRUCTOR = 1819519436;

        public GroupCallRecentSpeaker() {
        }

        public GroupCallRecentSpeaker(MessageSender var1, boolean var2) {
            this.participantId = var1;
            this.isSpeaking = var2;
        }

        @Override
        public int getConstructor() {
            return 1819519436;
        }
    }

    public static class GroupCallParticipantVideoInfo extends Object {
        public GroupCallVideoSourceGroup[] sourceGroups;
        public String endpointId;
        public boolean isPaused;
        public static final int CONSTRUCTOR = -14294645;

        public GroupCallParticipantVideoInfo() {
        }

        public GroupCallParticipantVideoInfo(GroupCallVideoSourceGroup[] var1, String var2, boolean var3) {
            this.sourceGroups = var1;
            this.endpointId = var2;
            this.isPaused = var3;
        }

        @Override
        public int getConstructor() {
            return -14294645;
        }
    }

    public static class GroupCallParticipant extends Object {
        public MessageSender participantId;
        public int audioSourceId;
        public int screenSharingAudioSourceId;
        public GroupCallParticipantVideoInfo videoInfo;
        public GroupCallParticipantVideoInfo screenSharingVideoInfo;
        public String bio;
        public boolean isCurrentUser;
        public boolean isSpeaking;
        public boolean isHandRaised;
        public boolean canBeMutedForAllUsers;
        public boolean canBeUnmutedForAllUsers;
        public boolean canBeMutedForCurrentUser;
        public boolean canBeUnmutedForCurrentUser;
        public boolean isMutedForAllUsers;
        public boolean isMutedForCurrentUser;
        public boolean canUnmuteSelf;
        public int volumeLevel;
        public String order;
        public static final int CONSTRUCTOR = 2059182571;

        public GroupCallParticipant() {
        }

        public GroupCallParticipant(MessageSender var1, int var2, int var3, GroupCallParticipantVideoInfo var4, GroupCallParticipantVideoInfo var5, String var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12, boolean var13, boolean var14, boolean var15, boolean var16, int var17, String var18) {
            this.participantId = var1;
            this.audioSourceId = var2;
            this.screenSharingAudioSourceId = var3;
            this.videoInfo = var4;
            this.screenSharingVideoInfo = var5;
            this.bio = var6;
            this.isCurrentUser = var7;
            this.isSpeaking = var8;
            this.isHandRaised = var9;
            this.canBeMutedForAllUsers = var10;
            this.canBeUnmutedForAllUsers = var11;
            this.canBeMutedForCurrentUser = var12;
            this.canBeUnmutedForCurrentUser = var13;
            this.isMutedForAllUsers = var14;
            this.isMutedForCurrentUser = var15;
            this.canUnmuteSelf = var16;
            this.volumeLevel = var17;
            this.order = var18;
        }

        @Override
        public int getConstructor() {
            return 2059182571;
        }
    }

    public static class GroupCallId extends Object {
        public int id;
        public static final int CONSTRUCTOR = 350534469;

        public GroupCallId() {
        }

        public GroupCallId(int var1) {
            this.id = var1;
        }

        @Override
        public int getConstructor() {
            return 350534469;
        }
    }

    public static class GroupCall extends Object {
        public int id;
        public String title;
        public int scheduledStartDate;
        public boolean enabledStartNotification;
        public boolean isActive;
        public boolean isJoined;
        public boolean needRejoin;
        public boolean canBeManaged;
        public int participantCount;
        public boolean loadedAllParticipants;
        public GroupCallRecentSpeaker[] recentSpeakers;
        public boolean isMyVideoEnabled;
        public boolean isMyVideoPaused;
        public boolean canEnableVideo;
        public boolean muteNewParticipants;
        public boolean canChangeMuteNewParticipants;
        public int recordDuration;
        public boolean isVideoRecorded;
        public int duration;
        public static final int CONSTRUCTOR = 1603639190;

        public GroupCall() {
        }

        public GroupCall(int var1, String var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, int var9, boolean var10, GroupCallRecentSpeaker[] var11, boolean var12, boolean var13, boolean var14, boolean var15, boolean var16, int var17, boolean var18, int var19) {
            this.id = var1;
            this.title = var2;
            this.scheduledStartDate = var3;
            this.enabledStartNotification = var4;
            this.isActive = var5;
            this.isJoined = var6;
            this.needRejoin = var7;
            this.canBeManaged = var8;
            this.participantCount = var9;
            this.loadedAllParticipants = var10;
            this.recentSpeakers = var11;
            this.isMyVideoEnabled = var12;
            this.isMyVideoPaused = var13;
            this.canEnableVideo = var14;
            this.muteNewParticipants = var15;
            this.canChangeMuteNewParticipants = var16;
            this.recordDuration = var17;
            this.isVideoRecorded = var18;
            this.duration = var19;
        }

        @Override
        public int getConstructor() {
            return 1603639190;
        }
    }

    public static class GameHighScores extends Object {
        public GameHighScore[] scores;
        public static final int CONSTRUCTOR = -725770727;

        public GameHighScores() {
        }

        public GameHighScores(GameHighScore[] var1) {
            this.scores = var1;
        }

        @Override
        public int getConstructor() {
            return -725770727;
        }
    }

    public static class GameHighScore extends Object {
        public int position;
        public int userId;
        public int score;
        public static final int CONSTRUCTOR = -30778358;

        public GameHighScore() {
        }

        public GameHighScore(int var1, int var2, int var3) {
            this.position = var1;
            this.userId = var2;
            this.score = var3;
        }

        @Override
        public int getConstructor() {
            return -30778358;
        }
    }

    public static class Game extends Object {
        public long id;
        public String shortName;
        public String title;
        public FormattedText text;
        public String description;
        public Photo photo;
        public Animation animation;
        public static final int CONSTRUCTOR = -1565597752;

        public Game() {
        }

        public Game(long var1, String var3, String var4, FormattedText var5, String var6, Photo var7, Animation var8) {
            this.id = var1;
            this.shortName = var3;
            this.title = var4;
            this.text = var5;
            this.description = var6;
            this.photo = var7;
            this.animation = var8;
        }

        @Override
        public int getConstructor() {
            return -1565597752;
        }
    }

    public static class FoundMessages extends Object {
        public int totalCount;
        public Message[] messages;
        public String nextOffset;
        public static final int CONSTRUCTOR = -529809608;

        public FoundMessages() {
        }

        public FoundMessages(int var1, Message[] var2, String var3) {
            this.totalCount = var1;
            this.messages = var2;
            this.nextOffset = var3;
        }

        @Override
        public int getConstructor() {
            return -529809608;
        }
    }

    public static class FormattedText extends Object {
        public String text;
        public TextEntity[] entities;
        public static final int CONSTRUCTOR = -252624564;

        public FormattedText() {
        }

        public FormattedText(String var1, TextEntity[] var2) {
            this.text = var1;
            this.entities = var2;
        }

        @Override
        public int getConstructor() {
            return -252624564;
        }
    }

    public static class FileTypeWallpaper extends FileType {
        public static final int CONSTRUCTOR = 1854930076;

        public FileTypeWallpaper() {
        }

        @Override
        public int getConstructor() {
            return 1854930076;
        }
    }

    public static class FileTypeVoiceNote extends FileType {
        public static final int CONSTRUCTOR = -588681661;

        public FileTypeVoiceNote() {
        }

        @Override
        public int getConstructor() {
            return -588681661;
        }
    }

    public static class FileTypeVideoNote extends FileType {
        public static final int CONSTRUCTOR = -518412385;

        public FileTypeVideoNote() {
        }

        @Override
        public int getConstructor() {
            return -518412385;
        }
    }

    public static class FileTypeVideo extends FileType {
        public static final int CONSTRUCTOR = 1430816539;

        public FileTypeVideo() {
        }

        @Override
        public int getConstructor() {
            return 1430816539;
        }
    }

    public static class FileTypeUnknown extends FileType {
        public static final int CONSTRUCTOR = -2011566768;

        public FileTypeUnknown() {
        }

        @Override
        public int getConstructor() {
            return -2011566768;
        }
    }

    public static class FileTypeThumbnail extends FileType {
        public static final int CONSTRUCTOR = -12443298;

        public FileTypeThumbnail() {
        }

        @Override
        public int getConstructor() {
            return -12443298;
        }
    }

    public static class FileTypeSticker extends FileType {
        public static final int CONSTRUCTOR = 475233385;

        public FileTypeSticker() {
        }

        @Override
        public int getConstructor() {
            return 475233385;
        }
    }

    public static class FileTypeSecure extends FileType {
        public static final int CONSTRUCTOR = -1419133146;

        public FileTypeSecure() {
        }

        @Override
        public int getConstructor() {
            return -1419133146;
        }
    }

    public static class FileTypeSecretThumbnail extends FileType {
        public static final int CONSTRUCTOR = -1401326026;

        public FileTypeSecretThumbnail() {
        }

        @Override
        public int getConstructor() {
            return -1401326026;
        }
    }

    public static class FileTypeSecret extends FileType {
        public static final int CONSTRUCTOR = -1871899401;

        public FileTypeSecret() {
        }

        @Override
        public int getConstructor() {
            return -1871899401;
        }
    }

    public static class FileTypeProfilePhoto extends FileType {
        public static final int CONSTRUCTOR = 1795089315;

        public FileTypeProfilePhoto() {
        }

        @Override
        public int getConstructor() {
            return 1795089315;
        }
    }

    public static class FileTypePhoto extends FileType {
        public static final int CONSTRUCTOR = -1718914651;

        public FileTypePhoto() {
        }

        @Override
        public int getConstructor() {
            return -1718914651;
        }
    }

    public static class FileTypeDocument extends FileType {
        public static final int CONSTRUCTOR = -564722929;

        public FileTypeDocument() {
        }

        @Override
        public int getConstructor() {
            return -564722929;
        }
    }

    public static class FileTypeAudio extends FileType {
        public static final int CONSTRUCTOR = -709112160;

        public FileTypeAudio() {
        }

        @Override
        public int getConstructor() {
            return -709112160;
        }
    }

    public static class FileTypeAnimation extends FileType {
        public static final int CONSTRUCTOR = -290816582;

        public FileTypeAnimation() {
        }

        @Override
        public int getConstructor() {
            return -290816582;
        }
    }

    public static class FileTypeNone extends FileType {
        public static final int CONSTRUCTOR = 2003009189;

        public FileTypeNone() {
        }

        @Override
        public int getConstructor() {
            return 2003009189;
        }
    }

    public abstract static class FileType extends Object {
        public FileType() {
        }
    }

    public static class FilePart extends Object {
        public byte[] data;
        public static final int CONSTRUCTOR = 911821878;

        public FilePart() {
        }

        public FilePart(byte[] var1) {
            this.data = var1;
        }

        @Override
        public int getConstructor() {
            return 911821878;
        }
    }

    public static class File extends Object {
        public int id;
        public int size;
        public int expectedSize;
        public LocalFile local;
        public RemoteFile remote;
        public static final int CONSTRUCTOR = 766337656;

        public File() {
        }

        public File(int var1, int var2, int var3, LocalFile var4, RemoteFile var5) {
            this.id = var1;
            this.size = var2;
            this.expectedSize = var3;
            this.local = var4;
            this.remote = var5;
        }

        @Override
        public int getConstructor() {
            return 766337656;
        }
    }

    public static class Error extends Object {
        public int code;
        public String message;
        public static final int CONSTRUCTOR = -1679978726;

        public Error() {
        }

        public Error(int var1, String var2) {
            this.code = var1;
            this.message = var2;
        }

        @Override
        public int getConstructor() {
            return -1679978726;
        }
    }

    public static class EncryptedPassportElement extends Object {
        public PassportElementType type;
        public byte[] data;
        public DatedFile frontSide;
        public DatedFile reverseSide;
        public DatedFile selfie;
        public DatedFile[] translation;
        public DatedFile[] files;
        public String value;
        public String hash;
        public static final int CONSTRUCTOR = 2002386193;

        public EncryptedPassportElement() {
        }

        public EncryptedPassportElement(PassportElementType var1, byte[] var2, DatedFile var3, DatedFile var4, DatedFile var5, DatedFile[] var6, DatedFile[] var7, String var8, String var9) {
            this.type = var1;
            this.data = var2;
            this.frontSide = var3;
            this.reverseSide = var4;
            this.selfie = var5;
            this.translation = var6;
            this.files = var7;
            this.value = var8;
            this.hash = var9;
        }

        @Override
        public int getConstructor() {
            return 2002386193;
        }
    }

    public static class EncryptedCredentials extends Object {
        public byte[] data;
        public byte[] hash;
        public byte[] secret;
        public static final int CONSTRUCTOR = 1331106766;

        public EncryptedCredentials() {
        }

        public EncryptedCredentials(byte[] var1, byte[] var2, byte[] var3) {
            this.data = var1;
            this.hash = var2;
            this.secret = var3;
        }

        @Override
        public int getConstructor() {
            return 1331106766;
        }
    }

    public static class Emojis extends Object {
        public String[] emojis;
        public static final int CONSTRUCTOR = 950339552;

        public Emojis() {
        }

        public Emojis(String[] var1) {
            this.emojis = var1;
        }

        @Override
        public int getConstructor() {
            return 950339552;
        }
    }

    public static class EmailAddressAuthenticationCodeInfo extends Object {
        public String emailAddressPattern;
        public int length;
        public static final int CONSTRUCTOR = 1151066659;

        public EmailAddressAuthenticationCodeInfo() {
        }

        public EmailAddressAuthenticationCodeInfo(String var1, int var2) {
            this.emailAddressPattern = var1;
            this.length = var2;
        }

        @Override
        public int getConstructor() {
            return 1151066659;
        }
    }

    public static class DraftMessage extends Object {
        public long replyToMessageId;
        public int date;
        public InputMessageContent inputMessageText;
        public static final int CONSTRUCTOR = 1373050112;

        public DraftMessage() {
        }

        public DraftMessage(long var1, int var3, InputMessageContent var4) {
            this.replyToMessageId = var1;
            this.date = var3;
            this.inputMessageText = var4;
        }

        @Override
        public int getConstructor() {
            return 1373050112;
        }
    }

    public static class Document extends Object {
        public String fileName;
        public String mimeType;
        public Minithumbnail minithumbnail;
        public Thumbnail thumbnail;
        public File document;
        public static final int CONSTRUCTOR = -1357271080;

        public Document() {
        }

        public Document(String var1, String var2, Minithumbnail var3, Thumbnail var4, File var5) {
            this.fileName = var1;
            this.mimeType = var2;
            this.minithumbnail = var3;
            this.thumbnail = var4;
            this.document = var5;
        }

        @Override
        public int getConstructor() {
            return -1357271080;
        }
    }

    public static class DiceStickersSlotMachine extends DiceStickers {
        public Sticker background;
        public Sticker lever;
        public Sticker leftReel;
        public Sticker centerReel;
        public Sticker rightReel;
        public static final int CONSTRUCTOR = -375223124;

        public DiceStickersSlotMachine() {
        }

        public DiceStickersSlotMachine(Sticker var1, Sticker var2, Sticker var3, Sticker var4, Sticker var5) {
            this.background = var1;
            this.lever = var2;
            this.leftReel = var3;
            this.centerReel = var4;
            this.rightReel = var5;
        }

        @Override
        public int getConstructor() {
            return -375223124;
        }
    }

    public static class DiceStickersRegular extends DiceStickers {
        public Sticker sticker;
        public static final int CONSTRUCTOR = -740299570;

        public DiceStickersRegular() {
        }

        public DiceStickersRegular(Sticker var1) {
            this.sticker = var1;
        }

        @Override
        public int getConstructor() {
            return -740299570;
        }
    }

    public abstract static class DiceStickers extends Object {
        public DiceStickers() {
        }
    }

    public static class DeviceTokenTizenPush extends DeviceToken {
        public String regId;
        public static final int CONSTRUCTOR = -1359947213;

        public DeviceTokenTizenPush() {
        }

        public DeviceTokenTizenPush(String var1) {
            this.regId = var1;
        }

        @Override
        public int getConstructor() {
            return -1359947213;
        }
    }

    public static class DeviceTokenBlackBerryPush extends DeviceToken {
        public String token;
        public static final int CONSTRUCTOR = 1559167234;

        public DeviceTokenBlackBerryPush() {
        }

        public DeviceTokenBlackBerryPush(String var1) {
            this.token = var1;
        }

        @Override
        public int getConstructor() {
            return 1559167234;
        }
    }

    public static class DeviceTokenUbuntuPush extends DeviceToken {
        public String token;
        public static final int CONSTRUCTOR = 1782320422;

        public DeviceTokenUbuntuPush() {
        }

        public DeviceTokenUbuntuPush(String var1) {
            this.token = var1;
        }

        @Override
        public int getConstructor() {
            return 1782320422;
        }
    }

    public static class DeviceTokenSimplePush extends DeviceToken {
        public String endpoint;
        public static final int CONSTRUCTOR = 49584736;

        public DeviceTokenSimplePush() {
        }

        public DeviceTokenSimplePush(String var1) {
            this.endpoint = var1;
        }

        @Override
        public int getConstructor() {
            return 49584736;
        }
    }

    public static class DeviceTokenWebPush extends DeviceToken {
        public String endpoint;
        public String p256dhBase64url;
        public String authBase64url;
        public static final int CONSTRUCTOR = -1694507273;

        public DeviceTokenWebPush() {
        }

        public DeviceTokenWebPush(String var1, String var2, String var3) {
            this.endpoint = var1;
            this.p256dhBase64url = var2;
            this.authBase64url = var3;
        }

        @Override
        public int getConstructor() {
            return -1694507273;
        }
    }

    public static class DeviceTokenMicrosoftPushVoIP extends DeviceToken {
        public String channelUri;
        public static final int CONSTRUCTOR = -785603759;

        public DeviceTokenMicrosoftPushVoIP() {
        }

        public DeviceTokenMicrosoftPushVoIP(String var1) {
            this.channelUri = var1;
        }

        @Override
        public int getConstructor() {
            return -785603759;
        }
    }

    public static class DeviceTokenMicrosoftPush extends DeviceToken {
        public String channelUri;
        public static final int CONSTRUCTOR = 1224269900;

        public DeviceTokenMicrosoftPush() {
        }

        public DeviceTokenMicrosoftPush(String var1) {
            this.channelUri = var1;
        }

        @Override
        public int getConstructor() {
            return 1224269900;
        }
    }

    public static class DeviceTokenWindowsPush extends DeviceToken {
        public String accessToken;
        public static final int CONSTRUCTOR = -1410514289;

        public DeviceTokenWindowsPush() {
        }

        public DeviceTokenWindowsPush(String var1) {
            this.accessToken = var1;
        }

        @Override
        public int getConstructor() {
            return -1410514289;
        }
    }

    public static class DeviceTokenApplePushVoIP extends DeviceToken {
        public String deviceToken;
        public boolean isAppSandbox;
        public boolean encrypt;
        public static final int CONSTRUCTOR = 804275689;

        public DeviceTokenApplePushVoIP() {
        }

        public DeviceTokenApplePushVoIP(String var1, boolean var2, boolean var3) {
            this.deviceToken = var1;
            this.isAppSandbox = var2;
            this.encrypt = var3;
        }

        @Override
        public int getConstructor() {
            return 804275689;
        }
    }

    public static class DeviceTokenApplePush extends DeviceToken {
        public String deviceToken;
        public boolean isAppSandbox;
        public static final int CONSTRUCTOR = 387541955;

        public DeviceTokenApplePush() {
        }

        public DeviceTokenApplePush(String var1, boolean var2) {
            this.deviceToken = var1;
            this.isAppSandbox = var2;
        }

        @Override
        public int getConstructor() {
            return 387541955;
        }
    }

    public static class DeviceTokenFirebaseCloudMessaging extends DeviceToken {
        public String token;
        public boolean encrypt;
        public static final int CONSTRUCTOR = -797881849;

        public DeviceTokenFirebaseCloudMessaging() {
        }

        public DeviceTokenFirebaseCloudMessaging(String var1, boolean var2) {
            this.token = var1;
            this.encrypt = var2;
        }

        @Override
        public int getConstructor() {
            return -797881849;
        }
    }

    public abstract static class DeviceToken extends Object {
        public DeviceToken() {
        }
    }

    public static class DeepLinkInfo extends Object {
        public FormattedText text;
        public boolean needUpdateApplication;
        public static final int CONSTRUCTOR = 1864081662;

        public DeepLinkInfo() {
        }

        public DeepLinkInfo(FormattedText var1, boolean var2) {
            this.text = var1;
            this.needUpdateApplication = var2;
        }

        @Override
        public int getConstructor() {
            return 1864081662;
        }
    }

    public static class DatedFile extends Object {
        public File file;
        public int date;
        public static final int CONSTRUCTOR = -1840795491;

        public DatedFile() {
        }

        public DatedFile(File var1, int var2) {
            this.file = var1;
            this.date = var2;
        }

        @Override
        public int getConstructor() {
            return -1840795491;
        }
    }

    public static class DateRange extends Object {
        public int startDate;
        public int endDate;
        public static final int CONSTRUCTOR = 1360333926;

        public DateRange() {
        }

        public DateRange(int var1, int var2) {
            this.startDate = var1;
            this.endDate = var2;
        }

        @Override
        public int getConstructor() {
            return 1360333926;
        }
    }

    public static class Date extends Object {
        public int day;
        public int month;
        public int year;
        public static final int CONSTRUCTOR = -277956960;

        public Date() {
        }

        public Date(int var1, int var2, int var3) {
            this.day = var1;
            this.month = var2;
            this.year = var3;
        }

        @Override
        public int getConstructor() {
            return -277956960;
        }
    }

    public static class DatabaseStatistics extends Object {
        public String statistics;
        public static final int CONSTRUCTOR = -1123912880;

        public DatabaseStatistics() {
        }

        public DatabaseStatistics(String var1) {
            this.statistics = var1;
        }

        @Override
        public int getConstructor() {
            return -1123912880;
        }
    }

    public static class CustomRequestResult extends Object {
        public String result;
        public static final int CONSTRUCTOR = -2009960452;

        public CustomRequestResult() {
        }

        public CustomRequestResult(String var1) {
            this.result = var1;
        }

        @Override
        public int getConstructor() {
            return -2009960452;
        }
    }

    public static class CountryInfo extends Object {
        public String countryCode;
        public String name;
        public String englishName;
        public boolean isHidden;
        public String[] callingCodes;
        public static final int CONSTRUCTOR = 1617195722;

        public CountryInfo() {
        }

        public CountryInfo(String var1, String var2, String var3, boolean var4, String[] var5) {
            this.countryCode = var1;
            this.name = var2;
            this.englishName = var3;
            this.isHidden = var4;
            this.callingCodes = var5;
        }

        @Override
        public int getConstructor() {
            return 1617195722;
        }
    }

    public static class Countries extends Object {
        public CountryInfo[] countries;
        public static final int CONSTRUCTOR = 1854211813;

        public Countries() {
        }

        public Countries(CountryInfo[] var1) {
            this.countries = var1;
        }

        @Override
        public int getConstructor() {
            return 1854211813;
        }
    }

    public static class Count extends Object {
        public int count;
        public static final int CONSTRUCTOR = 1295577348;

        public Count() {
        }

        public Count(int var1) {
            this.count = var1;
        }

        @Override
        public int getConstructor() {
            return 1295577348;
        }
    }

    public static class Contact extends Object {
        public String phoneNumber;
        public String firstName;
        public String lastName;
        public String vcard;
        public int userId;
        public static final int CONSTRUCTOR = -1483002540;

        public Contact() {
        }

        public Contact(String var1, String var2, String var3, String var4, int var5) {
            this.phoneNumber = var1;
            this.firstName = var2;
            this.lastName = var3;
            this.vcard = var4;
            this.userId = var5;
        }

        @Override
        public int getConstructor() {
            return -1483002540;
        }
    }

    public static class ConnectionStateReady extends ConnectionState {
        public static final int CONSTRUCTOR = 48608492;

        public ConnectionStateReady() {
        }

        @Override
        public int getConstructor() {
            return 48608492;
        }
    }

    public static class ConnectionStateUpdating extends ConnectionState {
        public static final int CONSTRUCTOR = -188104009;

        public ConnectionStateUpdating() {
        }

        @Override
        public int getConstructor() {
            return -188104009;
        }
    }

    public static class ConnectionStateConnecting extends ConnectionState {
        public static final int CONSTRUCTOR = -1298400670;

        public ConnectionStateConnecting() {
        }

        @Override
        public int getConstructor() {
            return -1298400670;
        }
    }

    public static class ConnectionStateConnectingToProxy extends ConnectionState {
        public static final int CONSTRUCTOR = -93187239;

        public ConnectionStateConnectingToProxy() {
        }

        @Override
        public int getConstructor() {
            return -93187239;
        }
    }

    public static class ConnectionStateWaitingForNetwork extends ConnectionState {
        public static final int CONSTRUCTOR = 1695405912;

        public ConnectionStateWaitingForNetwork() {
        }

        @Override
        public int getConstructor() {
            return 1695405912;
        }
    }

    public abstract static class ConnectionState extends Object {
        public ConnectionState() {
        }
    }

    public static class ConnectedWebsites extends Object {
        public ConnectedWebsite[] websites;
        public static final int CONSTRUCTOR = -1727949694;

        public ConnectedWebsites() {
        }

        public ConnectedWebsites(ConnectedWebsite[] var1) {
            this.websites = var1;
        }

        @Override
        public int getConstructor() {
            return -1727949694;
        }
    }

    public static class ConnectedWebsite extends Object {
        public long id;
        public String domainName;
        public int botUserId;
        public String browser;
        public String platform;
        public int logInDate;
        public int lastActiveDate;
        public String ip;
        public String location;
        public static final int CONSTRUCTOR = -1538986855;

        public ConnectedWebsite() {
        }

        public ConnectedWebsite(long var1, String var3, int var4, String var5, String var6, int var7, int var8, String var9, String var10) {
            this.id = var1;
            this.domainName = var3;
            this.botUserId = var4;
            this.browser = var5;
            this.platform = var6;
            this.logInDate = var7;
            this.lastActiveDate = var8;
            this.ip = var9;
            this.location = var10;
        }

        @Override
        public int getConstructor() {
            return -1538986855;
        }
    }

    public static class ClosedVectorPath extends Object {
        public VectorPathCommand[] commands;
        public static final int CONSTRUCTOR = 589951657;

        public ClosedVectorPath() {
        }

        public ClosedVectorPath(VectorPathCommand[] var1) {
            this.commands = var1;
        }

        @Override
        public int getConstructor() {
            return 589951657;
        }
    }

    public static class CheckStickerSetNameResultNameOccupied extends CheckStickerSetNameResult {
        public static final int CONSTRUCTOR = 1012980872;

        public CheckStickerSetNameResultNameOccupied() {
        }

        @Override
        public int getConstructor() {
            return 1012980872;
        }
    }

    public static class CheckStickerSetNameResultNameInvalid extends CheckStickerSetNameResult {
        public static final int CONSTRUCTOR = 177992244;

        public CheckStickerSetNameResultNameInvalid() {
        }

        @Override
        public int getConstructor() {
            return 177992244;
        }
    }

    public static class CheckStickerSetNameResultOk extends CheckStickerSetNameResult {
        public static final int CONSTRUCTOR = -1404308904;

        public CheckStickerSetNameResultOk() {
        }

        @Override
        public int getConstructor() {
            return -1404308904;
        }
    }

    public abstract static class CheckStickerSetNameResult extends Object {
        public CheckStickerSetNameResult() {
        }
    }

    public static class CheckChatUsernameResultPublicGroupsUnavailable extends CheckChatUsernameResult {
        public static final int CONSTRUCTOR = -51833641;

        public CheckChatUsernameResultPublicGroupsUnavailable() {
        }

        @Override
        public int getConstructor() {
            return -51833641;
        }
    }

    public static class CheckChatUsernameResultPublicChatsTooMuch extends CheckChatUsernameResult {
        public static final int CONSTRUCTOR = 858247741;

        public CheckChatUsernameResultPublicChatsTooMuch() {
        }

        @Override
        public int getConstructor() {
            return 858247741;
        }
    }

    public static class CheckChatUsernameResultUsernameOccupied extends CheckChatUsernameResult {
        public static final int CONSTRUCTOR = 1320892201;

        public CheckChatUsernameResultUsernameOccupied() {
        }

        @Override
        public int getConstructor() {
            return 1320892201;
        }
    }

    public static class CheckChatUsernameResultUsernameInvalid extends CheckChatUsernameResult {
        public static final int CONSTRUCTOR = -636979370;

        public CheckChatUsernameResultUsernameInvalid() {
        }

        @Override
        public int getConstructor() {
            return -636979370;
        }
    }

    public static class CheckChatUsernameResultOk extends CheckChatUsernameResult {
        public static final int CONSTRUCTOR = -1498956964;

        public CheckChatUsernameResultOk() {
        }

        @Override
        public int getConstructor() {
            return -1498956964;
        }
    }

    public abstract static class CheckChatUsernameResult extends Object {
        public CheckChatUsernameResult() {
        }
    }

    public static class ChatsNearby extends Object {
        public ChatNearby[] usersNearby;
        public ChatNearby[] supergroupsNearby;
        public static final int CONSTRUCTOR = 187746081;

        public ChatsNearby() {
        }

        public ChatsNearby(ChatNearby[] var1, ChatNearby[] var2) {
            this.usersNearby = var1;
            this.supergroupsNearby = var2;
        }

        @Override
        public int getConstructor() {
            return 187746081;
        }
    }

    public static class Chats extends Object {
        public int totalCount;
        public long[] chatIds;
        public static final int CONSTRUCTOR = 1809654812;

        public Chats() {
        }

        public Chats(int var1, long[] var2) {
            this.totalCount = var1;
            this.chatIds = var2;
        }

        @Override
        public int getConstructor() {
            return 1809654812;
        }
    }

    public static class ChatTypeSecret extends ChatType {
        public int secretChatId;
        public int userId;
        public static final int CONSTRUCTOR = 136722563;

        public ChatTypeSecret() {
        }

        public ChatTypeSecret(int var1, int var2) {
            this.secretChatId = var1;
            this.userId = var2;
        }

        @Override
        public int getConstructor() {
            return 136722563;
        }
    }

    public static class ChatTypeSupergroup extends ChatType {
        public int supergroupId;
        public boolean isChannel;
        public static final int CONSTRUCTOR = 955152366;

        public ChatTypeSupergroup() {
        }

        public ChatTypeSupergroup(int var1, boolean var2) {
            this.supergroupId = var1;
            this.isChannel = var2;
        }

        @Override
        public int getConstructor() {
            return 955152366;
        }
    }

    public static class ChatTypeBasicGroup extends ChatType {
        public int basicGroupId;
        public static final int CONSTRUCTOR = 21815278;

        public ChatTypeBasicGroup() {
        }

        public ChatTypeBasicGroup(int var1) {
            this.basicGroupId = var1;
        }

        @Override
        public int getConstructor() {
            return 21815278;
        }
    }

    public static class ChatTypePrivate extends ChatType {
        public int userId;
        public static final int CONSTRUCTOR = 1700720838;

        public ChatTypePrivate() {
        }

        public ChatTypePrivate(int var1) {
            this.userId = var1;
        }

        @Override
        public int getConstructor() {
            return 1700720838;
        }
    }

    public abstract static class ChatType extends Object {
        public ChatType() {
        }
    }

    public static class ChatTheme extends Object {
        public String name;
        public ThemeSettings lightSettings;
        public ThemeSettings darkSettings;
        public static final int CONSTRUCTOR = -113218503;

        public ChatTheme() {
        }

        public ChatTheme(String var1, ThemeSettings var2, ThemeSettings var3) {
            this.name = var1;
            this.lightSettings = var2;
            this.darkSettings = var3;
        }

        @Override
        public int getConstructor() {
            return -113218503;
        }
    }

    public static class ChatStatisticsMessageSenderInfo extends Object {
        public int userId;
        public int sentMessageCount;
        public int averageCharacterCount;
        public static final int CONSTRUCTOR = 1716075179;

        public ChatStatisticsMessageSenderInfo() {
        }

        public ChatStatisticsMessageSenderInfo(int var1, int var2, int var3) {
            this.userId = var1;
            this.sentMessageCount = var2;
            this.averageCharacterCount = var3;
        }

        @Override
        public int getConstructor() {
            return 1716075179;
        }
    }

    public static class ChatStatisticsMessageInteractionInfo extends Object {
        public long messageId;
        public int viewCount;
        public int forwardCount;
        public static final int CONSTRUCTOR = -765580756;

        public ChatStatisticsMessageInteractionInfo() {
        }

        public ChatStatisticsMessageInteractionInfo(long var1, int var3, int var4) {
            this.messageId = var1;
            this.viewCount = var3;
            this.forwardCount = var4;
        }

        @Override
        public int getConstructor() {
            return -765580756;
        }
    }

    public static class ChatStatisticsInviterInfo extends Object {
        public int userId;
        public int addedMemberCount;
        public static final int CONSTRUCTOR = -399517859;

        public ChatStatisticsInviterInfo() {
        }

        public ChatStatisticsInviterInfo(int var1, int var2) {
            this.userId = var1;
            this.addedMemberCount = var2;
        }

        @Override
        public int getConstructor() {
            return -399517859;
        }
    }

    public static class ChatStatisticsAdministratorActionsInfo extends Object {
        public int userId;
        public int deletedMessageCount;
        public int bannedUserCount;
        public int restrictedUserCount;
        public static final int CONSTRUCTOR = 1988384904;

        public ChatStatisticsAdministratorActionsInfo() {
        }

        public ChatStatisticsAdministratorActionsInfo(int var1, int var2, int var3, int var4) {
            this.userId = var1;
            this.deletedMessageCount = var2;
            this.bannedUserCount = var3;
            this.restrictedUserCount = var4;
        }

        @Override
        public int getConstructor() {
            return 1988384904;
        }
    }

    public static class ChatStatisticsChannel extends ChatStatistics {
        public DateRange period;
        public StatisticalValue memberCount;
        public StatisticalValue meanViewCount;
        public StatisticalValue meanShareCount;
        public double enabledNotificationsPercentage;
        public StatisticalGraph memberCountGraph;
        public StatisticalGraph joinGraph;
        public StatisticalGraph muteGraph;
        public StatisticalGraph viewCountByHourGraph;
        public StatisticalGraph viewCountBySourceGraph;
        public StatisticalGraph joinBySourceGraph;
        public StatisticalGraph languageGraph;
        public StatisticalGraph messageInteractionGraph;
        public StatisticalGraph instantViewInteractionGraph;
        public ChatStatisticsMessageInteractionInfo[] recentMessageInteractions;
        public static final int CONSTRUCTOR = -825434183;

        public ChatStatisticsChannel() {
        }

        public ChatStatisticsChannel(DateRange var1, StatisticalValue var2, StatisticalValue var3, StatisticalValue var4, double var5, StatisticalGraph var7, StatisticalGraph var8, StatisticalGraph var9, StatisticalGraph var10, StatisticalGraph var11, StatisticalGraph var12, StatisticalGraph var13, StatisticalGraph var14, StatisticalGraph var15, ChatStatisticsMessageInteractionInfo[] var16) {
            this.period = var1;
            this.memberCount = var2;
            this.meanViewCount = var3;
            this.meanShareCount = var4;
            this.enabledNotificationsPercentage = var5;
            this.memberCountGraph = var7;
            this.joinGraph = var8;
            this.muteGraph = var9;
            this.viewCountByHourGraph = var10;
            this.viewCountBySourceGraph = var11;
            this.joinBySourceGraph = var12;
            this.languageGraph = var13;
            this.messageInteractionGraph = var14;
            this.instantViewInteractionGraph = var15;
            this.recentMessageInteractions = var16;
        }

        @Override
        public int getConstructor() {
            return -825434183;
        }
    }

    public static class ChatStatisticsSupergroup extends ChatStatistics {
        public DateRange period;
        public StatisticalValue memberCount;
        public StatisticalValue messageCount;
        public StatisticalValue viewerCount;
        public StatisticalValue senderCount;
        public StatisticalGraph memberCountGraph;
        public StatisticalGraph joinGraph;
        public StatisticalGraph joinBySourceGraph;
        public StatisticalGraph languageGraph;
        public StatisticalGraph messageContentGraph;
        public StatisticalGraph actionGraph;
        public StatisticalGraph dayGraph;
        public StatisticalGraph weekGraph;
        public ChatStatisticsMessageSenderInfo[] topSenders;
        public ChatStatisticsAdministratorActionsInfo[] topAdministrators;
        public ChatStatisticsInviterInfo[] topInviters;
        public static final int CONSTRUCTOR = -17244633;

        public ChatStatisticsSupergroup() {
        }

        public ChatStatisticsSupergroup(DateRange var1, StatisticalValue var2, StatisticalValue var3, StatisticalValue var4, StatisticalValue var5, StatisticalGraph var6, StatisticalGraph var7, StatisticalGraph var8, StatisticalGraph var9, StatisticalGraph var10, StatisticalGraph var11, StatisticalGraph var12, StatisticalGraph var13, ChatStatisticsMessageSenderInfo[] var14, ChatStatisticsAdministratorActionsInfo[] var15, ChatStatisticsInviterInfo[] var16) {
            this.period = var1;
            this.memberCount = var2;
            this.messageCount = var3;
            this.viewerCount = var4;
            this.senderCount = var5;
            this.memberCountGraph = var6;
            this.joinGraph = var7;
            this.joinBySourceGraph = var8;
            this.languageGraph = var9;
            this.messageContentGraph = var10;
            this.actionGraph = var11;
            this.dayGraph = var12;
            this.weekGraph = var13;
            this.topSenders = var14;
            this.topAdministrators = var15;
            this.topInviters = var16;
        }

        @Override
        public int getConstructor() {
            return -17244633;
        }
    }

    public abstract static class ChatStatistics extends Object {
        public ChatStatistics() {
        }
    }

    public static class ChatSourcePublicServiceAnnouncement extends ChatSource {
        public String type;
        public String text;
        public static final int CONSTRUCTOR = -328571244;

        public ChatSourcePublicServiceAnnouncement() {
        }

        public ChatSourcePublicServiceAnnouncement(String var1, String var2) {
            this.type = var1;
            this.text = var2;
        }

        @Override
        public int getConstructor() {
            return -328571244;
        }
    }

    public static class ChatSourceMtprotoProxy extends ChatSource {
        public static final int CONSTRUCTOR = 394074115;

        public ChatSourceMtprotoProxy() {
        }

        @Override
        public int getConstructor() {
            return 394074115;
        }
    }

    public abstract static class ChatSource extends Object {
        public ChatSource() {
        }
    }

    public static class ChatReportReasonCustom extends ChatReportReason {
        public static final int CONSTRUCTOR = 1288925974;

        public ChatReportReasonCustom() {
        }

        @Override
        public int getConstructor() {
            return 1288925974;
        }
    }

    public static class ChatReportReasonFake extends ChatReportReason {
        public static final int CONSTRUCTOR = -1713230446;

        public ChatReportReasonFake() {
        }

        @Override
        public int getConstructor() {
            return -1713230446;
        }
    }

    public static class ChatReportReasonUnrelatedLocation extends ChatReportReason {
        public static final int CONSTRUCTOR = 2632403;

        public ChatReportReasonUnrelatedLocation() {
        }

        @Override
        public int getConstructor() {
            return 2632403;
        }
    }

    public static class ChatReportReasonCopyright extends ChatReportReason {
        public static final int CONSTRUCTOR = 986898080;

        public ChatReportReasonCopyright() {
        }

        @Override
        public int getConstructor() {
            return 986898080;
        }
    }

    public static class ChatReportReasonChildAbuse extends ChatReportReason {
        public static final int CONSTRUCTOR = -1070686531;

        public ChatReportReasonChildAbuse() {
        }

        @Override
        public int getConstructor() {
            return -1070686531;
        }
    }

    public static class ChatReportReasonPornography extends ChatReportReason {
        public static final int CONSTRUCTOR = 722614385;

        public ChatReportReasonPornography() {
        }

        @Override
        public int getConstructor() {
            return 722614385;
        }
    }

    public static class ChatReportReasonViolence extends ChatReportReason {
        public static final int CONSTRUCTOR = -1330235395;

        public ChatReportReasonViolence() {
        }

        @Override
        public int getConstructor() {
            return -1330235395;
        }
    }

    public static class ChatReportReasonSpam extends ChatReportReason {
        public static final int CONSTRUCTOR = -510848863;

        public ChatReportReasonSpam() {
        }

        @Override
        public int getConstructor() {
            return -510848863;
        }
    }

    public abstract static class ChatReportReason extends Object {
        public ChatReportReason() {
        }
    }

    public static class ChatPosition extends Object {
        public ChatList list;
        public long order;
        public boolean isPinned;
        public ChatSource source;
        public static final int CONSTRUCTOR = -622557355;

        public ChatPosition() {
        }

        public ChatPosition(ChatList var1, long var2, boolean var4, ChatSource var5) {
            this.list = var1;
            this.order = var2;
            this.isPinned = var4;
            this.source = var5;
        }

        @Override
        public int getConstructor() {
            return -622557355;
        }
    }

    public static class ChatPhotos extends Object {
        public int totalCount;
        public ChatPhoto[] photos;
        public static final int CONSTRUCTOR = -1510699180;

        public ChatPhotos() {
        }

        public ChatPhotos(int var1, ChatPhoto[] var2) {
            this.totalCount = var1;
            this.photos = var2;
        }

        @Override
        public int getConstructor() {
            return -1510699180;
        }
    }

    public static class ChatPhotoInfo extends Object {
        public File small;
        public File big;
        public Minithumbnail minithumbnail;
        public boolean hasAnimation;
        public static final int CONSTRUCTOR = 167058358;

        public ChatPhotoInfo() {
        }

        public ChatPhotoInfo(File var1, File var2, Minithumbnail var3, boolean var4) {
            this.small = var1;
            this.big = var2;
            this.minithumbnail = var3;
            this.hasAnimation = var4;
        }

        @Override
        public int getConstructor() {
            return 167058358;
        }
    }

    public static class ChatPhoto extends Object {
        public long id;
        public int addedDate;
        public Minithumbnail minithumbnail;
        public PhotoSize[] sizes;
        public AnimatedChatPhoto animation;
        public static final int CONSTRUCTOR = -113003577;

        public ChatPhoto() {
        }

        public ChatPhoto(long var1, int var3, Minithumbnail var4, PhotoSize[] var5, AnimatedChatPhoto var6) {
            this.id = var1;
            this.addedDate = var3;
            this.minithumbnail = var4;
            this.sizes = var5;
            this.animation = var6;
        }

        @Override
        public int getConstructor() {
            return -113003577;
        }
    }

    public static class ChatPermissions extends Object {
        public boolean canSendMessages;
        public boolean canSendMediaMessages;
        public boolean canSendPolls;
        public boolean canSendOtherMessages;
        public boolean canAddWebPagePreviews;
        public boolean canChangeInfo;
        public boolean canInviteUsers;
        public boolean canPinMessages;
        public static final int CONSTRUCTOR = 1584650463;

        public ChatPermissions() {
        }

        public ChatPermissions(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8) {
            this.canSendMessages = var1;
            this.canSendMediaMessages = var2;
            this.canSendPolls = var3;
            this.canSendOtherMessages = var4;
            this.canAddWebPagePreviews = var5;
            this.canChangeInfo = var6;
            this.canInviteUsers = var7;
            this.canPinMessages = var8;
        }

        @Override
        public int getConstructor() {
            return 1584650463;
        }
    }

    public static class ChatNotificationSettings extends Object {
        public boolean useDefaultMuteFor;
        public int muteFor;
        public boolean useDefaultSound;
        public String sound;
        public boolean useDefaultShowPreview;
        public boolean showPreview;
        public boolean useDefaultDisablePinnedMessageNotifications;
        public boolean disablePinnedMessageNotifications;
        public boolean useDefaultDisableMentionNotifications;
        public boolean disableMentionNotifications;
        public static final int CONSTRUCTOR = 1503183218;

        public ChatNotificationSettings() {
        }

        public ChatNotificationSettings(boolean var1, int var2, boolean var3, String var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10) {
            this.useDefaultMuteFor = var1;
            this.muteFor = var2;
            this.useDefaultSound = var3;
            this.sound = var4;
            this.useDefaultShowPreview = var5;
            this.showPreview = var6;
            this.useDefaultDisablePinnedMessageNotifications = var7;
            this.disablePinnedMessageNotifications = var8;
            this.useDefaultDisableMentionNotifications = var9;
            this.disableMentionNotifications = var10;
        }

        @Override
        public int getConstructor() {
            return 1503183218;
        }
    }

    public static class ChatNearby extends Object {
        public long chatId;
        public int distance;
        public static final int CONSTRUCTOR = 48120405;

        public ChatNearby() {
        }

        public ChatNearby(long var1, int var3) {
            this.chatId = var1;
            this.distance = var3;
        }

        @Override
        public int getConstructor() {
            return 48120405;
        }
    }

    public static class ChatMembersFilterBots extends ChatMembersFilter {
        public static final int CONSTRUCTOR = -1422567288;

        public ChatMembersFilterBots() {
        }

        @Override
        public int getConstructor() {
            return -1422567288;
        }
    }

    public static class ChatMembersFilterBanned extends ChatMembersFilter {
        public static final int CONSTRUCTOR = -1863102648;

        public ChatMembersFilterBanned() {
        }

        @Override
        public int getConstructor() {
            return -1863102648;
        }
    }

    public static class ChatMembersFilterRestricted extends ChatMembersFilter {
        public static final int CONSTRUCTOR = 1256282813;

        public ChatMembersFilterRestricted() {
        }

        @Override
        public int getConstructor() {
            return 1256282813;
        }
    }

    public static class ChatMembersFilterMention extends ChatMembersFilter {
        public long messageThreadId;
        public static final int CONSTRUCTOR = 856419831;

        public ChatMembersFilterMention() {
        }

        public ChatMembersFilterMention(long var1) {
            this.messageThreadId = var1;
        }

        @Override
        public int getConstructor() {
            return 856419831;
        }
    }

    public static class ChatMembersFilterMembers extends ChatMembersFilter {
        public static final int CONSTRUCTOR = 670504342;

        public ChatMembersFilterMembers() {
        }

        @Override
        public int getConstructor() {
            return 670504342;
        }
    }

    public static class ChatMembersFilterAdministrators extends ChatMembersFilter {
        public static final int CONSTRUCTOR = -1266893796;

        public ChatMembersFilterAdministrators() {
        }

        @Override
        public int getConstructor() {
            return -1266893796;
        }
    }

    public static class ChatMembersFilterContacts extends ChatMembersFilter {
        public static final int CONSTRUCTOR = 1774485671;

        public ChatMembersFilterContacts() {
        }

        @Override
        public int getConstructor() {
            return 1774485671;
        }
    }

    public abstract static class ChatMembersFilter extends Object {
        public ChatMembersFilter() {
        }
    }

    public static class ChatMembers extends Object {
        public int totalCount;
        public ChatMember[] members;
        public static final int CONSTRUCTOR = -497558622;

        public ChatMembers() {
        }

        public ChatMembers(int var1, ChatMember[] var2) {
            this.totalCount = var1;
            this.members = var2;
        }

        @Override
        public int getConstructor() {
            return -497558622;
        }
    }

    public static class ChatMemberStatusBanned extends ChatMemberStatus {
        public int bannedUntilDate;
        public static final int CONSTRUCTOR = -1653518666;

        public ChatMemberStatusBanned() {
        }

        public ChatMemberStatusBanned(int var1) {
            this.bannedUntilDate = var1;
        }

        @Override
        public int getConstructor() {
            return -1653518666;
        }
    }

    public static class ChatMemberStatusLeft extends ChatMemberStatus {
        public static final int CONSTRUCTOR = -5815259;

        public ChatMemberStatusLeft() {
        }

        @Override
        public int getConstructor() {
            return -5815259;
        }
    }

    public static class ChatMemberStatusRestricted extends ChatMemberStatus {
        public boolean isMember;
        public int restrictedUntilDate;
        public ChatPermissions permissions;
        public static final int CONSTRUCTOR = 1661432998;

        public ChatMemberStatusRestricted() {
        }

        public ChatMemberStatusRestricted(boolean var1, int var2, ChatPermissions var3) {
            this.isMember = var1;
            this.restrictedUntilDate = var2;
            this.permissions = var3;
        }

        @Override
        public int getConstructor() {
            return 1661432998;
        }
    }

    public static class ChatMemberStatusMember extends ChatMemberStatus {
        public static final int CONSTRUCTOR = 844723285;

        public ChatMemberStatusMember() {
        }

        @Override
        public int getConstructor() {
            return 844723285;
        }
    }

    public static class ChatMemberStatusAdministrator extends ChatMemberStatus {
        public String customTitle;
        public boolean canBeEdited;
        public boolean canManageChat;
        public boolean canChangeInfo;
        public boolean canPostMessages;
        public boolean canEditMessages;
        public boolean canDeleteMessages;
        public boolean canInviteUsers;
        public boolean canRestrictMembers;
        public boolean canPinMessages;
        public boolean canPromoteMembers;
        public boolean canManageVoiceChats;
        public boolean isAnonymous;
        public static final int CONSTRUCTOR = -767934760;

        public ChatMemberStatusAdministrator() {
        }

        public ChatMemberStatusAdministrator(String var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12, boolean var13) {
            this.customTitle = var1;
            this.canBeEdited = var2;
            this.canManageChat = var3;
            this.canChangeInfo = var4;
            this.canPostMessages = var5;
            this.canEditMessages = var6;
            this.canDeleteMessages = var7;
            this.canInviteUsers = var8;
            this.canRestrictMembers = var9;
            this.canPinMessages = var10;
            this.canPromoteMembers = var11;
            this.canManageVoiceChats = var12;
            this.isAnonymous = var13;
        }

        @Override
        public int getConstructor() {
            return -767934760;
        }
    }

    public static class ChatMemberStatusCreator extends ChatMemberStatus {
        public String customTitle;
        public boolean isAnonymous;
        public boolean isMember;
        public static final int CONSTRUCTOR = -160019714;

        public ChatMemberStatusCreator() {
        }

        public ChatMemberStatusCreator(String var1, boolean var2, boolean var3) {
            this.customTitle = var1;
            this.isAnonymous = var2;
            this.isMember = var3;
        }

        @Override
        public int getConstructor() {
            return -160019714;
        }
    }

    public abstract static class ChatMemberStatus extends Object {
        public ChatMemberStatus() {
        }
    }

    public static class ChatMember extends Object {
        public MessageSender memberId;
        public int inviterUserId;
        public int joinedChatDate;
        public ChatMemberStatus status;
        public static final int CONSTRUCTOR = 308666856;

        public ChatMember() {
        }

        public ChatMember(MessageSender var1, int var2, int var3, ChatMemberStatus var4) {
            this.memberId = var1;
            this.inviterUserId = var2;
            this.joinedChatDate = var3;
            this.status = var4;
        }

        @Override
        public int getConstructor() {
            return 308666856;
        }
    }

    public static class ChatLocation extends Object {
        public Location location;
        public String address;
        public static final int CONSTRUCTOR = -1566863583;

        public ChatLocation() {
        }

        public ChatLocation(Location var1, String var2) {
            this.location = var1;
            this.address = var2;
        }

        @Override
        public int getConstructor() {
            return -1566863583;
        }
    }

    public static class ChatLists extends Object {
        public ChatList[] chatLists;
        public static final int CONSTRUCTOR = -258292771;

        public ChatLists() {
        }

        public ChatLists(ChatList[] var1) {
            this.chatLists = var1;
        }

        @Override
        public int getConstructor() {
            return -258292771;
        }
    }

    public static class ChatListFilter extends ChatList {
        public int chatFilterId;
        public static final int CONSTRUCTOR = -2022707655;

        public ChatListFilter() {
        }

        public ChatListFilter(int var1) {
            this.chatFilterId = var1;
        }

        @Override
        public int getConstructor() {
            return -2022707655;
        }
    }

    public static class ChatListArchive extends ChatList {
        public static final int CONSTRUCTOR = 362770115;

        public ChatListArchive() {
        }

        @Override
        public int getConstructor() {
            return 362770115;
        }
    }

    public static class ChatListMain extends ChatList {
        public static final int CONSTRUCTOR = -400991316;

        public ChatListMain() {
        }

        @Override
        public int getConstructor() {
            return -400991316;
        }
    }

    public abstract static class ChatList extends Object {
        public ChatList() {
        }
    }

    public static class ChatInviteLinks extends Object {
        public int totalCount;
        public ChatInviteLink[] inviteLinks;
        public static final int CONSTRUCTOR = 112891427;

        public ChatInviteLinks() {
        }

        public ChatInviteLinks(int var1, ChatInviteLink[] var2) {
            this.totalCount = var1;
            this.inviteLinks = var2;
        }

        @Override
        public int getConstructor() {
            return 112891427;
        }
    }

    public static class ChatInviteLinkMembers extends Object {
        public int totalCount;
        public ChatInviteLinkMember[] members;
        public static final int CONSTRUCTOR = 315635051;

        public ChatInviteLinkMembers() {
        }

        public ChatInviteLinkMembers(int var1, ChatInviteLinkMember[] var2) {
            this.totalCount = var1;
            this.members = var2;
        }

        @Override
        public int getConstructor() {
            return 315635051;
        }
    }

    public static class ChatInviteLinkMember extends Object {
        public int userId;
        public int joinedChatDate;
        public static final int CONSTRUCTOR = -1094006899;

        public ChatInviteLinkMember() {
        }

        public ChatInviteLinkMember(int var1, int var2) {
            this.userId = var1;
            this.joinedChatDate = var2;
        }

        @Override
        public int getConstructor() {
            return -1094006899;
        }
    }

    public static class ChatInviteLinkInfo extends Object {
        public long chatId;
        public int accessibleFor;
        public ChatType type;
        public String title;
        public ChatPhotoInfo photo;
        public int memberCount;
        public int[] memberUserIds;
        public boolean isPublic;
        public static final int CONSTRUCTOR = 910695551;

        public ChatInviteLinkInfo() {
        }

        public ChatInviteLinkInfo(long var1, int var3, ChatType var4, String var5, ChatPhotoInfo var6, int var7, int[] var8, boolean var9) {
            this.chatId = var1;
            this.accessibleFor = var3;
            this.type = var4;
            this.title = var5;
            this.photo = var6;
            this.memberCount = var7;
            this.memberUserIds = var8;
            this.isPublic = var9;
        }

        @Override
        public int getConstructor() {
            return 910695551;
        }
    }

    public static class ChatInviteLinkCounts extends Object {
        public ChatInviteLinkCount[] inviteLinkCounts;
        public static final int CONSTRUCTOR = 920326637;

        public ChatInviteLinkCounts() {
        }

        public ChatInviteLinkCounts(ChatInviteLinkCount[] var1) {
            this.inviteLinkCounts = var1;
        }

        @Override
        public int getConstructor() {
            return 920326637;
        }
    }

    public static class ChatInviteLinkCount extends Object {
        public int userId;
        public int inviteLinkCount;
        public int revokedInviteLinkCount;
        public static final int CONSTRUCTOR = -1069702983;

        public ChatInviteLinkCount() {
        }

        public ChatInviteLinkCount(int var1, int var2, int var3) {
            this.userId = var1;
            this.inviteLinkCount = var2;
            this.revokedInviteLinkCount = var3;
        }

        @Override
        public int getConstructor() {
            return -1069702983;
        }
    }

    public static class ChatInviteLink extends Object {
        public String inviteLink;
        public int creatorUserId;
        public int date;
        public int editDate;
        public int expireDate;
        public int memberLimit;
        public int memberCount;
        public boolean isPrimary;
        public boolean isRevoked;
        public static final int CONSTRUCTOR = -248348493;

        public ChatInviteLink() {
        }

        public ChatInviteLink(String var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, boolean var9) {
            this.inviteLink = var1;
            this.creatorUserId = var2;
            this.date = var3;
            this.editDate = var4;
            this.expireDate = var5;
            this.memberLimit = var6;
            this.memberCount = var7;
            this.isPrimary = var8;
            this.isRevoked = var9;
        }

        @Override
        public int getConstructor() {
            return -248348493;
        }
    }

    public static class ChatFilterInfo extends Object {
        public int id;
        public String title;
        public String iconName;
        public static final int CONSTRUCTOR = -943721165;

        public ChatFilterInfo() {
        }

        public ChatFilterInfo(int var1, String var2, String var3) {
            this.id = var1;
            this.title = var2;
            this.iconName = var3;
        }

        @Override
        public int getConstructor() {
            return -943721165;
        }
    }

    public static class ChatFilter extends Object {
        public String title;
        public String iconName;
        public long[] pinnedChatIds;
        public long[] includedChatIds;
        public long[] excludedChatIds;
        public boolean excludeMuted;
        public boolean excludeRead;
        public boolean excludeArchived;
        public boolean includeContacts;
        public boolean includeNonContacts;
        public boolean includeBots;
        public boolean includeGroups;
        public boolean includeChannels;
        public static final int CONSTRUCTOR = -664815123;

        public ChatFilter() {
        }

        public ChatFilter(String var1, String var2, long[] var3, long[] var4, long[] var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12, boolean var13) {
            this.title = var1;
            this.iconName = var2;
            this.pinnedChatIds = var3;
            this.includedChatIds = var4;
            this.excludedChatIds = var5;
            this.excludeMuted = var6;
            this.excludeRead = var7;
            this.excludeArchived = var8;
            this.includeContacts = var9;
            this.includeNonContacts = var10;
            this.includeBots = var11;
            this.includeGroups = var12;
            this.includeChannels = var13;
        }

        @Override
        public int getConstructor() {
            return -664815123;
        }
    }

    public static class ChatEvents extends Object {
        public ChatEvent[] events;
        public static final int CONSTRUCTOR = -585329664;

        public ChatEvents() {
        }

        public ChatEvents(ChatEvent[] var1) {
            this.events = var1;
        }

        @Override
        public int getConstructor() {
            return -585329664;
        }
    }

    public static class ChatEventLogFilters extends Object {
        public boolean messageEdits;
        public boolean messageDeletions;
        public boolean messagePins;
        public boolean memberJoins;
        public boolean memberLeaves;
        public boolean memberInvites;
        public boolean memberPromotions;
        public boolean memberRestrictions;
        public boolean infoChanges;
        public boolean settingChanges;
        public boolean inviteLinkChanges;
        public boolean voiceChatChanges;
        public static final int CONSTRUCTOR = 890465179;

        public ChatEventLogFilters() {
        }

        public ChatEventLogFilters(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12) {
            this.messageEdits = var1;
            this.messageDeletions = var2;
            this.messagePins = var3;
            this.memberJoins = var4;
            this.memberLeaves = var5;
            this.memberInvites = var6;
            this.memberPromotions = var7;
            this.memberRestrictions = var8;
            this.infoChanges = var9;
            this.settingChanges = var10;
            this.inviteLinkChanges = var11;
            this.voiceChatChanges = var12;
        }

        @Override
        public int getConstructor() {
            return 890465179;
        }
    }

    public static class ChatEventVoiceChatMuteNewParticipantsToggled extends ChatEventAction {
        public boolean muteNewParticipants;
        public static final int CONSTRUCTOR = 557181074;

        public ChatEventVoiceChatMuteNewParticipantsToggled() {
        }

        public ChatEventVoiceChatMuteNewParticipantsToggled(boolean var1) {
            this.muteNewParticipants = var1;
        }

        @Override
        public int getConstructor() {
            return 557181074;
        }
    }

    public static class ChatEventVoiceChatParticipantVolumeLevelChanged extends ChatEventAction {
        public MessageSender participantId;
        public int volumeLevel;
        public static final int CONSTRUCTOR = -1492802751;

        public ChatEventVoiceChatParticipantVolumeLevelChanged() {
        }

        public ChatEventVoiceChatParticipantVolumeLevelChanged(MessageSender var1, int var2) {
            this.participantId = var1;
            this.volumeLevel = var2;
        }

        @Override
        public int getConstructor() {
            return -1492802751;
        }
    }

    public static class ChatEventVoiceChatParticipantIsMutedToggled extends ChatEventAction {
        public MessageSender participantId;
        public boolean isMuted;
        public static final int CONSTRUCTOR = 1031405083;

        public ChatEventVoiceChatParticipantIsMutedToggled() {
        }

        public ChatEventVoiceChatParticipantIsMutedToggled(MessageSender var1, boolean var2) {
            this.participantId = var1;
            this.isMuted = var2;
        }

        @Override
        public int getConstructor() {
            return 1031405083;
        }
    }

    public static class ChatEventVoiceChatDiscarded extends ChatEventAction {
        public int groupCallId;
        public static final int CONSTRUCTOR = -511896882;

        public ChatEventVoiceChatDiscarded() {
        }

        public ChatEventVoiceChatDiscarded(int var1) {
            this.groupCallId = var1;
        }

        @Override
        public int getConstructor() {
            return -511896882;
        }
    }

    public static class ChatEventVoiceChatCreated extends ChatEventAction {
        public int groupCallId;
        public static final int CONSTRUCTOR = -1532557526;

        public ChatEventVoiceChatCreated() {
        }

        public ChatEventVoiceChatCreated(int var1) {
            this.groupCallId = var1;
        }

        @Override
        public int getConstructor() {
            return -1532557526;
        }
    }

    public static class ChatEventInviteLinkDeleted extends ChatEventAction {
        public ChatInviteLink inviteLink;
        public static final int CONSTRUCTOR = -1394974361;

        public ChatEventInviteLinkDeleted() {
        }

        public ChatEventInviteLinkDeleted(ChatInviteLink var1) {
            this.inviteLink = var1;
        }

        @Override
        public int getConstructor() {
            return -1394974361;
        }
    }

    public static class ChatEventInviteLinkRevoked extends ChatEventAction {
        public ChatInviteLink inviteLink;
        public static final int CONSTRUCTOR = -1579417629;

        public ChatEventInviteLinkRevoked() {
        }

        public ChatEventInviteLinkRevoked(ChatInviteLink var1) {
            this.inviteLink = var1;
        }

        @Override
        public int getConstructor() {
            return -1579417629;
        }
    }

    public static class ChatEventInviteLinkEdited extends ChatEventAction {
        public ChatInviteLink oldInviteLink;
        public ChatInviteLink newInviteLink;
        public static final int CONSTRUCTOR = -460190366;

        public ChatEventInviteLinkEdited() {
        }

        public ChatEventInviteLinkEdited(ChatInviteLink var1, ChatInviteLink var2) {
            this.oldInviteLink = var1;
            this.newInviteLink = var2;
        }

        @Override
        public int getConstructor() {
            return -460190366;
        }
    }

    public static class ChatEventIsAllHistoryAvailableToggled extends ChatEventAction {
        public boolean isAllHistoryAvailable;
        public static final int CONSTRUCTOR = -1599063019;

        public ChatEventIsAllHistoryAvailableToggled() {
        }

        public ChatEventIsAllHistoryAvailableToggled(boolean var1) {
            this.isAllHistoryAvailable = var1;
        }

        @Override
        public int getConstructor() {
            return -1599063019;
        }
    }

    public static class ChatEventLocationChanged extends ChatEventAction {
        public ChatLocation oldLocation;
        public ChatLocation newLocation;
        public static final int CONSTRUCTOR = -405930674;

        public ChatEventLocationChanged() {
        }

        public ChatEventLocationChanged(ChatLocation var1, ChatLocation var2) {
            this.oldLocation = var1;
            this.newLocation = var2;
        }

        @Override
        public int getConstructor() {
            return -405930674;
        }
    }

    public static class ChatEventStickerSetChanged extends ChatEventAction {
        public long oldStickerSetId;
        public long newStickerSetId;
        public static final int CONSTRUCTOR = -1243130481;

        public ChatEventStickerSetChanged() {
        }

        public ChatEventStickerSetChanged(long var1, long var3) {
            this.oldStickerSetId = var1;
            this.newStickerSetId = var3;
        }

        @Override
        public int getConstructor() {
            return -1243130481;
        }
    }

    public static class ChatEventSignMessagesToggled extends ChatEventAction {
        public boolean signMessages;
        public static final int CONSTRUCTOR = -1313265634;

        public ChatEventSignMessagesToggled() {
        }

        public ChatEventSignMessagesToggled(boolean var1) {
            this.signMessages = var1;
        }

        @Override
        public int getConstructor() {
            return -1313265634;
        }
    }

    public static class ChatEventMessageTtlSettingChanged extends ChatEventAction {
        public int oldMessageTtlSetting;
        public int newMessageTtlSetting;
        public static final int CONSTRUCTOR = -1340179286;

        public ChatEventMessageTtlSettingChanged() {
        }

        public ChatEventMessageTtlSettingChanged(int var1, int var2) {
            this.oldMessageTtlSetting = var1;
            this.newMessageTtlSetting = var2;
        }

        @Override
        public int getConstructor() {
            return -1340179286;
        }
    }

    public static class ChatEventSlowModeDelayChanged extends ChatEventAction {
        public int oldSlowModeDelay;
        public int newSlowModeDelay;
        public static final int CONSTRUCTOR = -1653195765;

        public ChatEventSlowModeDelayChanged() {
        }

        public ChatEventSlowModeDelayChanged(int var1, int var2) {
            this.oldSlowModeDelay = var1;
            this.newSlowModeDelay = var2;
        }

        @Override
        public int getConstructor() {
            return -1653195765;
        }
    }

    public static class ChatEventLinkedChatChanged extends ChatEventAction {
        public long oldLinkedChatId;
        public long newLinkedChatId;
        public static final int CONSTRUCTOR = 1797419439;

        public ChatEventLinkedChatChanged() {
        }

        public ChatEventLinkedChatChanged(long var1, long var3) {
            this.oldLinkedChatId = var1;
            this.newLinkedChatId = var3;
        }

        @Override
        public int getConstructor() {
            return 1797419439;
        }
    }

    public static class ChatEventInvitesToggled extends ChatEventAction {
        public boolean canInviteUsers;
        public static final int CONSTRUCTOR = -62548373;

        public ChatEventInvitesToggled() {
        }

        public ChatEventInvitesToggled(boolean var1) {
            this.canInviteUsers = var1;
        }

        @Override
        public int getConstructor() {
            return -62548373;
        }
    }

    public static class ChatEventThemeChanged extends ChatEventAction {
        public String oldThemeName;
        public String newThemeName;
        public static final int CONSTRUCTOR = 703128930;

        public ChatEventThemeChanged() {
        }

        public ChatEventThemeChanged(String var1, String var2) {
            this.oldThemeName = var1;
            this.newThemeName = var2;
        }

        @Override
        public int getConstructor() {
            return 703128930;
        }
    }

    public static class ChatEventPhotoChanged extends ChatEventAction {
        public ChatPhoto oldPhoto;
        public ChatPhoto newPhoto;
        public static final int CONSTRUCTOR = -811572541;

        public ChatEventPhotoChanged() {
        }

        public ChatEventPhotoChanged(ChatPhoto var1, ChatPhoto var2) {
            this.oldPhoto = var1;
            this.newPhoto = var2;
        }

        @Override
        public int getConstructor() {
            return -811572541;
        }
    }

    public static class ChatEventUsernameChanged extends ChatEventAction {
        public String oldUsername;
        public String newUsername;
        public static final int CONSTRUCTOR = 1728558443;

        public ChatEventUsernameChanged() {
        }

        public ChatEventUsernameChanged(String var1, String var2) {
            this.oldUsername = var1;
            this.newUsername = var2;
        }

        @Override
        public int getConstructor() {
            return 1728558443;
        }
    }

    public static class ChatEventDescriptionChanged extends ChatEventAction {
        public String oldDescription;
        public String newDescription;
        public static final int CONSTRUCTOR = 39112478;

        public ChatEventDescriptionChanged() {
        }

        public ChatEventDescriptionChanged(String var1, String var2) {
            this.oldDescription = var1;
            this.newDescription = var2;
        }

        @Override
        public int getConstructor() {
            return 39112478;
        }
    }

    public static class ChatEventPermissionsChanged extends ChatEventAction {
        public ChatPermissions oldPermissions;
        public ChatPermissions newPermissions;
        public static final int CONSTRUCTOR = -1311557720;

        public ChatEventPermissionsChanged() {
        }

        public ChatEventPermissionsChanged(ChatPermissions var1, ChatPermissions var2) {
            this.oldPermissions = var1;
            this.newPermissions = var2;
        }

        @Override
        public int getConstructor() {
            return -1311557720;
        }
    }

    public static class ChatEventTitleChanged extends ChatEventAction {
        public String oldTitle;
        public String newTitle;
        public static final int CONSTRUCTOR = 1134103250;

        public ChatEventTitleChanged() {
        }

        public ChatEventTitleChanged(String var1, String var2) {
            this.oldTitle = var1;
            this.newTitle = var2;
        }

        @Override
        public int getConstructor() {
            return 1134103250;
        }
    }

    public static class ChatEventMemberRestricted extends ChatEventAction {
        public MessageSender memberId;
        public ChatMemberStatus oldStatus;
        public ChatMemberStatus newStatus;
        public static final int CONSTRUCTOR = 1603608069;

        public ChatEventMemberRestricted() {
        }

        public ChatEventMemberRestricted(MessageSender var1, ChatMemberStatus var2, ChatMemberStatus var3) {
            this.memberId = var1;
            this.oldStatus = var2;
            this.newStatus = var3;
        }

        @Override
        public int getConstructor() {
            return 1603608069;
        }
    }

    public static class ChatEventMemberPromoted extends ChatEventAction {
        public int userId;
        public ChatMemberStatus oldStatus;
        public ChatMemberStatus newStatus;
        public static final int CONSTRUCTOR = 1887176186;

        public ChatEventMemberPromoted() {
        }

        public ChatEventMemberPromoted(int var1, ChatMemberStatus var2, ChatMemberStatus var3) {
            this.userId = var1;
            this.oldStatus = var2;
            this.newStatus = var3;
        }

        @Override
        public int getConstructor() {
            return 1887176186;
        }
    }

    public static class ChatEventMemberInvited extends ChatEventAction {
        public int userId;
        public ChatMemberStatus status;
        public static final int CONSTRUCTOR = -2093688706;

        public ChatEventMemberInvited() {
        }

        public ChatEventMemberInvited(int var1, ChatMemberStatus var2) {
            this.userId = var1;
            this.status = var2;
        }

        @Override
        public int getConstructor() {
            return -2093688706;
        }
    }

    public static class ChatEventMemberLeft extends ChatEventAction {
        public static final int CONSTRUCTOR = -948420593;

        public ChatEventMemberLeft() {
        }

        @Override
        public int getConstructor() {
            return -948420593;
        }
    }

    public static class ChatEventMemberJoinedByInviteLink extends ChatEventAction {
        public ChatInviteLink inviteLink;
        public static final int CONSTRUCTOR = -253307459;

        public ChatEventMemberJoinedByInviteLink() {
        }

        public ChatEventMemberJoinedByInviteLink(ChatInviteLink var1) {
            this.inviteLink = var1;
        }

        @Override
        public int getConstructor() {
            return -253307459;
        }
    }

    public static class ChatEventMemberJoined extends ChatEventAction {
        public static final int CONSTRUCTOR = -235468508;

        public ChatEventMemberJoined() {
        }

        @Override
        public int getConstructor() {
            return -235468508;
        }
    }

    public static class ChatEventMessageUnpinned extends ChatEventAction {
        public Message message;
        public static final int CONSTRUCTOR = -376161513;

        public ChatEventMessageUnpinned() {
        }

        public ChatEventMessageUnpinned(Message var1) {
            this.message = var1;
        }

        @Override
        public int getConstructor() {
            return -376161513;
        }
    }

    public static class ChatEventMessagePinned extends ChatEventAction {
        public Message message;
        public static final int CONSTRUCTOR = 438742298;

        public ChatEventMessagePinned() {
        }

        public ChatEventMessagePinned(Message var1) {
            this.message = var1;
        }

        @Override
        public int getConstructor() {
            return 438742298;
        }
    }

    public static class ChatEventPollStopped extends ChatEventAction {
        public Message message;
        public static final int CONSTRUCTOR = 2009893861;

        public ChatEventPollStopped() {
        }

        public ChatEventPollStopped(Message var1) {
            this.message = var1;
        }

        @Override
        public int getConstructor() {
            return 2009893861;
        }
    }

    public static class ChatEventMessageDeleted extends ChatEventAction {
        public Message message;
        public static final int CONSTRUCTOR = -892974601;

        public ChatEventMessageDeleted() {
        }

        public ChatEventMessageDeleted(Message var1) {
            this.message = var1;
        }

        @Override
        public int getConstructor() {
            return -892974601;
        }
    }

    public static class ChatEventMessageEdited extends ChatEventAction {
        public Message oldMessage;
        public Message newMessage;
        public static final int CONSTRUCTOR = -430967304;

        public ChatEventMessageEdited() {
        }

        public ChatEventMessageEdited(Message var1, Message var2) {
            this.oldMessage = var1;
            this.newMessage = var2;
        }

        @Override
        public int getConstructor() {
            return -430967304;
        }
    }

    public abstract static class ChatEventAction extends Object {
        public ChatEventAction() {
        }
    }

    public static class ChatEvent extends Object {
        public long id;
        public int date;
        public int userId;
        public ChatEventAction action;
        public static final int CONSTRUCTOR = -609912404;

        public ChatEvent() {
        }

        public ChatEvent(long var1, int var3, int var4, ChatEventAction var5) {
            this.id = var1;
            this.date = var3;
            this.userId = var4;
            this.action = var5;
        }

        @Override
        public int getConstructor() {
            return -609912404;
        }
    }

    public static class ChatAdministrators extends Object {
        public ChatAdministrator[] administrators;
        public static final int CONSTRUCTOR = -2126186435;

        public ChatAdministrators() {
        }

        public ChatAdministrators(ChatAdministrator[] var1) {
            this.administrators = var1;
        }

        @Override
        public int getConstructor() {
            return -2126186435;
        }
    }

    public static class ChatAdministrator extends Object {
        public int userId;
        public String customTitle;
        public boolean isOwner;
        public static final int CONSTRUCTOR = 487220942;

        public ChatAdministrator() {
        }

        public ChatAdministrator(int var1, String var2, boolean var3) {
            this.userId = var1;
            this.customTitle = var2;
            this.isOwner = var3;
        }

        @Override
        public int getConstructor() {
            return 487220942;
        }
    }

    public static class ChatActionBarSharePhoneNumber extends ChatActionBar {
        public static final int CONSTRUCTOR = 35188697;

        public ChatActionBarSharePhoneNumber() {
        }

        @Override
        public int getConstructor() {
            return 35188697;
        }
    }

    public static class ChatActionBarAddContact extends ChatActionBar {
        public static final int CONSTRUCTOR = -733325295;

        public ChatActionBarAddContact() {
        }

        @Override
        public int getConstructor() {
            return -733325295;
        }
    }

    public static class ChatActionBarReportAddBlock extends ChatActionBar {
        public boolean canUnarchive;
        public int distance;
        public static final int CONSTRUCTOR = -914150419;

        public ChatActionBarReportAddBlock() {
        }

        public ChatActionBarReportAddBlock(boolean var1, int var2) {
            this.canUnarchive = var1;
            this.distance = var2;
        }

        @Override
        public int getConstructor() {
            return -914150419;
        }
    }

    public static class ChatActionBarInviteMembers extends ChatActionBar {
        public static final int CONSTRUCTOR = 1985313904;

        public ChatActionBarInviteMembers() {
        }

        @Override
        public int getConstructor() {
            return 1985313904;
        }
    }

    public static class ChatActionBarReportUnrelatedLocation extends ChatActionBar {
        public static final int CONSTRUCTOR = 758175489;

        public ChatActionBarReportUnrelatedLocation() {
        }

        @Override
        public int getConstructor() {
            return 758175489;
        }
    }

    public static class ChatActionBarReportSpam extends ChatActionBar {
        public boolean canUnarchive;
        public static final int CONSTRUCTOR = -1312758246;

        public ChatActionBarReportSpam() {
        }

        public ChatActionBarReportSpam(boolean var1) {
            this.canUnarchive = var1;
        }

        @Override
        public int getConstructor() {
            return -1312758246;
        }
    }

    public abstract static class ChatActionBar extends Object {
        public ChatActionBar() {
        }
    }

    public static class ChatActionCancel extends ChatAction {
        public static final int CONSTRUCTOR = 1160523958;

        public ChatActionCancel() {
        }

        @Override
        public int getConstructor() {
            return 1160523958;
        }
    }

    public static class ChatActionUploadingVideoNote extends ChatAction {
        public int progress;
        public static final int CONSTRUCTOR = 1172364918;

        public ChatActionUploadingVideoNote() {
        }

        public ChatActionUploadingVideoNote(int var1) {
            this.progress = var1;
        }

        @Override
        public int getConstructor() {
            return 1172364918;
        }
    }

    public static class ChatActionRecordingVideoNote extends ChatAction {
        public static final int CONSTRUCTOR = 16523393;

        public ChatActionRecordingVideoNote() {
        }

        @Override
        public int getConstructor() {
            return 16523393;
        }
    }

    public static class ChatActionStartPlayingGame extends ChatAction {
        public static final int CONSTRUCTOR = -865884164;

        public ChatActionStartPlayingGame() {
        }

        @Override
        public int getConstructor() {
            return -865884164;
        }
    }

    public static class ChatActionChoosingContact extends ChatAction {
        public static final int CONSTRUCTOR = -1222507496;

        public ChatActionChoosingContact() {
        }

        @Override
        public int getConstructor() {
            return -1222507496;
        }
    }

    public static class ChatActionChoosingLocation extends ChatAction {
        public static final int CONSTRUCTOR = -2017893596;

        public ChatActionChoosingLocation() {
        }

        @Override
        public int getConstructor() {
            return -2017893596;
        }
    }

    public static class ChatActionChoosingSticker extends ChatAction {
        public static final int CONSTRUCTOR = 372753697;

        public ChatActionChoosingSticker() {
        }

        @Override
        public int getConstructor() {
            return 372753697;
        }
    }

    public static class ChatActionUploadingDocument extends ChatAction {
        public int progress;
        public static final int CONSTRUCTOR = 167884362;

        public ChatActionUploadingDocument() {
        }

        public ChatActionUploadingDocument(int var1) {
            this.progress = var1;
        }

        @Override
        public int getConstructor() {
            return 167884362;
        }
    }

    public static class ChatActionUploadingPhoto extends ChatAction {
        public int progress;
        public static final int CONSTRUCTOR = 654240583;

        public ChatActionUploadingPhoto() {
        }

        public ChatActionUploadingPhoto(int var1) {
            this.progress = var1;
        }

        @Override
        public int getConstructor() {
            return 654240583;
        }
    }

    public static class ChatActionUploadingVoiceNote extends ChatAction {
        public int progress;
        public static final int CONSTRUCTOR = -613643666;

        public ChatActionUploadingVoiceNote() {
        }

        public ChatActionUploadingVoiceNote(int var1) {
            this.progress = var1;
        }

        @Override
        public int getConstructor() {
            return -613643666;
        }
    }

    public static class ChatActionRecordingVoiceNote extends ChatAction {
        public static final int CONSTRUCTOR = -808850058;

        public ChatActionRecordingVoiceNote() {
        }

        @Override
        public int getConstructor() {
            return -808850058;
        }
    }

    public static class ChatActionUploadingVideo extends ChatAction {
        public int progress;
        public static final int CONSTRUCTOR = 1234185270;

        public ChatActionUploadingVideo() {
        }

        public ChatActionUploadingVideo(int var1) {
            this.progress = var1;
        }

        @Override
        public int getConstructor() {
            return 1234185270;
        }
    }

    public static class ChatActionRecordingVideo extends ChatAction {
        public static final int CONSTRUCTOR = 216553362;

        public ChatActionRecordingVideo() {
        }

        @Override
        public int getConstructor() {
            return 216553362;
        }
    }

    public static class ChatActionTyping extends ChatAction {
        public static final int CONSTRUCTOR = 380122167;

        public ChatActionTyping() {
        }

        @Override
        public int getConstructor() {
            return 380122167;
        }
    }

    public abstract static class ChatAction extends Object {
        public ChatAction() {
        }
    }

    public static class Chat extends Object {
        public long id;
        public ChatType type;
        public String title;
        public ChatPhotoInfo photo;
        public ChatPermissions permissions;
        public Message lastMessage;
        public ChatPosition[] positions;
        public boolean isMarkedAsUnread;
        public boolean isBlocked;
        public boolean hasScheduledMessages;
        public boolean canBeDeletedOnlyForSelf;
        public boolean canBeDeletedForAllUsers;
        public boolean canBeReported;
        public boolean defaultDisableNotification;
        public int unreadCount;
        public long lastReadInboxMessageId;
        public long lastReadOutboxMessageId;
        public int unreadMentionCount;
        public ChatNotificationSettings notificationSettings;
        public int messageTtlSetting;
        public String themeName;
        public ChatActionBar actionBar;
        public VoiceChat voiceChat;
        public long replyMarkupMessageId;
        public DraftMessage draftMessage;
        public String clientData;
        public static final int CONSTRUCTOR = 1672092758;

        public Chat() {
        }

        public Chat(long var1, ChatType var3, String var4, ChatPhotoInfo var5, ChatPermissions var6, Message var7, ChatPosition[] var8, boolean var9, boolean var10, boolean var11, boolean var12, boolean var13, boolean var14, boolean var15, int var16, long var17, long var19, int var21, ChatNotificationSettings var22, int var23, String var24, ChatActionBar var25, VoiceChat var26, long var27, DraftMessage var29, String var30) {
            this.id = var1;
            this.type = var3;
            this.title = var4;
            this.photo = var5;
            this.permissions = var6;
            this.lastMessage = var7;
            this.positions = var8;
            this.isMarkedAsUnread = var9;
            this.isBlocked = var10;
            this.hasScheduledMessages = var11;
            this.canBeDeletedOnlyForSelf = var12;
            this.canBeDeletedForAllUsers = var13;
            this.canBeReported = var14;
            this.defaultDisableNotification = var15;
            this.unreadCount = var16;
            this.lastReadInboxMessageId = var17;
            this.lastReadOutboxMessageId = var19;
            this.unreadMentionCount = var21;
            this.notificationSettings = var22;
            this.messageTtlSetting = var23;
            this.themeName = var24;
            this.actionBar = var25;
            this.voiceChat = var26;
            this.replyMarkupMessageId = var27;
            this.draftMessage = var29;
            this.clientData = var30;
        }

        @Override
        public int getConstructor() {
            return 1672092758;
        }
    }

    public static class CanTransferOwnershipResultSessionTooFresh extends CanTransferOwnershipResult {
        public int retryAfter;
        public static final int CONSTRUCTOR = 984664289;

        public CanTransferOwnershipResultSessionTooFresh() {
        }

        public CanTransferOwnershipResultSessionTooFresh(int var1) {
            this.retryAfter = var1;
        }

        @Override
        public int getConstructor() {
            return 984664289;
        }
    }

    public static class CanTransferOwnershipResultPasswordTooFresh extends CanTransferOwnershipResult {
        public int retryAfter;
        public static final int CONSTRUCTOR = 811440913;

        public CanTransferOwnershipResultPasswordTooFresh() {
        }

        public CanTransferOwnershipResultPasswordTooFresh(int var1) {
            this.retryAfter = var1;
        }

        @Override
        public int getConstructor() {
            return 811440913;
        }
    }

    public static class CanTransferOwnershipResultPasswordNeeded extends CanTransferOwnershipResult {
        public static final int CONSTRUCTOR = 1548372703;

        public CanTransferOwnershipResultPasswordNeeded() {
        }

        @Override
        public int getConstructor() {
            return 1548372703;
        }
    }

    public static class CanTransferOwnershipResultOk extends CanTransferOwnershipResult {
        public static final int CONSTRUCTOR = -89881021;

        public CanTransferOwnershipResultOk() {
        }

        @Override
        public int getConstructor() {
            return -89881021;
        }
    }

    public abstract static class CanTransferOwnershipResult extends Object {
        public CanTransferOwnershipResult() {
        }
    }

    public static class CallbackQueryPayloadGame extends CallbackQueryPayload {
        public String gameShortName;
        public static final int CONSTRUCTOR = 1303571512;

        public CallbackQueryPayloadGame() {
        }

        public CallbackQueryPayloadGame(String var1) {
            this.gameShortName = var1;
        }

        @Override
        public int getConstructor() {
            return 1303571512;
        }
    }

    public static class CallbackQueryPayloadDataWithPassword extends CallbackQueryPayload {
        public String password;
        public byte[] data;
        public static final int CONSTRUCTOR = 1340266738;

        public CallbackQueryPayloadDataWithPassword() {
        }

        public CallbackQueryPayloadDataWithPassword(String var1, byte[] var2) {
            this.password = var1;
            this.data = var2;
        }

        @Override
        public int getConstructor() {
            return 1340266738;
        }
    }

    public static class CallbackQueryPayloadData extends CallbackQueryPayload {
        public byte[] data;
        public static final int CONSTRUCTOR = -1977729946;

        public CallbackQueryPayloadData() {
        }

        public CallbackQueryPayloadData(byte[] var1) {
            this.data = var1;
        }

        @Override
        public int getConstructor() {
            return -1977729946;
        }
    }

    public abstract static class CallbackQueryPayload extends Object {
        public CallbackQueryPayload() {
        }
    }

    public static class CallbackQueryAnswer extends Object {
        public String text;
        public boolean showAlert;
        public String url;
        public static final int CONSTRUCTOR = 360867933;

        public CallbackQueryAnswer() {
        }

        public CallbackQueryAnswer(String var1, boolean var2, String var3) {
            this.text = var1;
            this.showAlert = var2;
            this.url = var3;
        }

        @Override
        public int getConstructor() {
            return 360867933;
        }
    }

    public static class CallStateError extends CallState {
        public Error error;
        public static final int CONSTRUCTOR = -975215467;

        public CallStateError() {
        }

        public CallStateError(Error var1) {
            this.error = var1;
        }

        @Override
        public int getConstructor() {
            return -975215467;
        }
    }

    public static class CallStateDiscarded extends CallState {
        public CallDiscardReason reason;
        public boolean needRating;
        public boolean needDebugInformation;
        public static final int CONSTRUCTOR = -190853167;

        public CallStateDiscarded() {
        }

        public CallStateDiscarded(CallDiscardReason var1, boolean var2, boolean var3) {
            this.reason = var1;
            this.needRating = var2;
            this.needDebugInformation = var3;
        }

        @Override
        public int getConstructor() {
            return -190853167;
        }
    }

    public static class CallStateHangingUp extends CallState {
        public static final int CONSTRUCTOR = -2133790038;

        public CallStateHangingUp() {
        }

        @Override
        public int getConstructor() {
            return -2133790038;
        }
    }

    public static class CallStateReady extends CallState {
        public CallProtocol protocol;
        public CallServer[] servers;
        public String config;
        public byte[] encryptionKey;
        public String[] emojis;
        public boolean allowP2p;
        public static final int CONSTRUCTOR = -2000107571;

        public CallStateReady() {
        }

        public CallStateReady(CallProtocol var1, CallServer[] var2, String var3, byte[] var4, String[] var5, boolean var6) {
            this.protocol = var1;
            this.servers = var2;
            this.config = var3;
            this.encryptionKey = var4;
            this.emojis = var5;
            this.allowP2p = var6;
        }

        @Override
        public int getConstructor() {
            return -2000107571;
        }
    }

    public static class CallStateExchangingKeys extends CallState {
        public static final int CONSTRUCTOR = -1848149403;

        public CallStateExchangingKeys() {
        }

        @Override
        public int getConstructor() {
            return -1848149403;
        }
    }

    public static class CallStatePending extends CallState {
        public boolean isCreated;
        public boolean isReceived;
        public static final int CONSTRUCTOR = 1073048620;

        public CallStatePending() {
        }

        public CallStatePending(boolean var1, boolean var2) {
            this.isCreated = var1;
            this.isReceived = var2;
        }

        @Override
        public int getConstructor() {
            return 1073048620;
        }
    }

    public abstract static class CallState extends Object {
        public CallState() {
        }
    }

    public static class CallServerTypeWebrtc extends CallServerType {
        public String username;
        public String password;
        public boolean supportsTurn;
        public boolean supportsStun;
        public static final int CONSTRUCTOR = 1250622821;

        public CallServerTypeWebrtc() {
        }

        public CallServerTypeWebrtc(String var1, String var2, boolean var3, boolean var4) {
            this.username = var1;
            this.password = var2;
            this.supportsTurn = var3;
            this.supportsStun = var4;
        }

        @Override
        public int getConstructor() {
            return 1250622821;
        }
    }

    public static class CallServerTypeTelegramReflector extends CallServerType {
        public byte[] peerTag;
        public static final int CONSTRUCTOR = -1507850700;

        public CallServerTypeTelegramReflector() {
        }

        public CallServerTypeTelegramReflector(byte[] var1) {
            this.peerTag = var1;
        }

        @Override
        public int getConstructor() {
            return -1507850700;
        }
    }

    public abstract static class CallServerType extends Object {
        public CallServerType() {
        }
    }

    public static class CallServer extends Object {
        public long id;
        public String ipAddress;
        public String ipv6Address;
        public int port;
        public CallServerType type;
        public static final int CONSTRUCTOR = 1865932695;

        public CallServer() {
        }

        public CallServer(long var1, String var3, String var4, int var5, CallServerType var6) {
            this.id = var1;
            this.ipAddress = var3;
            this.ipv6Address = var4;
            this.port = var5;
            this.type = var6;
        }

        @Override
        public int getConstructor() {
            return 1865932695;
        }
    }

    public static class CallProtocol extends Object {
        public boolean udpP2p;
        public boolean udpReflector;
        public int minLayer;
        public int maxLayer;
        public String[] libraryVersions;
        public static final int CONSTRUCTOR = -1075562897;

        public CallProtocol() {
        }

        public CallProtocol(boolean var1, boolean var2, int var3, int var4, String[] var5) {
            this.udpP2p = var1;
            this.udpReflector = var2;
            this.minLayer = var3;
            this.maxLayer = var4;
            this.libraryVersions = var5;
        }

        @Override
        public int getConstructor() {
            return -1075562897;
        }
    }

    public static class CallProblemPixelatedVideo extends CallProblem {
        public static final int CONSTRUCTOR = 2115315411;

        public CallProblemPixelatedVideo() {
        }

        @Override
        public int getConstructor() {
            return 2115315411;
        }
    }

    public static class CallProblemDistortedVideo extends CallProblem {
        public static final int CONSTRUCTOR = 385245706;

        public CallProblemDistortedVideo() {
        }

        @Override
        public int getConstructor() {
            return 385245706;
        }
    }

    public static class CallProblemDropped extends CallProblem {
        public static final int CONSTRUCTOR = -1207311487;

        public CallProblemDropped() {
        }

        @Override
        public int getConstructor() {
            return -1207311487;
        }
    }

    public static class CallProblemSilentRemote extends CallProblem {
        public static final int CONSTRUCTOR = 573634714;

        public CallProblemSilentRemote() {
        }

        @Override
        public int getConstructor() {
            return 573634714;
        }
    }

    public static class CallProblemSilentLocal extends CallProblem {
        public static final int CONSTRUCTOR = 253652790;

        public CallProblemSilentLocal() {
        }

        @Override
        public int getConstructor() {
            return 253652790;
        }
    }

    public static class CallProblemDistortedSpeech extends CallProblem {
        public static final int CONSTRUCTOR = 379960581;

        public CallProblemDistortedSpeech() {
        }

        @Override
        public int getConstructor() {
            return 379960581;
        }
    }

    public static class CallProblemInterruptions extends CallProblem {
        public static final int CONSTRUCTOR = 1119493218;

        public CallProblemInterruptions() {
        }

        @Override
        public int getConstructor() {
            return 1119493218;
        }
    }

    public static class CallProblemNoise extends CallProblem {
        public static final int CONSTRUCTOR = 1053065359;

        public CallProblemNoise() {
        }

        @Override
        public int getConstructor() {
            return 1053065359;
        }
    }

    public static class CallProblemEcho extends CallProblem {
        public static final int CONSTRUCTOR = 801116548;

        public CallProblemEcho() {
        }

        @Override
        public int getConstructor() {
            return 801116548;
        }
    }

    public abstract static class CallProblem extends Object {
        public CallProblem() {
        }
    }

    public static class CallId extends Object {
        public int id;
        public static final int CONSTRUCTOR = 65717769;

        public CallId() {
        }

        public CallId(int var1) {
            this.id = var1;
        }

        @Override
        public int getConstructor() {
            return 65717769;
        }
    }

    public static class CallDiscardReasonHungUp extends CallDiscardReason {
        public static final int CONSTRUCTOR = 438216166;

        public CallDiscardReasonHungUp() {
        }

        @Override
        public int getConstructor() {
            return 438216166;
        }
    }

    public static class CallDiscardReasonDisconnected extends CallDiscardReason {
        public static final int CONSTRUCTOR = -1342872670;

        public CallDiscardReasonDisconnected() {
        }

        @Override
        public int getConstructor() {
            return -1342872670;
        }
    }

    public static class CallDiscardReasonDeclined extends CallDiscardReason {
        public static final int CONSTRUCTOR = -1729926094;

        public CallDiscardReasonDeclined() {
        }

        @Override
        public int getConstructor() {
            return -1729926094;
        }
    }

    public static class CallDiscardReasonMissed extends CallDiscardReason {
        public static final int CONSTRUCTOR = 1680358012;

        public CallDiscardReasonMissed() {
        }

        @Override
        public int getConstructor() {
            return 1680358012;
        }
    }

    public static class CallDiscardReasonEmpty extends CallDiscardReason {
        public static final int CONSTRUCTOR = -1258917949;

        public CallDiscardReasonEmpty() {
        }

        @Override
        public int getConstructor() {
            return -1258917949;
        }
    }

    public abstract static class CallDiscardReason extends Object {
        public CallDiscardReason() {
        }
    }

    public static class Call extends Object {
        public int id;
        public int userId;
        public boolean isOutgoing;
        public boolean isVideo;
        public CallState state;
        public static final int CONSTRUCTOR = 1504070790;

        public Call() {
        }

        public Call(int var1, int var2, boolean var3, boolean var4, CallState var5) {
            this.id = var1;
            this.userId = var2;
            this.isOutgoing = var3;
            this.isVideo = var4;
            this.state = var5;
        }

        @Override
        public int getConstructor() {
            return 1504070790;
        }
    }

    public static class BotCommands extends Object {
        public int botUserId;
        public BotCommand[] commands;
        public static final int CONSTRUCTOR = -1880381375;

        public BotCommands() {
        }

        public BotCommands(int var1, BotCommand[] var2) {
            this.botUserId = var1;
            this.commands = var2;
        }

        @Override
        public int getConstructor() {
            return -1880381375;
        }
    }

    public static class BotCommandScopeChatMember extends BotCommandScope {
        public long chatId;
        public int userId;
        public static final int CONSTRUCTOR = -1599632513;

        public BotCommandScopeChatMember() {
        }

        public BotCommandScopeChatMember(long var1, int var3) {
            this.chatId = var1;
            this.userId = var3;
        }

        @Override
        public int getConstructor() {
            return -1599632513;
        }
    }

    public static class BotCommandScopeChatAdministrators extends BotCommandScope {
        public long chatId;
        public static final int CONSTRUCTOR = 1119682126;

        public BotCommandScopeChatAdministrators() {
        }

        public BotCommandScopeChatAdministrators(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return 1119682126;
        }
    }

    public static class BotCommandScopeChat extends BotCommandScope {
        public long chatId;
        public static final int CONSTRUCTOR = -430234971;

        public BotCommandScopeChat() {
        }

        public BotCommandScopeChat(long var1) {
            this.chatId = var1;
        }

        @Override
        public int getConstructor() {
            return -430234971;
        }
    }

    public static class BotCommandScopeAllChatAdministrators extends BotCommandScope {
        public static final int CONSTRUCTOR = 1998329169;

        public BotCommandScopeAllChatAdministrators() {
        }

        @Override
        public int getConstructor() {
            return 1998329169;
        }
    }

    public static class BotCommandScopeAllGroupChats extends BotCommandScope {
        public static final int CONSTRUCTOR = -981088162;

        public BotCommandScopeAllGroupChats() {
        }

        @Override
        public int getConstructor() {
            return -981088162;
        }
    }

    public static class BotCommandScopeAllPrivateChats extends BotCommandScope {
        public static final int CONSTRUCTOR = -344889543;

        public BotCommandScopeAllPrivateChats() {
        }

        @Override
        public int getConstructor() {
            return -344889543;
        }
    }

    public static class BotCommandScopeDefault extends BotCommandScope {
        public static final int CONSTRUCTOR = 795652779;

        public BotCommandScopeDefault() {
        }

        @Override
        public int getConstructor() {
            return 795652779;
        }
    }

    public abstract static class BotCommandScope extends Object {
        public BotCommandScope() {
        }
    }

    public static class BotCommand extends Object {
        public String command;
        public String description;
        public static final int CONSTRUCTOR = -1032140601;

        public BotCommand() {
        }

        public BotCommand(String var1, String var2) {
            this.command = var1;
            this.description = var2;
        }

        @Override
        public int getConstructor() {
            return -1032140601;
        }
    }

    public static class BasicGroupFullInfo extends Object {
        public ChatPhoto photo;
        public String description;
        public int creatorUserId;
        public ChatMember[] members;
        public ChatInviteLink inviteLink;
        public BotCommands[] botCommands;
        public static final int CONSTRUCTOR = -960735652;

        public BasicGroupFullInfo() {
        }

        public BasicGroupFullInfo(ChatPhoto var1, String var2, int var3, ChatMember[] var4, ChatInviteLink var5, BotCommands[] var6) {
            this.photo = var1;
            this.description = var2;
            this.creatorUserId = var3;
            this.members = var4;
            this.inviteLink = var5;
            this.botCommands = var6;
        }

        @Override
        public int getConstructor() {
            return -960735652;
        }
    }

    public static class BasicGroup extends Object {
        public int id;
        public int memberCount;
        public ChatMemberStatus status;
        public boolean isActive;
        public int upgradedToSupergroupId;
        public static final int CONSTRUCTOR = -317839045;

        public BasicGroup() {
        }

        public BasicGroup(int var1, int var2, ChatMemberStatus var3, boolean var4, int var5) {
            this.id = var1;
            this.memberCount = var2;
            this.status = var3;
            this.isActive = var4;
            this.upgradedToSupergroupId = var5;
        }

        @Override
        public int getConstructor() {
            return -317839045;
        }
    }

    public static class BankCardInfo extends Object {
        public String title;
        public BankCardActionOpenUrl[] actions;
        public static final int CONSTRUCTOR = -2116647730;

        public BankCardInfo() {
        }

        public BankCardInfo(String var1, BankCardActionOpenUrl[] var2) {
            this.title = var1;
            this.actions = var2;
        }

        @Override
        public int getConstructor() {
            return -2116647730;
        }
    }

    public static class BankCardActionOpenUrl extends Object {
        public String text;
        public String url;
        public static final int CONSTRUCTOR = -196454267;

        public BankCardActionOpenUrl() {
        }

        public BankCardActionOpenUrl(String var1, String var2) {
            this.text = var1;
            this.url = var2;
        }

        @Override
        public int getConstructor() {
            return -196454267;
        }
    }

    public static class Backgrounds extends Object {
        public Background[] backgrounds;
        public static final int CONSTRUCTOR = 724728704;

        public Backgrounds() {
        }

        public Backgrounds(Background[] var1) {
            this.backgrounds = var1;
        }

        @Override
        public int getConstructor() {
            return 724728704;
        }
    }

    public static class BackgroundTypeFill extends BackgroundType {
        public BackgroundFill fill;
        public static final int CONSTRUCTOR = 993008684;

        public BackgroundTypeFill() {
        }

        public BackgroundTypeFill(BackgroundFill var1) {
            this.fill = var1;
        }

        @Override
        public int getConstructor() {
            return 993008684;
        }
    }

    public static class BackgroundTypePattern extends BackgroundType {
        public BackgroundFill fill;
        public int intensity;
        public boolean isInverted;
        public boolean isMoving;
        public static final int CONSTRUCTOR = 1290213117;

        public BackgroundTypePattern() {
        }

        public BackgroundTypePattern(BackgroundFill var1, int var2, boolean var3, boolean var4) {
            this.fill = var1;
            this.intensity = var2;
            this.isInverted = var3;
            this.isMoving = var4;
        }

        @Override
        public int getConstructor() {
            return 1290213117;
        }
    }

    public static class BackgroundTypeWallpaper extends BackgroundType {
        public boolean isBlurred;
        public boolean isMoving;
        public static final int CONSTRUCTOR = 1972128891;

        public BackgroundTypeWallpaper() {
        }

        public BackgroundTypeWallpaper(boolean var1, boolean var2) {
            this.isBlurred = var1;
            this.isMoving = var2;
        }

        @Override
        public int getConstructor() {
            return 1972128891;
        }
    }

    public abstract static class BackgroundType extends Object {
        public BackgroundType() {
        }
    }

    public static class BackgroundFillFreeformGradient extends BackgroundFill {
        public int[] colors;
        public static final int CONSTRUCTOR = -1145469255;

        public BackgroundFillFreeformGradient() {
        }

        public BackgroundFillFreeformGradient(int[] var1) {
            this.colors = var1;
        }

        @Override
        public int getConstructor() {
            return -1145469255;
        }
    }

    public static class BackgroundFillGradient extends BackgroundFill {
        public int topColor;
        public int bottomColor;
        public int rotationAngle;
        public static final int CONSTRUCTOR = -1839206017;

        public BackgroundFillGradient() {
        }

        public BackgroundFillGradient(int var1, int var2, int var3) {
            this.topColor = var1;
            this.bottomColor = var2;
            this.rotationAngle = var3;
        }

        @Override
        public int getConstructor() {
            return -1839206017;
        }
    }

    public static class BackgroundFillSolid extends BackgroundFill {
        public int color;
        public static final int CONSTRUCTOR = 1010678813;

        public BackgroundFillSolid() {
        }

        public BackgroundFillSolid(int var1) {
            this.color = var1;
        }

        @Override
        public int getConstructor() {
            return 1010678813;
        }
    }

    public abstract static class BackgroundFill extends Object {
        public BackgroundFill() {
        }
    }

    public static class Background extends Object {
        public long id;
        public boolean isDefault;
        public boolean isDark;
        public String name;
        public Document document;
        public BackgroundType type;
        public static final int CONSTRUCTOR = -429971172;

        public Background() {
        }

        public Background(long var1, boolean var3, boolean var4, String var5, Document var6, BackgroundType var7) {
            this.id = var1;
            this.isDefault = var3;
            this.isDark = var4;
            this.name = var5;
            this.document = var6;
            this.type = var7;
        }

        @Override
        public int getConstructor() {
            return -429971172;
        }
    }

    public static class AutoDownloadSettingsPresets extends Object {
        public AutoDownloadSettings low;
        public AutoDownloadSettings medium;
        public AutoDownloadSettings high;
        public static final int CONSTRUCTOR = -782099166;

        public AutoDownloadSettingsPresets() {
        }

        public AutoDownloadSettingsPresets(AutoDownloadSettings var1, AutoDownloadSettings var2, AutoDownloadSettings var3) {
            this.low = var1;
            this.medium = var2;
            this.high = var3;
        }

        @Override
        public int getConstructor() {
            return -782099166;
        }
    }

    public static class AutoDownloadSettings extends Object {
        public boolean isAutoDownloadEnabled;
        public int maxPhotoFileSize;
        public int maxVideoFileSize;
        public int maxOtherFileSize;
        public int videoUploadBitrate;
        public boolean preloadLargeVideos;
        public boolean preloadNextAudio;
        public boolean useLessDataForCalls;
        public static final int CONSTRUCTOR = -2144418333;

        public AutoDownloadSettings() {
        }

        public AutoDownloadSettings(boolean var1, int var2, int var3, int var4, int var5, boolean var6, boolean var7, boolean var8) {
            this.isAutoDownloadEnabled = var1;
            this.maxPhotoFileSize = var2;
            this.maxVideoFileSize = var3;
            this.maxOtherFileSize = var4;
            this.videoUploadBitrate = var5;
            this.preloadLargeVideos = var6;
            this.preloadNextAudio = var7;
            this.useLessDataForCalls = var8;
        }

        @Override
        public int getConstructor() {
            return -2144418333;
        }
    }

    public static class AuthorizationStateClosed extends AuthorizationState {
        public static final int CONSTRUCTOR = 1526047584;

        public AuthorizationStateClosed() {
        }

        @Override
        public int getConstructor() {
            return 1526047584;
        }
    }

    public static class AuthorizationStateClosing extends AuthorizationState {
        public static final int CONSTRUCTOR = 445855311;

        public AuthorizationStateClosing() {
        }

        @Override
        public int getConstructor() {
            return 445855311;
        }
    }

    public static class AuthorizationStateLoggingOut extends AuthorizationState {
        public static final int CONSTRUCTOR = 154449270;

        public AuthorizationStateLoggingOut() {
        }

        @Override
        public int getConstructor() {
            return 154449270;
        }
    }

    public static class AuthorizationStateReady extends AuthorizationState {
        public static final int CONSTRUCTOR = -1834871737;

        public AuthorizationStateReady() {
        }

        @Override
        public int getConstructor() {
            return -1834871737;
        }
    }

    public static class AuthorizationStateWaitPassword extends AuthorizationState {
        public String passwordHint;
        public boolean hasRecoveryEmailAddress;
        public String recoveryEmailAddressPattern;
        public static final int CONSTRUCTOR = 187548796;

        public AuthorizationStateWaitPassword() {
        }

        public AuthorizationStateWaitPassword(String var1, boolean var2, String var3) {
            this.passwordHint = var1;
            this.hasRecoveryEmailAddress = var2;
            this.recoveryEmailAddressPattern = var3;
        }

        @Override
        public int getConstructor() {
            return 187548796;
        }
    }

    public static class AuthorizationStateWaitRegistration extends AuthorizationState {
        public TermsOfService termsOfService;
        public static final int CONSTRUCTOR = 550350511;

        public AuthorizationStateWaitRegistration() {
        }

        public AuthorizationStateWaitRegistration(TermsOfService var1) {
            this.termsOfService = var1;
        }

        @Override
        public int getConstructor() {
            return 550350511;
        }
    }

    public static class AuthorizationStateWaitOtherDeviceConfirmation extends AuthorizationState {
        public String link;
        public static final int CONSTRUCTOR = 860166378;

        public AuthorizationStateWaitOtherDeviceConfirmation() {
        }

        public AuthorizationStateWaitOtherDeviceConfirmation(String var1) {
            this.link = var1;
        }

        @Override
        public int getConstructor() {
            return 860166378;
        }
    }

    public static class AuthorizationStateWaitCode extends AuthorizationState {
        public AuthenticationCodeInfo codeInfo;
        public static final int CONSTRUCTOR = 52643073;

        public AuthorizationStateWaitCode() {
        }

        public AuthorizationStateWaitCode(AuthenticationCodeInfo var1) {
            this.codeInfo = var1;
        }

        @Override
        public int getConstructor() {
            return 52643073;
        }
    }

    public static class AuthorizationStateWaitPhoneNumber extends AuthorizationState {
        public static final int CONSTRUCTOR = 306402531;

        public AuthorizationStateWaitPhoneNumber() {
        }

        @Override
        public int getConstructor() {
            return 306402531;
        }
    }

    public static class AuthorizationStateWaitEncryptionKey extends AuthorizationState {
        public boolean isEncrypted;
        public static final int CONSTRUCTOR = 612103496;

        public AuthorizationStateWaitEncryptionKey() {
        }

        public AuthorizationStateWaitEncryptionKey(boolean var1) {
            this.isEncrypted = var1;
        }

        @Override
        public int getConstructor() {
            return 612103496;
        }
    }

    public static class AuthorizationStateWaitTdlibParameters extends AuthorizationState {
        public static final int CONSTRUCTOR = 904720988;

        public AuthorizationStateWaitTdlibParameters() {
        }

        @Override
        public int getConstructor() {
            return 904720988;
        }
    }

    public abstract static class AuthorizationState extends Object {
        public AuthorizationState() {
        }
    }

    public static class AuthenticationCodeTypeFlashCall extends AuthenticationCodeType {
        public String pattern;
        public static final int CONSTRUCTOR = 1395882402;

        public AuthenticationCodeTypeFlashCall() {
        }

        public AuthenticationCodeTypeFlashCall(String var1) {
            this.pattern = var1;
        }

        @Override
        public int getConstructor() {
            return 1395882402;
        }
    }

    public static class AuthenticationCodeTypeCall extends AuthenticationCodeType {
        public int length;
        public static final int CONSTRUCTOR = 1636265063;

        public AuthenticationCodeTypeCall() {
        }

        public AuthenticationCodeTypeCall(int var1) {
            this.length = var1;
        }

        @Override
        public int getConstructor() {
            return 1636265063;
        }
    }

    public static class AuthenticationCodeTypeSms extends AuthenticationCodeType {
        public int length;
        public static final int CONSTRUCTOR = 962650760;

        public AuthenticationCodeTypeSms() {
        }

        public AuthenticationCodeTypeSms(int var1) {
            this.length = var1;
        }

        @Override
        public int getConstructor() {
            return 962650760;
        }
    }

    public static class AuthenticationCodeTypeTelegramMessage extends AuthenticationCodeType {
        public int length;
        public static final int CONSTRUCTOR = 2079628074;

        public AuthenticationCodeTypeTelegramMessage() {
        }

        public AuthenticationCodeTypeTelegramMessage(int var1) {
            this.length = var1;
        }

        @Override
        public int getConstructor() {
            return 2079628074;
        }
    }

    public abstract static class AuthenticationCodeType extends Object {
        public AuthenticationCodeType() {
        }
    }

    public static class AuthenticationCodeInfo extends Object {
        public String phoneNumber;
        public AuthenticationCodeType type;
        public AuthenticationCodeType nextType;
        public int timeout;
        public static final int CONSTRUCTOR = -860345416;

        public AuthenticationCodeInfo() {
        }

        public AuthenticationCodeInfo(String var1, AuthenticationCodeType var2, AuthenticationCodeType var3, int var4) {
            this.phoneNumber = var1;
            this.type = var2;
            this.nextType = var3;
            this.timeout = var4;
        }

        @Override
        public int getConstructor() {
            return -860345416;
        }
    }

    public static class Audio extends Object {
        public int duration;
        public String title;
        public String performer;
        public String fileName;
        public String mimeType;
        public Minithumbnail albumCoverMinithumbnail;
        public Thumbnail albumCoverThumbnail;
        public File audio;
        public static final int CONSTRUCTOR = -1179334690;

        public Audio() {
        }

        public Audio(int var1, String var2, String var3, String var4, String var5, Minithumbnail var6, Thumbnail var7, File var8) {
            this.duration = var1;
            this.title = var2;
            this.performer = var3;
            this.fileName = var4;
            this.mimeType = var5;
            this.albumCoverMinithumbnail = var6;
            this.albumCoverThumbnail = var7;
            this.audio = var8;
        }

        @Override
        public int getConstructor() {
            return -1179334690;
        }
    }

    public static class Animations extends Object {
        public Animation[] animations;
        public static final int CONSTRUCTOR = 344216945;

        public Animations() {
        }

        public Animations(Animation[] var1) {
            this.animations = var1;
        }

        @Override
        public int getConstructor() {
            return 344216945;
        }
    }

    public static class Animation extends Object {
        public int duration;
        public int width;
        public int height;
        public String fileName;
        public String mimeType;
        public boolean hasStickers;
        public Minithumbnail minithumbnail;
        public Thumbnail thumbnail;
        public File animation;
        public static final int CONSTRUCTOR = -872359106;

        public Animation() {
        }

        public Animation(int var1, int var2, int var3, String var4, String var5, boolean var6, Minithumbnail var7, Thumbnail var8, File var9) {
            this.duration = var1;
            this.width = var2;
            this.height = var3;
            this.fileName = var4;
            this.mimeType = var5;
            this.hasStickers = var6;
            this.minithumbnail = var7;
            this.thumbnail = var8;
            this.animation = var9;
        }

        @Override
        public int getConstructor() {
            return -872359106;
        }
    }

    public static class AnimatedChatPhoto extends Object {
        public int length;
        public File file;
        public double mainFrameTimestamp;
        public static final int CONSTRUCTOR = 191994926;

        public AnimatedChatPhoto() {
        }

        public AnimatedChatPhoto(int var1, File var2, double var3) {
            this.length = var1;
            this.file = var2;
            this.mainFrameTimestamp = var3;
        }

        @Override
        public int getConstructor() {
            return 191994926;
        }
    }

    public static class Address extends Object {
        public String countryCode;
        public String state;
        public String city;
        public String streetLine1;
        public String streetLine2;
        public String postalCode;
        public static final int CONSTRUCTOR = -2043654342;

        public Address() {
        }

        public Address(String var1, String var2, String var3, String var4, String var5, String var6) {
            this.countryCode = var1;
            this.state = var2;
            this.city = var3;
            this.streetLine1 = var4;
            this.streetLine2 = var5;
            this.postalCode = var6;
        }

        @Override
        public int getConstructor() {
            return -2043654342;
        }
    }

    public static class AccountTtl extends Object {
        public int days;
        public static final int CONSTRUCTOR = 1324495492;

        public AccountTtl() {
        }

        public AccountTtl(int var1) {
            this.days = var1;
        }

        @Override
        public int getConstructor() {
            return 1324495492;
        }
    }

    public abstract static class Function extends Object {
        public Function() {
        }

        public native String toString();
    }

    public abstract static class Object {
        public Object() {
        }
        public native String toString();

        public abstract int getConstructor();
    }
}
