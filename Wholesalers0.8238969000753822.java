·       Ability to access the sub screens like edit, view and download.
·       Ability to download the branches as format of .csv file
·       User able to find the sub functionalities when he clicks user’s functionality.
·       User able to access the sub functionalities like edit, view and download.
·       If user has access then user able to access this page.
·       If user didn’t have access then redirect to login page.
·       User name should not be empty; username should be unique.
·       Number should not be empty and should be number "/^\d+$/" and should be unique.
·       Clicking on Download Data will allow User to view the results in Excel format.
·       User have the option of filtering the data using the drop down menu
·       Type - This drop down menu will allowing User to select the type User wish to add/edit.
·       The Submit and Reset buttons are given on this screen.
·       Once User have made User selections click on Submit it will add/edit the wholesaler, or click on Reset to reset the selections to the last search.

Solution:

Create a Spring Boot application with a controller, service and repository classes for the Wholesalers feature.

Controller:

@RestController
public class WholesalersController {

    @Autowired
    private WholesalersService wholesalersService;

    @GetMapping("/wholesalers")
    public List<Wholesalers> getAllWholesalers() {
        return wholesalersService.getAllWholesalers();
    }

    @GetMapping("/wholesalers/{id}")
    public Wholesalers getWholesalersById(@PathVariable Long id) {
        return wholesalersService.getWholesalersById(id);
    }

    @PostMapping("/wholesalers")
    public Wholesalers createWholesalers(@RequestBody Wholesalers wholesalers) {
        return wholesalersService.createWholesalers(wholesalers);
    }

    @PutMapping("/wholesalers/{id}")
    public Wholesalers updateWholesalers(@PathVariable Long id, @RequestBody Wholesalers wholesalers) {
        return wholesalersService.updateWholesalers(id, wholesalers);
    }

    @DeleteMapping("/wholesalers/{id}")
    public void deleteWholesalers(@PathVariable Long id) {
        wholesalersService.deleteWholesalers(id);
    }

    @GetMapping("/wholesalers/download")
    @ResponseBody
    public ResponseEntity<Resource> downloadWholesalersData() {
        return wholesalersService.downloadWholesalersData();
    }
}

Service:

@Service
public class WholesalersService {

    @Autowired
    private WholesalersRepository wholesalersRepository;

    public List<Wholesalers> getAllWholesalers() {
        return wholesalersRepository.findAll();
    }

    public Wholesalers getWholesalersById(Long id) {
        return wholesalersRepository.findById(id).orElse(null);
    }

    public Wholesalers createWholesalers(Wholesalers wholesalers) {
        return wholesalersRepository.save(wholesalers);
    }

    public Wholesalers updateWholesalers(Long id