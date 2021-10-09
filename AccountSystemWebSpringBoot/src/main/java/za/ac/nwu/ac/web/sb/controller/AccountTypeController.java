package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("account type")
public class AccountTypeController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;//

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow,CreateAccountTypeFlow createAccountTypeFlow){
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retrieve all the configured Account types", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account type received", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll(){
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create Account type", notes = "Create a new AccountType in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succesfully created account type", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> create(
        @ApiParam(value = "Request body to create a new AccountType.",required = true)
        @RequestBody AccountTypeDto accountType)
    {
        AccountTypeDto accountTypeResponse = null;//createAccountTypeFlow.create(accountType);
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{mnemonic}")
    @ApiOperation(value = "Account type is fecthed", notes = "Corresponding Mnemonic with Account type is fecthed.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAccountType(
            @ApiParam(value = "Uniquely identified Mnemonic to corresponding Account Type.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic)
    {
        AccountTypeDto accountType  = null;//fetchAccountTypeFlow.getAllAccountTypesByMnemonic(mnemonic);
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
