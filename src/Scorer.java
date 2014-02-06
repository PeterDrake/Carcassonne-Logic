public class Scorer {
	public boolean roadComplete(Tile tile) {
		if (!tile.contains(tile.ROAD) || !tile.contains(tile.ROAD_END)) {
			return false;

//			for (Tile iteratedTile : tile.getNeighbors()) {
//				if (tile.isConnected(tile.next)) {
//
//				}
//			}
		}
		return false;	
	}
}