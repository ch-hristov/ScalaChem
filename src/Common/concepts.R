# Run as Rscript --vanilla concepts.R path/to/file1 path/to/file2

if (!require(ggplot2)){
    library(ggplot2)
}

args = commandArgs(trailingOnly=TRUE)

# Test if there is at least one argument: if not, return an error
if (length(args) != 2) {
    stop("You must supply 2 files", call.=FALSE)
}

dir <- unlist(strsplit(args[1], "\\/"))
dir <- dir[1]

oo.data.file <- args[1]
fp.data.file <- args[2]

# oo.data.file <- "zip/zip_SpeedUsage_OO.data.tsv"
# fp.data.file <- "zip/zip_SpeedUsage_Func.data.tsv"

# Get the data
oo.data <- read.csv(oo.data.file, header = T, sep = '\t')
fp.data <- read.csv(fp.data.file, header = T, sep = '\t')

# Merge them in a new dataframe.
speed.comparison.k1000.df <- as.data.frame(cbind(oo.data$nodes, oo.data$k1, fp.data$k1))
speed.comparison.k10000.df <- as.data.frame(cbind(oo.data$nodes, oo.data$k2, fp.data$k2))
speed.comparison.k100000.df <- as.data.frame(cbind(oo.data$nodes, oo.data$k3, fp.data$k3))



# Plot the graph. for k = 1000
speed.comparison.plot <- ggplot(speed.comparison.k1000.df, aes(V1)) + 
    geom_line(aes(y = V2, colour = "O.O.")) + 
    geom_line(aes(y = V3, colour = "F.P.")) +
    xlab("atoms") +
    ylab("execution time(ms)") +
    scale_color_discrete(name = "Implementation") + 
    theme(legend.title = element_text(face = "bold"))

png(paste(dir, ".exec.time.comparison.k1000.png", sep = ''))
speed.comparison.plot
dev.off()


# Plot the graph. for k = 10000
speed.comparison.plot <- ggplot(speed.comparison.k10000.df, aes(V1)) + 
    geom_line(aes(y = V2, colour = "O.O.")) + 
    geom_line(aes(y = V3, colour = "F.P.")) +
    xlab("atoms") +
    ylab("execution time(ms)") +
    scale_color_discrete(name = "Implementation") + 
    theme(legend.title = element_text(face = "bold"))

png(paste(dir, ".exec.time.comparison.k10000.png", sep = ''))
speed.comparison.plot
dev.off()


# Plot the graph. for k = 100000
speed.comparison.plot <- ggplot(speed.comparison.k100000.df, aes(V1)) + 
    geom_line(aes(y = V2, colour = "O.O.")) + 
    geom_line(aes(y = V3, colour = "F.P.")) +
    xlab("atoms") +
    ylab("execution time(ms)") +
    scale_color_discrete(name = "Implementation") + 
    theme(legend.title = element_text(face = "bold"))


png(paste(dir, ".exec.time.comparison.k100000.png", sep = ''))
speed.comparison.plot
dev.off()



##############
# Barplot for code length
##############
# code.length.comparison.df <- data.frame(implementation = c("O.O.", "F.P."),
#                                         lines = c(131, 103))
# code.comparison.plot <- ggplot(data = code.length.comparison.df, aes(x = implementation, y = lines, fill = implementation)) + 
#     geom_bar(stat = "identity") + 
#     ylab("Code lines") +
#     xlab("") +
#     scale_fill_discrete(name = "Implementation") + 
#     theme(legend.title = element_text(face = "bold"))
# 
# code.comparison.plot
# 
# png("code.comparison.plot.png")
# code.comparison.plot
# dev.off()