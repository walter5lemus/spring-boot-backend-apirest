package com.spring.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEAwFTzpvVWqVEipO7rTbVlWIHb6gOhWwrd7SODYUC9YLWwitaI\r\n" + 
			"FSs1imncQXvrn/88rMnfrCxYD0lVPWK2fKezT9VuxzMeUPRIp8WUpq8oZWQ6bYp4\r\n" + 
			"+cJoFwrOspkArdeu6vjXji+W+SLsR/Gu+UPwxqtfbmSslqYd/tOoDrhLt3a8xwo9\r\n" + 
			"+UgpscDt3o/4YePMedvkOaEd4pl0n6ANATdLi6UJQ+IikHxD0oLcj70eMAvG4cF7\r\n" + 
			"3/epevgentnu4vKqmSpavc0kNQ7y8pdIQ35fprk18vH42Zin/NPZEPM/EF4Ke3VU\r\n" + 
			"zZ0iK0+4XcjCSqhTamRwLDJP7eikGfrSujAoswIDAQABAoIBAQC5HwuGYA6R2i5m\r\n" + 
			"YjDKExcBIbzyeZwNbWA+qDgEm7OsKjVK7UL+XSCjoVEHFqes0JcuGQDZT7VSwVry\r\n" + 
			"QtkzEpdc+CowQdukP/zOvzZdWaqgLOCwHuBiReS6iQR6kxo8OaV7NRkFGnlOQ3b5\r\n" + 
			"qH6qHeLa1oh8URptxmaIqGDSCkGWy1+r1I35mouxdwrVAmyZlbHDRrMS53jizusS\r\n" + 
			"45duEaQGXKRExKGBd+geKxI9QOPSGwg32LJqvkETxQLd+yfT124adxMiXDhQ/lTm\r\n" + 
			"AAC0dIwiOBSWSyqS2kdJ9Gf7rjDFm+lkEBr0NM3+iGEaUwxsYE//L7vJNb3l5Boc\r\n" + 
			"0s367e/BAoGBAN/w3S3WehNL2nPQuhPO56e94W21nWHIq1iWmW5eP5Zv4USmMW/i\r\n" + 
			"JXzzAeH2GQ2WafQNhLlafRVL8H8QJ3JgB+8QzMReriDHEpx6NnZaLgyP9F39qbsh\r\n" + 
			"09ecefHCaEiJI2aCMJw+rASwZwVjk0cYsviLw1UH/smQrtoHvl4+2d+XAoGBANvd\r\n" + 
			"qJ++YiWLMYW5wgRHIiX/Hh47cO/5TUctGg7NZbI4Cl9Yui9tAp3gG5VuvVogBDiA\r\n" + 
			"y0/eE+dSnv0U9IAFmTNkXxcxkq5xbsJOmyr7YFxY0lJ2LRAcM3v6bFY2db6B+6Bv\r\n" + 
			"WAKY8U0QEVEDrB6iiKN/7M5rMyONoB/YMrxv7ONFAoGAI3HXQDsTRVybLfuaiCoW\r\n" + 
			"hnlKZff5+hEt9a6YiFyIigIZUKlRZ9kOf/FimeY+3uSwzn0ZRdEpvSYw4Zun8rV6\r\n" + 
			"a/9nuakWvH9l1biOSDtL0Jc0YXAV3lWjVxwgPQC9SsXSAZaXpRNSXMei9rplBDrH\r\n" + 
			"kQlmGF5UmIi69C2HlxkxmO8CgYBKsgaMpsh/Sse7T72LaINAd2jLCpS24nKPoNH+\r\n" + 
			"f2dyYbmcZO90F0vRSQb2AJZR3Rix/YeVDbSjXR1oi8r5B23h2NK5dX0IyL7BQqVS\r\n" + 
			"t+4n0YE6xK1QkNQo5Y4SyBO+cjiDa/BxiXZJIRFQ/bdm/P8A1QAlrKPGC2KADxpF\r\n" + 
			"jJzlJQKBgQCuNZi3VNPgX5w9zTDYODl+UVbxf4HOzSj3EEaGPnrENgg53FmGq0vx\r\n" + 
			"aDQJgr6NCVvqZRJIIjeU2kSTkGQbXuuqNxc7yDuqRfIVdMygX0AEdWBbv4q67EgH\r\n" + 
			"s0oJhvNIyRaVyC97/8RZnnuEDq/47IEu47vp3pgxTtZP0jGsnOgAew==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwFTzpvVWqVEipO7rTbVl\r\n" + 
			"WIHb6gOhWwrd7SODYUC9YLWwitaIFSs1imncQXvrn/88rMnfrCxYD0lVPWK2fKez\r\n" + 
			"T9VuxzMeUPRIp8WUpq8oZWQ6bYp4+cJoFwrOspkArdeu6vjXji+W+SLsR/Gu+UPw\r\n" + 
			"xqtfbmSslqYd/tOoDrhLt3a8xwo9+UgpscDt3o/4YePMedvkOaEd4pl0n6ANATdL\r\n" + 
			"i6UJQ+IikHxD0oLcj70eMAvG4cF73/epevgentnu4vKqmSpavc0kNQ7y8pdIQ35f\r\n" + 
			"prk18vH42Zin/NPZEPM/EF4Ke3VUzZ0iK0+4XcjCSqhTamRwLDJP7eikGfrSujAo\r\n" + 
			"swIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";

}
