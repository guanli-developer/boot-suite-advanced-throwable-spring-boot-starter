package tech.guanli.boot.throwable.advanced.configuration;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AdvancedThrowableBanner {
	@PostConstruct
	public void init() {
		StringBuilder bannerBuilder = new StringBuilder();
		bannerBuilder.append(
				"    _       _                               _       _   _                            _     _      \n");
		bannerBuilder.append(
				"   / \\   __| |_   ____ _ _ __   ___ ___  __| |     | |_| |__  _ __ _____      ____ _| |__ | | ___ \n");
		bannerBuilder.append(
				"  / _ \\ / _` \\ \\ / / _` | '_ \\ / __/ _ \\/ _` |_____| __| '_ \\| '__/ _ \\ \\ /\\ / / _` | '_ \\| |/ _ \\\n");
		bannerBuilder.append(
				" / ___ \\ (_| |\\ V / (_| | | | | (_|  __/ (_| |_____| |_| | | | | | (_) \\ V  V / (_| | |_) | |  __/\n");
		bannerBuilder.append(
				"/_/   \\_\\__,_| \\_/ \\__,_|_| |_|\\___\\___|\\__,_|      \\__|_| |_|_|  \\___/ \\_/\\_/ \\__,_|_.__/|_|\\___|");
		bannerBuilder.append("Powered by guanli.tech");
		System.out.println(bannerBuilder.toString());
	}
}
