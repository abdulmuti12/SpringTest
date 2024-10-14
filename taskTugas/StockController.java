import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    // API create stock
    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody StockDTO stockDTO) {
        Stock createdStock = stockService.createStock(stockDTO);
        return ResponseEntity.ok(createdStock);
    }

    // API list stock
    @GetMapping
    public ResponseEntity<List<Stock>> listStocks() {
        List<Stock> stocks = stockService.listStocks();
        return ResponseEntity.ok(stocks);
    }

    // API detail stock
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockDetail(@PathVariable Long id) {
        Optional<Stock> stock = stockService.getStockById(id);
        return stock.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // API update stock
    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody StockDTO stockDTO) {
        Optional<Stock> updatedStock = stockService.updateStock(id, stockDTO);
        return updatedStock.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // API delete stock
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        boolean isDeleted = stockService.deleteStock(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET endpoint test
    @GetMapping("/message")
    public String getStocksMessage() {
        return "Daftar Stok Barang";
    }
}
