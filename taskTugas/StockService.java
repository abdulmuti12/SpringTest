@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    // Create Stock
    public Stock createStock(StockDTO stockDTO) {
        Stock stock = Stock.builder()
                .productName(stockDTO.getProductName())
                .quantity(stockDTO.getQuantity())
                .serialNumber(stockDTO.getSerialNumber())
                .additionalInfo(stockDTO.getAdditionalInfo())
                .image(stockDTO.getImage())
                .createdBy("defaultUser")
                .build();
        return stockRepository.save(stock);
    }

    // Get all stocks
    public List<Stock> listStocks() {
        return stockRepository.findAll();
    }

    // Get stock by ID
    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    // Update stock
    public Optional<Stock> updateStock(Long id, StockDTO stockDTO) {
        return stockRepository.findById(id).map(stock -> {
            stock.setProductName(stockDTO.getProductName());
            stock.setQuantity(stockDTO.getQuantity());
            stock.setSerialNumber(stockDTO.getSerialNumber());
            stock.setAdditionalInfo(stockDTO.getAdditionalInfo());
            stock.setImage(stockDTO.getImage());
            stock.setUpdatedBy("defaultUser");
            return stockRepository.save(stock);
        });
    }

    // Delete stock
    public boolean deleteStock(Long id) {
        return stockRepository.findById(id).map(stock -> {
            stockRepository.delete(stock);
            return true;
        }).orElse(false);
    }
}
