public class Scorer {
	public boolean roadComplete(Tile tile) {
		if (!tile.containsRoad() || !tile.containsRoadEnd()) {
			return false;
		
		for (Tile tile : neighbors) {
			if (tile.isConnected(tile.next)) {
				
			}
		}
		}	
	}
}