public void initSelfDetails(UUID selfTeamID) {
   selfTeam = teamMap.get(selfTeamID);
   String username = Minecraft.getInstance().getUser().getGameProfile().getName();
   UUID userId = UUID.nameUUIDFromBytes(("OfflinePlayer:" + username).getBytes(StandardCharsets.UTF_8));
   selfKnownPlayer = knownPlayers.get(userId);
   FTBTeams.LOGGER.debug("Client userId: {}", userId);
   knownPlayers.forEach((uuid, player) -> {
      FTBTeams.LOGGER.debug("Known player UUID: {}, Name: {}", uuid, player.name);
   });
   if (selfKnownPlayer == null) {
      FTBTeams.LOGGER.warn("Local player id {} was not found in the known players list [{}]! FTB Teams will not be able to function correctly!",
            userId, String.join(",", knownPlayers.keySet().stream().map(UUID::toString).toList()));
   }
}
